package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

/**
 * If the bot hears `ClearChannel`, it will repeatedly send an almost-blank
 * message to clear the channel.
 * 
 * @author https://tinystripz.com
 *
 */
public class ClearMessageListener extends CustomMessageCreateListener {

	public ClearMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent(); // Get the message

		// If the message contains the keyword
		if (containsIgnoreCase(message, "ClearChannel")) {

			// Clear the channel with repeated messages
			event.getChannel().sendMessage(
					".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n");
		}
	}

}
