package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import net.aksingh.owmjapis.api.APIException;

/**
 * A template for message listeners.
 * 
 * @author keithgroves and https://tinystripz.com
 *
 */
public abstract class CustomMessageCreateListener implements MessageCreateListener {
	protected String channelName;

	public CustomMessageCreateListener(String channelName) {
		this.channelName = channelName;
	}

	/**
	 * Automatically assigns `MessageCreateEvent`s to `handle()`.
	 * @param event The `MessageCreateEvent` to handle
	 */
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		event.getServerTextChannel().ifPresent(e -> {
			if (e.getName().equals(channelName)) {
				try {
					handle(event);
				} catch (APIException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * A built in method, similar to `str1.contains(str2)` but case-insensitive.
	 * Not related to the Discord API, but helpful for prefixes like `!help`.
	 * @param stringToSearch The string to search for the keyword
	 * @param keyword The keyword
	 * @return If the string contains the keyword
	 */
	public static boolean containsIgnoreCase(String stringToSearch, String keyword) {
		return stringToSearch.toLowerCase().contains(keyword.toLowerCase());
	}

	/**
	 * Event handler to handle when a message is sent on the server. 
	 * @param event The `MessageCreateEvent` to handle
	 * @throws APIException
	 */
	public abstract void handle(MessageCreateEvent event) throws APIException;
}