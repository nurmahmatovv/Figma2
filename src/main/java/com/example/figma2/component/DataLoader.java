package com.example.figma2.component;



import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.figma2.entity.User;
import com.example.figma2.enums.Role;
import com.example.figma2.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Override
    public void run(String... args) throws Exception {
        if(ddl.equals("create") || ddl.equals("create-drop")){
            User  admin = new User();
            admin.setFirstName("Admin Admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setPhoneNumber(null);
            admin.setEmail("admin@gmail.com");
            admin.setRole(Role.ROLE_ADMIN);
            admin.setEnabled(true);
            userRepository.save(admin);
        }
    }
}
