package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import com.tinystripz.discord_bot_example.Bot;

import net.aksingh.owmjapis.api.APIException;

/**
 * If a user says "Give me the boot", it will say "Are you sure you want it?"
 * and then throw a boot at them in emojis.
 * 
 * @author https://tinystripz.com
 *
 */
public class BootMessageListener extends CustomMessageCreateListener {

	public BootMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		// If the message contains the keyword
		if (containsIgnoreCase(event.getMessageContent(), "give me the boot")) {
			// Send this
			event.getChannel().sendMessage(Bot.emoji + " Are you sure you want it?");
			event.getChannel().sendMessage(Bot.emoji + " You ➡ 😨              👢💨");
			event.getChannel().sendMessage(Bot.emoji + " 🤕 Sorry!");
		}
	}

}
