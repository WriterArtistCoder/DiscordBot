package org.jointheleague.discord_bot_example;

import org.javacord.api.DiscordApi; 
import org.javacord.api.DiscordApiBuilder;
import org.jointheleague.modules.*;

public class Bot  {

	public static String emoji = "<:vomiting_robot:642414033290657803>";
	private String token;
	private String channelName;
	DiscordApi api;

	public Bot(String token, String channelName) {
		this.token = token;
		this.channelName = channelName;
	}

	public void connect(boolean printInvite) {
		api = new DiscordApiBuilder().setToken(token).login().join();
		if (printInvite) {
			System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
		}
		
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


