package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import com.tinystripz.discord_bot_example.Bot;

import net.aksingh.owmjapis.api.APIException;

/**
 * If the bot is mentioned, it will excitedly join the conversation.
 * 
 * @author https://tinystripz.com
 *
 */
public class MentionMessageListener extends CustomMessageCreateListener {

	public MentionMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent();
		// If the message contains "bot" or mentions the bot and the sender is not the bot
		// and is not supposed to trigger SorryMessageListener
		if (!event.getMessageAuthor().isYourself()
				&& (message.contains("@627193414319865899") || containsIgnoreCase(message, "Bot"))
				&& !containsIgnoreCase(message, "sorry")) {
			// Send this
			event.getChannel().sendMessage(Bot.emoji + " Hey guys! Are you talking about ME?");
		}
	}

}
