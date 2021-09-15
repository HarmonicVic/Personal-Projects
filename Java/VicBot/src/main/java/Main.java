import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import java.util.Random;
import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String token = "ODg1MTUzNzYzNjEzMTEwMjcy.YTi5rg.vIVt2nZZOqMxOTGexS2GhVFZeXY";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        //IMPORTANT: bot is going to be using "!!" as prefix

        //ping pong test
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().contains("!!ping")){
                event.getChannel().sendMessage("pong!");
            }
        });

        api.addMessageDeleteListener(event -> {
           event.getChannel().sendMessage("Don't worry I won't tell anyone... _wink_");
        });

        /*api.addMessageCreateListener(event -> {
            String message = event.getMessageContent();
            if (Pattern.matches("/(?:(?:https?|ftp|file)://|www\\.|ftp\\.)(?:\\([-A-Z0-9+&@#/%=~_|$?!:,.]*\\)|[-A-Z0-9+&@#/%=~_|$?!:,.])*(?:\\([-A-Z0-9+&@#/%=~_|$?!:,.]*\\)|[A-Z0-9+&@#/%=~_|$])/igm", message)) {
                System.out.println("test");
                event.getChannel().sendMessage("Be always careful opening random links.");
            }
        });*/

        //help command
        api.addMessageCreateListener(event -> {
           if (event.getMessageContent().contains("!!help")){
               new MessageBuilder()
                       .setEmbed(new EmbedBuilder()
                               .setTitle("VicBot Command list:")
                               .setDescription("!!cat -> Gives a kinda random cat picture! It's so cute :D\n" +
                                                "!!help -> Well you got here so you know what it does.\n" +
                                                "There's also secret commands for you to find out _wink_")
                               .setFooter("More commands to come soon heh")
                               .setColor(Color.pink)
                       )
                       .send(event.getChannel());
           }
        });

        //responds to oof's
        api.addMessageCreateListener(event -> {
           if (event.getMessageContent().equalsIgnoreCase("oof")){
               event.getChannel().sendMessage("oof indeed...");
           }
        });

        //Chin special command
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("Chin")){
                event.getChannel().sendMessage("Hello Chintam, I see you when you sleep.");
            }
        });

        //cat pic summon
        api.addMessageCreateListener(event -> {
           if (event.getMessageContent().contains("!!cat")){
               File dir = new File("C:/Discord/catPictures");
               File[] imageNames = dir.listFiles();
               Random randNum = new Random();

               assert imageNames != null;

               new MessageBuilder()
                       .append("Cute cat incoming")
                       .addAttachment(imageNames[randNum.nextInt(imageNames.length)])
                       .send(event.getChannel());
           }
        });

        api.addMessageCreateListener(event -> {
           if (event.getMessageContent().contains("!!dog")){
               event.getChannel().sendMessage("Yeah sorry we don't have dog pictures right now...");
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               File image = new File("C:/Discord/dogPictures");
               File[] doggos = image.listFiles();
               Random randDoggo = new Random();

               assert doggos != null;

               new MessageBuilder()
                       .setEmbed(new EmbedBuilder()
                               .setTitle("JUST KIDDING WE DO HAVE DOGGOS!")
                               .setImage(doggos[randDoggo.nextInt(doggos.length)])
                               .setColor(Color.red)
                               .setFooter("Ain't he a cute fellow")
                       )
                       .send(event.getChannel());
           }
        });
    }
}
