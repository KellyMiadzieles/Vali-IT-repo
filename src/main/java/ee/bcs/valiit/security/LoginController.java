package ee.bcs.valiit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    @Autowired
    private SecurityService securityService;


    // http://localhost:8080/api/public/login
    @PostMapping("/api/public/login")
    public String logIn(@RequestBody LoginRequest loginRequest) {
        return securityService.logIn(loginRequest);
    }

    // http://localhost:8080/api/public/newUser
    @CrossOrigin
    @PostMapping("/api/public/newUser")
    public void newUser(@RequestBody LoginRequest loginRequest) {
        securityService.newUser(loginRequest);
    }
}
