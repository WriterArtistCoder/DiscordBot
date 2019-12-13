package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class AllMessageListener extends CustomMessageCreateListener {

	public AllMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		System.out.println("Message: " + event.getMessageContent());
		System.out.println("Author: " + event.getMessageAuthor());
		System.out.println();
	}

}
