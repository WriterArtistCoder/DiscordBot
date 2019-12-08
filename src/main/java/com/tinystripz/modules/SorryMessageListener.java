package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import com.tinystripz.discord_bot_example.Bot;

import net.aksingh.owmjapis.api.APIException;

/**
 * If a message is sent mentioning the bot and saying "sorry", the bot will say
 * it's no problem.
 * 
 * @author https://tinystripz.com
 *
 */
public class SorryMessageListener extends CustomMessageCreateListener {

	public SorryMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent();
		// If the sender is not the bot and the message mentions the bot
		// and message contains "sorry"
		if (!event.getMessageAuthor().isYourself()
				&& (message.contains("<@627193414319865899>") && containsIgnoreCase(message, "sorry"))) {
			// Send this
			event.getChannel()
					.sendMessage(Bot.emoji + " No problem. Just, constant retching is an important thing to reinforce.");
			event.getChannel().sendMessage(Bot.emoji + " Sorry if I came off a little harsh.");
		}
	}

}
