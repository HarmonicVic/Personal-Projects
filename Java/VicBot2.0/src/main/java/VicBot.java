import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class readTokenFromLocalFile {
    public String readTokenFromFile() throws FileNotFoundException {
        //function to read token from local file
        Scanner readToken = new Scanner(new FileReader("/home/victor/Documents/DiscBot/VicBot.txt"));
        StringBuilder tokenReader = new StringBuilder();

        while (readToken.hasNext()) {
            tokenReader.append(readToken.next());
        }
        readToken.close();

        return tokenReader.toString();
    }
}

public class VicBot {
    public static void main(String[] args) throws FileNotFoundException {
        readTokenFromLocalFile tokenRead = new readTokenFromLocalFile();
//        System.out.println(tokenRead.readTokenFromFile());

        //start bot
        DiscordApi VicBotInstance = new DiscordApiBuilder().setToken(tokenRead.readTokenFromFile()).login().join();

        //ping listener
        VicBotInstance.addMessageCreateListener(event -> {
            if(event.getMessageContent().contains("!!ping")){
                event.getChannel().sendMessage("pong!");
                event.addReactionsToMessage("\uD83D\uDCA5");
            }
        });

        //help command
        VicBotInstance.addMessageCreateListener(event -> {
            if(event.getMessageContent().equalsIgnoreCase("!!help")){
                new MessageBuilder()
                        .setEmbed(new EmbedBuilder()
                            .setTitle("VicBot Help!")
                            .setColor(Color.pink)
                            .setDescription("This bot is currently under construction, for now it only does" +
                                    "the essential stuff for annoying people and/or making stupid reactions and such." +
                                    "If you have any suggestions, contact @Harmonic through DM or in any channel pinging him.")
                        ).send(event.getChannel());
                event.addReaction
            }
        });

        //inserts reaction to "HMM"
        VicBotInstance.addMessageCreateListener(event -> {
            if(event.getMessageContent().toLowerCase().contains("hmm")){
                event.addReactionsToMessage("\uD83E\uDD14");
            }
        });

        //inserts reaction to "lol"
        VicBotInstance.addMessageCreateListener(event -> {
           if(event.getMessageContent().toLowerCase().contains("lol") || event.getMessageContent().toLowerCase().contains("lmao")){
               event.addReactionsToMessage("\uD83D\uDE02");
           }
        });

        //inserts reaction to "oof"
        VicBotInstance.addMessageCreateListener(event -> {
            if (event.getMessageAuthor().isBotUser()) return;

            if(event.getMessageContent().equalsIgnoreCase("oof")){
                event.getChannel().sendMessage("oof indeed...");
                event.addReactionToMessage("\uD83D\uDE14");
            }
        });

        //deletes message that get a "zipper" reaction
        VicBotInstance.addReactionAddListener(event -> {
            if(event.getEmoji().equalsEmoji("\uD83E\uDD10")){
                event.deleteMessage();
            }
        });

//        VicBotInstance.addReactionAddListener(event -> {
//
//        });
    }
}
