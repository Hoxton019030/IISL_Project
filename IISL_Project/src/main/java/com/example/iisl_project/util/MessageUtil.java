package com.example.iisl_project.util;

import com.example.iisl_project.config.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {

    @Autowired
    private MessageSource messageSource;

    private Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    public String getMessage(String code) {
        return messageSource.getMessage(code, null, getLocale());
    }

    public String getMessage(String code, String... args) {
        return messageSource.getMessage(code, args, getLocale());
    }

    public static String getMessageStatic(String code) {
        MessageUtil messageUtil = ApplicationContextProvider.getContext().getBean(MessageUtil.class);
        return messageUtil.getMessage(code);
    }
    public static String getMessageStatic(String code, String... args) {
        MessageUtil messageUtil = ApplicationContextProvider.getContext().getBean(MessageUtil.class);
        return messageUtil.getMessage(code, args);
    }
}
