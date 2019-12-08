package com.tinystripz.discord_bot_example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utilities {
	private Utilities() {

	}

	/**
	 * 
	 * @return BotInfo
	 */
	public static BotInfo loadBotsFromJson() {
		JSONParser parser = new JSONParser();
		try {
			// Import and parse JSON file
			FileReader fr = new FileReader(new File("src/main/resources/config.json"));
			JSONObject json = (JSONObject) parser.parse(fr);

			// Get the array of channels and API token
			JSONArray channels = (JSONArray) json.get("channels");
			String token = (String) json.get("token");

			// Create a BotInfo and set the channels
			BotInfo info = new BotInfo();
			info.setChannels(Arrays.copyOf(channels.toArray(), channels.size(), String[].class));
			info.setToken(token);

			return info;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

//		try (Reader reader = new InputStreamReader(
//				Utilities.class.getClassLoader().getResourceAsStream("config.json"))) {
//			System.out.println("Loading bots");
//			Gson gson = new GsonBuilder().create();
//			return gson.fromJson(reader, new TypeToken<Map<String, BotInfo>>(){}.getType());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.err.println("Failed to load bots");
		return null;
	}
}
