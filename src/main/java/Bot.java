import objects.Coin;
import objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "StonkzMasterBot";
    private static final String BOT_TOKEN = "1825473401:AAEaKkkuI7WXiT0xFvWRfG1oqeuySVYgUA4";

    private final ArrayList<User> users = new ArrayList<>();

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        String command = update.getMessage().getText();

        User userToAdd = new User((
                update.getMessage().getFrom().getId()),
                update.getMessage().getFrom().getFirstName(),
                update.getMessage().getFrom().getLastName(),
                update.getMessage().getFrom().getIsBot(),
                update.getMessage().getFrom().getUserName(),
                update.getMessage().getFrom().getLanguageCode(),
                new Coin("dogecoin",0.61, 1075));


        if (users.size() > 0) {
            users.forEach(user -> {
                if(user.getUserId() != userToAdd.getUserId()) {
                    users.add(userToAdd);
                }
            });
        } else {
            users.add(userToAdd);
        }

        System.out.println(users.size());

        if (command.startsWith("/")) {
            switch (command) {

                case "/showowner" -> this.sendMessage("@maxithss", update);

                case "/showstonks" -> {
                    HtmlParser htmlParser = new HtmlParser();
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        double coinPrice = htmlParser.getCoinPriceFromRawHtml("https://www.coindesk.com/price/", users.get(0).getCoin().getCoinName());
                        double invested = 270;
                        double amountOfCoins = 1075.12;
                        double dollarToEuroCourse = 0.83;
                        double dollars = Math.round(coinPrice * amountOfCoins);
                        double euros = dollars * dollarToEuroCourse;
                        stringBuilder.append(dollars).append(" $").append("\n");
                        stringBuilder.append(euros).append(" €").append("\n");
                        stringBuilder.append("You're ").append(Math.round(euros - invested)).append(" € ahead");
                        this.sendMessage(stringBuilder.toString(), update);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                default -> this.sendMessage("Unknown command", update);
            }
        }
    }


    private void sendMessage(String messageToSend, Update update) {
        if (messageToSend != null) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(messageToSend);
            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
            try {
                execute(sendMessage);
            }catch (Exception e) {
                System.out.println("Couldn't send message:\n" + e.getMessage());
            }
        }
    }
}
