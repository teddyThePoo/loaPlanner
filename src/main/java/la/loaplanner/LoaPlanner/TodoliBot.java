package la.loaplanner.LoaPlanner;

import la.loaplanner.LoaPlanner.listener.TodoliBotEventListner;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;
import java.util.List;

@Component
public class TodoliBot {
    private static JDA jda = null;
    private static final String BOT_TOKEN = "";

    @PostConstruct
    public void init() throws LoginException {
        jda = JDABuilder.createDefault(BOT_TOKEN)
                .addEventListeners(new TodoliBotEventListner())
                .build();
    }

    public static void sendContentInfo(Long channelId) {
        MessageChannel messageChannel = jda.getTextChannelById(channelId);

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
        eb.addField(":unicorn: 아르고스", "🟩 받죠오 죠뎀닉 와죠오 ✅ ", false);
        eb.addField("\uD83D\uDC79 발탄 노말", "🟩 와죠오 ✅ ", false);
        eb.addField("\uD83D\uDC79 발탄 하드", "🟩 받죠오 ✅ 죠뎀닉 ", false);
        eb.addField(":bat: 비아키스 노말", "🟩 ✅ 와죠오 ", false);
        eb.addField(":bat: 비아키스 하드", "🟩 죠뎀닉 ✅ ", false);
        eb.addField(":clown: 쿠크세이튼 노말", "🟩 받죠오 ✅ ", false);
        eb.addField(":smiling_imp: 아브렐슈드 12넴", "🟩 받죠오 ✅ ", false);
        eb.addField(":smiling_imp: 아브렐슈드 34넴", "🟩 받죠오 ✅ ", false);
        eb.addField(":smiling_imp: 아브렐슈드 56넴", "🟩 ✅ ", false);
        eb.addField(":clown: 리허설", "🟩 와죠오 ✅ ", false);
        eb.addField(":smiling_imp: 데자뷰", "🟩 ✅ ", false);
        eb.addField(":black_joker: 도비스", "🟩 죠뎀닉 ✅ ", false);
        eb.addField(":seedling: 도디언", "🟩 죠뎀닉 ✅ ", false);
        eb.setFooter("로아 플래너 url : @@@");

        // TODO -------------------------------------------------- //
        // 1) 컨텐츠 이모티콘 만들기 + 객체 추가
        // 2) 컨텐츠 + 캐릭터 조인해서 가져와서 보여주기 (정렬도)
        // 3) 언제 보여줄지 정하기 (업데이트 할때마다? 혹은 주기적인 시간마다)
        // TODO -------------------------------------------------- //

        messageChannel.sendMessageEmbeds(eb.build()).queue();
    }
}
