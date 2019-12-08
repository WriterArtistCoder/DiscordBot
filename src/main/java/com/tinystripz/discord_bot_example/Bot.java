package com.tinystripz.discord_bot_example;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import com.tinystripz.modules.*;

/**
 * Launches all of the listeners for one channel.
 * @author keithgroves and https://tinystripz.com
 *
 */
public class Bot {

	// The string to show the custom :vomiting_robot: emoji
	public static String emoji = "<:vomiting_robot:642414033290657803>";

	private String token;
	private String channelName;
	DiscordApi api;

	public Bot(String token, String channelName) {
		this.token = token;
		this.channelName = channelName;
	}

	public void connect(boolean printInvite) {
		// Why Keith? Couldn't you have commented what this does? Sigh...
		api = new DiscordApiBuilder().setToken(token).login().join();

		// Print the URL to invite the bot
		if (printInvite) {
			System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
		}

		// Load all the bots
		api.addMessageCreateListener(new VomitMessageListener(channelName));
		api.addMessageCreateListener(new SmokeMessageListener(channelName));
		api.addMessageCreateListener(new MentionMessageListener(channelName));
		api.addMessageCreateListener(new BootMessageListener(channelName));
		api.addMessageCreateListener(new ClearMessageListener(channelName));
		api.addMessageCreateListener(new SorryMessageListener(channelName));
		api.addMessageCreateListener(new SwearMessageListener(channelName));
		api.addMessageCreateListener(new ImperialMessageListener(channelName));
	}
}
