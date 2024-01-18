package soft.musala.userservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment environment;

    @RequestMapping("/health")
    public String healthCheck () {
        return "Book info service is up and running on port: " + environment.getProperty("local.server.port");
    }
}
