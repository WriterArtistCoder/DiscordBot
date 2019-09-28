package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class VomitMessageListener extends CustomMessageCreateListener {

	public VomitMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent();

		if (!event.getMessageAuthor().isYourself()) {
			String newMessage = message;

			if (!message.startsWith("🤮")) {
				newMessage = "🤮 " + newMessage;
			}

			if (!message.endsWith("🤮")) {
				newMessage = newMessage + " 🤮";
			}
			
			newMessage.replaceAll("🤮", ":vomiting:");
			
			event.deleteMessage();
			event.getChannel().sendMessage("*"+event.getMessageAuthor().getDisplayName()+"* "+newMessage);
		}
	}

}
