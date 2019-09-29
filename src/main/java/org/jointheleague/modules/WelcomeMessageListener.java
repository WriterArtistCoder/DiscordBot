package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class WelcomeMessageListener extends CustomMessageCreateListener {

	public WelcomeMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (event.getMessageContent().isEmpty()) {
			event.getChannel().sendMessage("🤮 Welcome to our server! See the #welcome channel for more.");
		}
	}

}
