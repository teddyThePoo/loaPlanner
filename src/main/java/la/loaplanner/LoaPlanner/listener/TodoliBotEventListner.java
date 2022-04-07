package la.loaplanner.LoaPlanner.listener;

import la.loaplanner.LoaPlanner.TodoliBot;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class TodoliBotEventListner extends ListenerAdapter {
    static ArrayList<Long> todoliChannels = new ArrayList<Long>(Arrays.asList(936264760649981953L, 935903279651643473L));
    final static Long BOT_ID = 935897895276797963L;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        User user = event.getAuthor();
        MessageChannel messageChannel = event.getChannel();

        if (!todoliChannels.contains(messageChannel.getIdLong()))
            return;

        if (user.isBot())
            return;

        log.info("[event] onMessageReceived ==============================");
        log.info("유저 id: {} / 채널 id: {} / 메시지  내용: {}", user.getId(), messageChannel.getId(), message.getContentRaw());
        log.info("채널 타입 : {}", messageChannel.getType());

        if (message.getContentRaw().equals("!init")) {
            TodoliBot.sendContentInfo(messageChannel.getIdLong());
        }
    }
}
