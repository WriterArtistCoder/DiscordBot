package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import com.tinystripz.discord_bot_example.Bot;

import net.aksingh.owmjapis.api.APIException;

/**
 * If the bot senses smoking in the message, it will remind the sender not to
 * smoke.
 * 
 * @author https://tinystripz.com
 *
 */
public class SmokeMessageListener extends CustomMessageCreateListener {
	// Smoking keywords
	public static String[] smokeWords = new String[] { "smok", "🚬", "cigar" };

	public SmokeMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (!event.getMessageAuthor().isYourself()) {
			// For each keyword
			for (String s : smokeWords) {
				// If message contains it
				if (event.getMessageContent().contains(s)) {
					// React with 🚭
					event.addReactionsToMessage("🚭");
					// Send warning
					event.getChannel().sendMessage("\n" + Bot.emoji
							+ "🚭 **SMOKE DETECTOR ACTIVATED. WE WOULD LIKE TO REMIND YOU NOT TO SMOKE ON THIS DISCORD SERVER. THANK YOU.** 🚭");
					break;
				}
			}
		}
	}

}
