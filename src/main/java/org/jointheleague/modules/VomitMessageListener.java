package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class VomitMessageListener extends CustomMessageCreateListener {

	boolean runListener = true;
	String[] prefixes = { "🤮", "<:vomit" };

	public VomitMessageListener(String channelName) {
		super(channelName);
		if (channelName.equals("no-🤮")) {
			runListener = false;
		}
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (runListener) {
			System.out.println("Message: " + event.getMessageContent());
			System.out.println("Author: " + event.getMessageAuthor());

			if (!event.getMessageAuthor().isYourself() && !event.getMessageContent().isEmpty()) {
				String message = event.getMessageContent();

				boolean vomit = false;
				for (String p : prefixes) {
					if (message.contains(p)) {
						vomit = true;
						break;
					}
				}

				if (!vomit) {
					event.getChannel().sendMessage(
							"<:vomiting_robot:642414033290657803> Hey, man, where the vomiting emojis at?");
				}
			}
		}
	}

}