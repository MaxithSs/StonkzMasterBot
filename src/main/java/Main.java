import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Main Class.
 * https://www.freecodecamp.org/news/telegram-push-notifications-58477e71b2c2/
 */
public class Main {
    // TODO: 06.05.21 depending on language code -> integrate translations

    /**
     * Main method.
     * @param args args
     */
    public static void main(final String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException telegramApiException) {
            telegramApiException.printStackTrace();
        }
    }
}
