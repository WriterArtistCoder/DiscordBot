package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class BootMessageListener extends CustomMessageCreateListener {

	public BootMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (event.getMessageContent().contains("ive me the boot")) {
			event.getChannel().sendMessage("Are you sure you want it?\n.\n");
			event.getChannel().sendMessage("You ➡ 😨   👢💨\n.\n");
			event.getChannel().sendMessage("🤕 Sorry!");
		}
	}

}
