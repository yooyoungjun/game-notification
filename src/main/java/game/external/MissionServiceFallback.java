package game.external;

import org.springframework.stereotype.Component;

@Component
public class MissionServiceFallback implements MissionService {

    @Override
    public void updateStatus(Mission mission) {
        System.out.println("Circuit breaker has been opened. Fallback returned instead.");
    }

}