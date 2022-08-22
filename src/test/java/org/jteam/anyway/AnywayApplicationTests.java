package org.jteam.anyway;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class AnywayApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(AnywayApplicationTests.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String passwordHash = passwordEncoder.encode("password");
        log.info("Password hash is {}", passwordHash);
    }

}
