package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class MentionMessageListener extends CustomMessageCreateListener {

	public MentionMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent();
		if (message.contains("<@627193414319865899>") || message.contains("bot") || message.contains("Bot")) {
			event.getChannel().sendMessage("🤮 Hey guys! Are you talking about ME?");
		}
	}

}
