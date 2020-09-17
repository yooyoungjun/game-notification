
package game.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

//@FeignClient(name="mission", url="http://mission:8080")
@FeignClient(name="gift", url="${api.url.mission}", fallback = MissionServiceFallback.class)
public interface MissionService {

    @RequestMapping(method= RequestMethod.POST, path="/missions")
    public void updateStatus(@RequestBody Mission mission);

}