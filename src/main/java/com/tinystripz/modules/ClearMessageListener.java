package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

/**
 * If the bot hears "Code 04222018", it will repeatedly send an almost-blank
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
		// If the message contains the keyword
		if (containsIgnoreCase(event.getMessageContent(), "Code 04222018")) {
			// Clear the channel with repeated messages
			event.getChannel().sendMessage(
					".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n");
		}
	}

}
