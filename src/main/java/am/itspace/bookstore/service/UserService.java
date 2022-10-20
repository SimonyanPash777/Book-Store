package am.itspace.bookstore.service;

import am.itspace.bookstore.entity.User;
import am.itspace.bookstore.entity.UserRole;
import am.itspace.bookstore.exception.DublicateResourceException;
import am.itspace.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;

    public void save(User user) throws DublicateResourceException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new DublicateResourceException("User already exsists!!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.USER);
        user.setEnable(false);
        user.setVerifyToken(UUID.randomUUID().toString());
        userRepository.save(user);
        mailService.sendEmail(user.getEmail(), "Pleace verify your mail",
                "\n" +
                        "Hi " + user.getName() + ",\n" +
                        "\n" +
                        "Thanks for getting started with our [customer portal]!\n" +
                        "\n" +
                        "We need a little more information to complete your registration, including a confirmation of your email address.\n" +
                        "\n" +
                        "Click below to confirm your email address:\n" +
                        "\n" +
                        "\\\"http://localhost:8080/user/verify?email=" + user.getEmail() + "&token=" + user.getVerifyToken() + "\"\n" +
                        "\n" +
                        "If you have problems, please paste the above URL into your web browser.");
    }

    public void verifyUser(String email, String token) throws Exception {
        Optional<User> userOptional = userRepository.findByEmailAndVerifyToken(email, token);

        if (userOptional.isEmpty()) {
            throw new Exception("User doesn't exsists with email and token");
        }
        User user = userOptional.get();
        if (user.isEnable()) {
            throw new Exception("User already enabled");
        }
        user.setEnable(true);
        user.setVerifyToken(null);
        userRepository.save(user);
    }
}
