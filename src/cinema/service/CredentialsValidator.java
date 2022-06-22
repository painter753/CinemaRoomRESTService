package cinema.service;

import org.springframework.stereotype.Service;

@Service
public class CredentialsValidator {

    private final String password = "super_secret";

    public void validate(String password) {
        if (!this.password.equals(password)) throw new RuntimeException("The password is wrong!");
    }


}
