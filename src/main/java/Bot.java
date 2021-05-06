import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot {
    private static final String BOT_USERNAME = "StonkzMasterBot";
    private static final String BOT_TOKEN = "1825473401:AAEaKkkuI7WXiT0xFvWRfG1oqeuySVYgUA4";

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

        System.out.println(update.getMessage().getFrom());

        String command = update.getMessage().getText();


        if (command.startsWith("/")) {
            switch (command) {

                case "/getboyfriend" -> this.sendMessage("@maxithss", update);

                case "/showstonks" -> {
                    HtmlParser htmlParser = new HtmlParser();
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        double coinPrice = htmlParser.getCoinPriceFromRawHtml("https://www.coindesk.com/price/dogecoin");
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
