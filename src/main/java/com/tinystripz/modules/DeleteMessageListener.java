package com.tinystripz.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

/**
 * Deletes latest specified number of messages (only works with people who have permission to delete messages.)
 * 
 * @author https://tinystripz.com
 *
 */
public class DeleteMessageListener extends CustomMessageCreateListener {

	public DeleteMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent();
		if (message.matches("DelMessages \\d") &&
			event.getMessageAuthor().canManageMessagesInTextChannel()) { // If message matches command, and message author is authorized to delete messages
			// Gets number of messages to mass delete from command
			int numDel = Integer.parseInt(message.substring(message.indexOf(" ")+1));
			System.out.println(numDel);

			
			// Delete requested number
        	for (int i = 0; i < numDel; i++) {
				// Delete latest message
			}
		}
	}

}
