package com.binance4j.websocket.client;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.UserDataUpdate;

/** Websocket client handling user data / balance events */
public class WebsocketUserDataClient extends BaseWebsocketClient<UserDataUpdate> {
	/** The inner user data client. */
	final UserDataClient userDataClient;

	/** The timer responsible to schedule the keep alive task. */
	Timer timer;

	/** The keep alive task schedule interval. Default 30 minutes. */
	Duration keepAliveInterval = Duration.ofMinutes(30);

	/**
	 * @param client   The {@link UserDataClient} that will fetch the listen key to open the stream and keep it alive at a.
	 *                     periodical interval.
	 * @param callback The callback.
	 * @throws ApiException Will be thrown if the client is unable to fetch the listen key
	 */
	public WebsocketUserDataClient(UserDataClient client, WebsocketCallback<UserDataUpdate> callback) throws ApiException {
		super(null, client.startUserDataStream().execute().listenKey(), UserDataUpdate.class, callback);
		userDataClient = client;
	}

	@Override
	public void open() {
		super.open();
		// let's start the keep alive task
		timer = new Timer();
		timer.schedule(new KeepAliveTask(), keepAliveInterval.toMillis(), keepAliveInterval.toMillis());
	}

	@Override
	public void close() {
		super.close();
		// let's stop the keep alive task
		timer.cancel();
	}

	/** The task responsible of keeping alive the listenKey. */
	private class KeepAliveTask extends TimerTask {
		@Override
		public void run() {
			userDataClient.keepAliveUserDataStream(stream);
		}
	}

	/**
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @return the keepAliveInterval
	 */
	public Duration getKeepAliveInterval() {
		return keepAliveInterval;
	}
}