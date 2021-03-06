package game;

import game.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMissionAchieved_SendMessage(@Payload MissionAchieved missionAchieved){

        if(missionAchieved.isMe()){
            System.out.println("##### listener SendMessage : " + missionAchieved.toJson());

            Notification noti = new Notification();
            noti.setMissionId(missionAchieved.getId());
            noti.setMessage("MISSION ACHIEVED!");

            notificationRepository.save(noti);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAllocated_SendMessage(@Payload Allocated allocated){

        if(allocated.isMe()){
            System.out.println("##### listener SendMessage : " + allocated.toJson());

            Notification noti = new Notification();
            noti.setRewardId(allocated.getId());
            noti.setMessage("REWARD ALLOCATED!");

            notificationRepository.save(noti);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverIssued_SendMessage(@Payload Issued issued){

        if(issued.isMe()){
            System.out.println("##### listener SendMessage : " + issued.toJson());

            Notification noti = new Notification();
            noti.setWalletId(issued.getId());
            noti.setStatus(issued.getStatus());
            noti.setMessage("WALLET ISSUED!");

            notificationRepository.save(noti);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverExchanged_SendMessage(@Payload Exchanged exchanged){

        if(exchanged.isMe()){
            System.out.println("##### listener SendMessage : " + exchanged.toJson());

            Notification noti = new Notification();
            noti.setWalletId(exchanged.getId());
            noti.setStatus(exchanged.getStatus());
            noti.setMessage("GIFT EXCHANGED!");
        }
    }

}
