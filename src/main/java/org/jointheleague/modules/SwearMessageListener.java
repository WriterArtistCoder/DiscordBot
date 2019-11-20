package org.jointheleague.modules;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.javacord.api.event.message.MessageCreateEvent;

import net.aksingh.owmjapis.api.APIException;

public class SwearMessageListener extends CustomMessageCreateListener {

	static ArrayList<String> swearWords;
	static ArrayList<ArrayList<String>> swearReplace;
	
	public SwearMessageListener(String channelName) {
		super(channelName);
		swearSetup();
	}

	@Override
	public void handle(MessageCreateEvent event) throws APIException {
		String message = event.getMessageContent();
		boolean containsSwear = false;
		
		for (int i = 0; i < swearWords.size(); i++) {
			String word = swearWords.get(i);
			if (message.contains(word) && !event.getMessageAuthor().isYourself()) {
				containsSwear = true;
				ArrayList<String> replace = swearReplace.get(i);
				int rand = new Random().nextInt(replace.size());
				
				message = message.replaceAll(word, replace.get(rand));
			}
		}
		
		if (containsSwear) {
			event.getChannel().sendMessage("<:vomiting_face_with_symbols:639605901627621397> How about:");
			event.getChannel().sendMessage("```"+message+"```");
		}
	}
	
	public static void swearSetup() {
		swearWords = new ArrayList<>();
		swearReplace = new ArrayList<>();
		
		try {
			Object obj = new JSONParser().parse(new FileReader(new File("src/main/resources/swear_replace.json")));
			JSONArray json = (JSONArray) obj;
			
			for (int i = 0; i < json.size(); i++) {
				JSONArray arr = (JSONArray) json.get(i);
				swearWords.add((String) arr.get(0));
				
				ArrayList<String> addArr = new ArrayList<String>();
				for (Object o : arr) {
					addArr.add((String) o);
				}
				
				addArr.remove(0); // Removes real swear word from replacement list
				swearReplace.add(addArr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
