package org.jteam.anyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "org.jteam.anyway" },
        exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class }
)
public class AnywayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnywayApplication.class, args);
    }

}
