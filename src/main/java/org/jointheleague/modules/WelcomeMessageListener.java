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
			event.getChannel().sendMessage("<:vomiting_robot:642414033290657803> Welcome to our server! See the <#627571253536096260> channel for more.");
		}
	}

}
