package com.tinystripz.discord_api;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import com.tinystripz.modules.*;

/**
 * Launches all of the listeners for one channel.
 * @author keithgroves and https://tinystripz.com
 *
 */
public class Bot {

	public static String emoji = "<:vomiting_robot:642414033290657803>"; // The emoji Watchbot prefixes all its messages with
	
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
		api.addMessageCreateListener(new PrintMessageListener(channelName));
		// api.addMessageCreateListener(new VomitMessageListener(channelName));
		// api.addMessageCreateListener(new SmokeMessageListener(channelName));
		// api.addMessageCreateListener(new MentionMessageListener(channelName));
		// api.addMessageCreateListener(new BootMessageListener(channelName));
		// api.addMessageCreateListener(new ClearMessageListener(channelName));
		// api.addMessageCreateListener(new SorryMessageListener(channelName));
		// api.addMessageCreateListener(new ImperialMessageListener(channelName));
		// api.addMessageCreateListener(new NicknameMessageListener(channelName));
	}
}
