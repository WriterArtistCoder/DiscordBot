package com.tinystripz.modules;

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

/**
 * If the bot sees a swear word, it will recommend funny but still good
 * alternatives from The Good Place.
 * 
 * @author https://tinystripz.com
 *
 */
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
			if (containsIgnoreCase(message, word) && !event.getMessageAuthor().isYourself()) {
				containsSwear = true;
				ArrayList<String> replace = swearReplace.get(i);
				int rand = new Random().nextInt(replace.size());

				message = message.replaceAll(word, replace.get(rand));
			}
		}

		// If the message contains a swear word
		if (containsSwear) {
			// Send an censored version
			event.getChannel().sendMessage("<:vomiting_face_with_symbols:639605901627621397> How about:");
			event.getChannel().sendMessage("```" + message + "```");
		}
	}

	/**
	 * Parses the swear words and replacements from the JSON file.
	 * 
	 * @author https://tinystripz.com
	 * 
	 */
	public static void swearSetup() {
		// Get the swear word and replacement lists
		swearWords = new ArrayList<>();
		swearReplace = new ArrayList<>();

		try {
			// Import the list from the JSON file
			Object obj = new JSONParser().parse(new FileReader(new File("src/main/resources/swear_replace.json")));
			JSONArray json = (JSONArray) obj;

			// For each array containing the swear word and the replacements
			for (int i = 0; i < json.size(); i++) {
				JSONArray arr = (JSONArray) json.get(i); // Get the array
				swearWords.add((String) arr.get(0)); // Add the swear word to this class' swear word list

				// Create an ArrayList of swear word replacements
				ArrayList<String> addArr = new ArrayList<String>();
				for (Object o : arr) {
					addArr.add((String) o);
				}

				// Removes real swear word from list
				addArr.remove(0);
				// Adds replacement list to local list of replacements
				swearReplace.add(addArr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
