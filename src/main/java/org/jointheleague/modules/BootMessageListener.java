package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.discord_bot_example.Bot;

import net.aksingh.owmjapis.api.APIException;

public class BootMessageListener extends CustomMessageCreateListener {

	public BootMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (event.getMessageContent().contains("ive me the boot")) {
			event.getChannel().sendMessage(Bot.emoji + " Are you sure you want it?");
			event.getChannel().sendMessage(Bot.emoji + " You ➡ 😨              👢💨");
			event.getChannel().sendMessage(Bot.emoji + " 🤕 Sorry!");
		}
	}

}
