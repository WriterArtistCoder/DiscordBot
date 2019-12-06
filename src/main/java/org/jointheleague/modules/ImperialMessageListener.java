package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;
import org.jointheleague.discord_bot_example.Bot;

import net.aksingh.owmjapis.api.APIException;

public class ImperialMessageListener extends CustomMessageCreateListener {
	String[] units = {"inch", "feet", "foot", "ft", "yard", "mile", "acre", "hectacre",
			"pound", "lb", "lbs", "ounce", "oz", "miles per hour", "mph", "Fahrenheit"
	};

	public ImperialMessageListener(String channelName) {
		super(channelName);
	}
	
	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent();
		for (String unit : units) {
			if (message.contains(" "+unit) || message.equals(unit) || message.startsWith(unit+" ")) {
				event.getChannel().sendMessage(Bot.emoji + " Ugh. Imperial units. *scoff*");
			}
		}
	}

}
