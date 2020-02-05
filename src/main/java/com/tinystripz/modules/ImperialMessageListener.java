package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import com.tinystripz.discord_bot_example.Bot;

import net.aksingh.owmjapis.api.APIException;

/**
 * Scoffs if someone uses imperial units. (*scoff*)
 * 
 * @author https://tinystripz.com
 *
 */
public class ImperialMessageListener extends CustomMessageCreateListener {
	String[] units = { "inch", "ft", "mile", "acre", "hectacre", "pound", "lb", "lbs", "ounce", "oz", "miles per hour",
			"mph", "Fahrenheit" };

	public ImperialMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent();
		// For each imperial unit
		for (String unit : units) {
			// If the message contains it with certain restrictions
			// to keep it from recognizing inchworm or other words
			if (containsIgnoreCase(message, " " + unit + " ") || message.endsWith(" " + unit) || message.equals(unit)
					|| message.startsWith(unit + " ")) {
				// Send the message
				event.getChannel().sendMessage(Bot.emoji + " Ugh. Imperial units. *scoff*");
			}
		}
	}

}
