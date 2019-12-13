package com.tinystripz.modules;

import java.util.ArrayList;

import org.javacord.api.event.message.MessageCreateEvent;

import com.tinystripz.discord_bot_example.Bot;

import net.aksingh.owmjapis.api.APIException;

/**
 * If the bot does not see a vomiting emoji in the message, it will remind the
 * sender to use them.
 * 
 * @author https://tinystripz.com
 *
 */
public class VomitMessageListener extends CustomMessageCreateListener {

	boolean runListener = true; // Run the listener?
	String[] prefixes = { "🤮", "<:vomit" }; // Prefixes acceptable as vomiting emojis
	ArrayList<String> freeForAll;

	public VomitMessageListener(String channelName) {
		super(channelName);
		// Make an ArrayList of Free for All channels (not #test)
		freeForAll = new ArrayList<>();
		freeForAll.add("memes");
		freeForAll.add("requests");
		freeForAll.add("no-🤮");

		// If the channel is a Free for All channel, don't run the listener
		if (freeForAll.contains(channelName)) {
			runListener = false;
		}
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		// If the listener should be run
		if (runListener) {
			// If the sender isn't the bot and the message isn't empty
			if (!event.getMessageAuthor().isYourself() && !event.getMessageContent().isEmpty()) {
				String message = event.getMessageContent(); // Get the message
				boolean vomit = false; // Is there a vomiting emoji?

				// For each prefix
				for (String p : prefixes) {
					// If the message contains it
					if (message.contains(p)) {
						// There is a vomiting emoji
						vomit = true;
						break;
					}
				}

				// If there's not a vomiting emoji
				if (!vomit) {
					// Send a reminder
					event.getChannel().sendMessage(Bot.emoji + " Hey, man, where the vomiting emojis at?");
				}
			}
		}
	}

}