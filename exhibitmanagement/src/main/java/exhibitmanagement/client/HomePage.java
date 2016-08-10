package exhibitmanagement.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bonga on 8/9/2016.
 */
@RestController
public class HomePage {
    @Autowired


    @RequestMapping("/hello")
    public String getValue(){
        return "Hello , This is a rest API.";
    }
}
