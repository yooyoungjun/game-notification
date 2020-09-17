package game.external;

public class Mission {

    private Long id;
    private Long customerId;
    private Long rewardId;
    private String status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getRewardId() {
        return rewardId;
    }
    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}

