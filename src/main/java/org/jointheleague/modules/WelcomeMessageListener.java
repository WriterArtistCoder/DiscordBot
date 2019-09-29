package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class WelcomeMessageListener extends CustomMessageCreateListener {

	public WelcomeMessageListener() {
		super("welcome");
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (!event.getMessageAuthor().isServerAdmin()) {
			event.deleteMessage();
		}
	}

}
