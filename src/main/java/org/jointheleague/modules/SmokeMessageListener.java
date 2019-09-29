package org.jointheleague.modules;

import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class SmokeMessageListener extends CustomMessageCreateListener {

	public SmokeMessageListener(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		if (!event.getMessageAuthor().isYourself()) {
			boolean smoke = false;
			String[] smokingChars = new String[] { "smok", "🚬", "cigar" };

			for (String s : smokingChars) {
				if (event.getMessageContent().contains(s)) {
					smoke = true;
					break;
				}
			}
			
			if (smoke) {
				event.addReactionsToMessage("🚭");
				event.getChannel().sendMessage(
						"\n🤮 🚭 **SMOKE DETECTOR ACTIVATED. WE WOULD LIKE TO REMIND YOU NOT TO SMOKE ON THIS DISCORD SERVER. THANK YOU.** 🚭");
			}
		}
	}

}
