package com.example.iisl_project.properties.cipher;

import lombok.Data;
import org.hibernate.annotations.Comment;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "rsa")
public class RsaProperties {
    private String publicKey;
    private String privateKey;

}
