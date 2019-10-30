package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class SorryMessageListener extends CustomMessageCreateListener {

	public SorryMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent();
		if (!event.getMessageAuthor().isYourself() && (message.contains("<@627193414319865899>")
				&& (message.contains("sorry") || containsIgnoreCase(message, "sorry")))) {
			event.getChannel().sendMessage("🤮 No problem. Just, constant retching is an important thing to reinforce.");
			event.getChannel().sendMessage("🤮 Sorry if I came off a little harsh.");
		}
	}

}
