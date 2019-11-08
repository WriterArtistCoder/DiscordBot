package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import net.aksingh.owmjapis.api.APIException;

public abstract class CustomMessageCreateListener implements MessageCreateListener {
	protected String channelName;

	public CustomMessageCreateListener(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		event.getServerTextChannel().ifPresent(e -> {
			if (e.getName().equals(channelName)) {
				try {
					handle(event);
				} catch (APIException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public boolean containsIgnoreCase(String stringToSearch, String keyword) {
		return stringToSearch.toLowerCase().contains(keyword.toLowerCase());
	}

	public abstract void handle(MessageCreateEvent event) throws APIException;
}