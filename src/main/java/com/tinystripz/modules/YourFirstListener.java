package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

/**
 * This is your first listener! Fill in the code in `handle()`.
 * 
 * @author https://tinystripz.com
 *
 */
public class YourFirstListener extends CustomMessageCreateListener {

    public YourFirstListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
        String message = event.getMessageContent(); // Get the message

        // Your code here

        event.getChannel().sendMessage("Lorem ispum sit amet"); // Reply
	}

}
