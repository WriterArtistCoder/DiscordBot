package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class VomitMessageListener extends CustomMessageCreateListener {

	public VomitMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (!event.getMessageAuthor().isYourself()) {
			String message = event.getMessageContent();
			
			if (!((message.startsWith("🤮") || (message.startsWith("<:vomiting"))))) {
				event.getChannel().sendMessage("🤮 Hey, man, where the vomiting emojis at?");
			}
		}
	}

}