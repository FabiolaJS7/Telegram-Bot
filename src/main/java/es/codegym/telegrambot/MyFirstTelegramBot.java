package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "Mjscruse7_bot";
    public static final String TOKEN = "7983766098:AAEVibJtaJ6Z9jHHDvuYzPxSSO4zfvqO0eA";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if (getMessageText().equals("/start")) {
            sendTextMessageAsync("_Hola, *bienvenido a mi bot*!");
        }

        if (getMessageText().contains("hola")) {
            sendTextMessageAsync("Hola, Cuál es tu nombre?");
        }

        if (getMessageText().contains("mi nombre es") || getMessageText().contains("nombre")) {
            sendTextMessageAsync("Mucho gusto, mi nombre es *Gato*");
        }


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}