package game;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Notification_table")
public class Notification {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="missionId")
    private Long missionId;
    @Column(name="rewardId")
    private Long rewardId;
    @Column(name="walletId")
    private Long walletId;
    @Column(name="status")
    private String status;
    @Column(name="message")
    private String message;

    @PostPersist
    public void onPostPersist(){
        SentMessage sentMessage = new SentMessage();
        BeanUtils.copyProperties(this, sentMessage);
        sentMessage.publishAfterCommit();

        game.external.Mission mission = new game.external.Mission();
        // mappings goes here
        NotificationApplication.applicationContext.getBean(game.external.MissionService.class)
                .updateStatus(mission);

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }
    public Long getRewardId() {
        return rewardId;
    }

    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }
    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
