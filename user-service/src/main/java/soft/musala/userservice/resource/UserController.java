package soft.musala.userservice.resource;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soft.musala.userservice.model.UserResponse;
import soft.musala.userservice.model.CreateUserRequest;
import soft.musala.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment environment;

    @Autowired
    UserService userService;

    @RequestMapping("/health")
    public String healthCheck () {
        return "User service is up and running on port: " + environment.getProperty("local.server.port") + "\n" + "Token secret value is: "+ environment.getProperty("token.secret");

    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser (@Valid @RequestBody CreateUserRequest createUserRequest) {
        UserResponse createdUser = userService.createUser(createUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<UserResponse> getUser (@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));

    }
}
