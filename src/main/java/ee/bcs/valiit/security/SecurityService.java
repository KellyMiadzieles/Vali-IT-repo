package ee.bcs.valiit.security;

import ee.bcs.valiit.solution.exception.SampleApplicationException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SecurityService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityRepository securityRepository;

    public String logIn(LoginRequest loginRequest) {
        securityRepository.getPasswordByUsername(loginRequest.getUsername());
        String password = securityRepository.getPasswordByUsername(loginRequest.getUsername());
        if (passwordEncoder.matches(loginRequest.getPassword(), password)) {
            //loginRequest.getPassword().equals(loginRequest.getPassword())) {
            Date today = new Date();
            Date tokenExpirationDate = new Date(today.getTime() + 1000 * 60 * 60 * 24);
            JwtBuilder jwtBuilder = Jwts.builder()
                    .setExpiration(tokenExpirationDate)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "c2VjcmV0")
                    .claim("username", loginRequest.getUsername());
            return jwtBuilder.compact();
        } else{
            throw new SampleApplicationException("Vale parool");
        }
    }

    public void newUser(LoginRequest loginRequest) {
        if (securityRepository.doesUserExists(loginRequest.getUsername())){
            throw new SampleApplicationException("error");
    } else {
    }
        String encodedPassword = passwordEncoder.encode(loginRequest.getPassword());
        loginRequest.setPassword(encodedPassword);
        securityRepository.createUser(loginRequest.getUsername(), loginRequest.getPassword());
    }

}