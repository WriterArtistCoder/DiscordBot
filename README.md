# DiscordBot
This is a Java template for my Discord bots! Written by Discord user `WriterArtistCoder#6032`.

## Set up the bot
Go to the [config file](src/main/resources/config.json) and add the channels you want the bot to manage to `channels` as strings. Then add the Discord API token to `token`.

## Modify the bot
An example listener is located in [YourFirstListener](src/main/java/com/tinystripz/modules/YourFirstListener.java). When you finish coding a listener, uncomment Line 38 of [Bot](src/main/java/com/tinystripz/discord_api/Bot.java). If you want to make more listeners, follow a similar process, just replacing `YourFirstListener` with whatever name you want to use.

## Run the bot
Open the command line in your project folder and run the following command:

`mvn clean compile exec:java`

## Project structure

### Packages
- `discord_api` - This package contains the basic Discord API handling stuff.
- `modules` - This package contains the listeners.