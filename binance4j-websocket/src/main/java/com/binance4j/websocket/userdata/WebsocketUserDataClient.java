package com.binance4j.websocket.userdata;

import com.binance4j.core.exception.ApiException;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Websocket client handling user data / balance events
 */
@EqualsAndHashCode(callSuper = true)
public class WebsocketUserDataClient extends BaseWebsocketClient<UserDataUpdatePayload> {
	private final UserDataClient userDataClient;

	/**
	 * The timer responsible to schedule the keep alive task
	 */
	@Getter
	private Timer timer;

	/**
	 * The keep alive task schedule interval. Default 30 minutes.
	 */
	@Getter
	@Setter
	private Duration keepAliveInterval = Duration.ofMinutes(30);

	/**
	 * Constructor
	 *
	 * @param client The {@link UserDataClient} that will fetch the listen key to
	 *               open the stream and keep it alive at a periodical interval
	 * @throws ApiException Will be thrown if the client is unable to fetch the
	 *                      listen key
	 */
	public WebsocketUserDataClient(UserDataClient client,
	                               WebsocketCallback<UserDataUpdatePayload> callback) throws ApiException {
		super(null, client.startUserDataStream().execute().getListenKey(), UserDataUpdatePayload.class, callback);
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

	/**
	 * The task responsible of keeping alive the listenKey
	 */
	private class KeepAliveTask extends TimerTask {
		@Override
		public void run() {
			userDataClient.keepAliveUserDataStream(stream);
		}
	}
}
