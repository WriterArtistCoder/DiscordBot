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
		if (!event.getMessageAuthor().isYourself()
				&& (message.contains("<@627193414319865899>") || containsIgnoreCase(message, "Bot")) && !containsIgnoreCase(message, "sorry")) {
			event.getChannel().sendMessage("<:vomiting_robot:642414033290657803> Hey guys! Are you talking about ME?");
		}
	}

}
