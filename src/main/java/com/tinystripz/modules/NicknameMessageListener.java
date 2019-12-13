package com.tinystripz.modules;

import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class NicknameMessageListener extends CustomMessageCreateListener {

	Pattern trigger; // The regex that triggers the bot
	Matcher matcher; // The Matcher for the regex
	Server server; // The server the bot is on

	public NicknameMessageListener(String channelName) {
		super(channelName);

		// A regex pattern for someone's nickname to change
		trigger = Pattern.compile("ChangeNickname <@!(\\d+)> <(.+)>");
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent(); // Get the message
		matcher = trigger.matcher(message); // Search the message for the ChangeNickname command
		
		// Sets the server variable as the current server
		if (server == null) {
			server = event.getServer().get();
		}
							
		// If the command is found in the message
		if (matcher.find()) {
			// Get the ID of the user whose nickname the sender wants changed
			String userId = matcher.group(1);
			// The nickname the sender wants to change it to
			String nick = matcher.group(2);
			
			
			try {
				// Get the targeted user
				User user = event.getApi().getUserById(userId).get();
				// Update their nickname
				user.updateNickname(server, nick);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
