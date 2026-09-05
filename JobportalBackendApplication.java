package com.jobportal.jobportal_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class JobportalBackendApplication {

    public static void main(String[] args) {
        // Load .env variables
        Dotenv dotenv = Dotenv.load();
System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
System.setProperty("DB_URL", dotenv.get("DB_URL"));
System.setProperty("SERVER_PORT", dotenv.get("SERVER_PORT"));
System.setProperty("MANAGEMENT_SERVER_PORT", dotenv.get("MANAGEMENT_SERVER_PORT"));

        // Start Spring Boot
        SpringApplication.run(JobportalBackendApplication.class, args);
    }
}
