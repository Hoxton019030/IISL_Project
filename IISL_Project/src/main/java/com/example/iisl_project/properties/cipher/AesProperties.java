package com.example.iisl_project.properties.cipher;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aes")
public class AesProperties {
    private String code;
    private String iv;
}
