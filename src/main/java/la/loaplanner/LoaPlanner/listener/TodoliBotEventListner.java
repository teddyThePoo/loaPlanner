package la.loaplanner.LoaPlanner.listener;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        if (message.getContentRaw().equals("!initialize")) {
            sendContentInfo(messageChannel);
        }
    }

    public static void sendContentInfo(MessageChannel messageChannel) {
        try {
            Thread.sleep(1000);
            // 이전 메시지 전체 삭제
            List<Message> messages = messageChannel.getHistory().retrievePast(100).complete();
            messageChannel.purgeMessages(messages);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // embed 구성
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("안녕하세요! 투두리 채널입니다!");
        eb.addField("아르고스", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("발탄노말", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("발탄하드", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("비아노말", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("비아하드", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("쿠크", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("아브12넴", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("아브34넴", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("아브56넴", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("데자뷰", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("리허설", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("도비스", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);
        eb.addField("도디", "🟩 받죠오 받죠오 받죠오 받죠오 ✅ 받죠오 받죠오", false);

        // TODO -------------------------------------------------- //
        // 1) 컨텐츠 이모티콘 만들기 + 객체 추가
        // 2) 컨텐츠 + 캐릭터 조인해서 가져와서 보여주기 (정렬도)
        // 3) 언제 보여줄지 정하기 (업데이트 할때마다? 혹은 주기적인 시간마다)
        // TODO -------------------------------------------------- //

        messageChannel.sendMessageEmbeds(eb.build()).queue();
    }
}
