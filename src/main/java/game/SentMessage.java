package game;

public class SentMessage extends AbstractEvent {

    private Long id;
    private String status;
    private String message;

    public SentMessage(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void sentMessage(String message) {
        this.message = message;
    }
}

