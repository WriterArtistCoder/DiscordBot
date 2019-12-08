package com.tinystripz.discord_bot_example;

/**
 * A class to store the list of channels and API token from the `config.json`
 * file.
 * 
 * @author keithgroves and https://tinystripz.com
 *
 */
public class BotInfo {

	private String[] channels;
	private String token;

	public String[] getChannels() {
		return channels;
	}

	public void setChannels(String[] channels) {
		this.channels = channels;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}