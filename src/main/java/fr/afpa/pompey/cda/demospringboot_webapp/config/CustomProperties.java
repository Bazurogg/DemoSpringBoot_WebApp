package fr.afpa.pompey.cda.demospringboot_webapp.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fr.afpa.pompey.cda.demospringbootwebapp")
@Data

public class CustomProperties {

    private String apiUrl;

}
