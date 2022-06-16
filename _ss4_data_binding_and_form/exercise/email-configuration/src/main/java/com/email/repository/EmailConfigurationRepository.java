package com.email.repository;

import com.email.model.EmailConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public class EmailConfigurationRepository implements IEmailConfigurationRepository{
    private static EmailConfiguration emailConfiguration;
    private static String[] languages;
    private static Integer[] pageSizes;

    static {
        emailConfiguration = new EmailConfiguration("English", 21,
                true, "Example signature");
        languages = new String[]{"English", "France", "Chinese", "Vietnamese"};
        pageSizes = new Integer[]{21, 22, 23, 24, 25};
    }

    @Override
    public EmailConfiguration getConfig() {
        return emailConfiguration;
    }

    @Override
    public String[] getLanguages() {
        return languages;
    }

    @Override
    public Integer[] getPageSizes() {
        return pageSizes;
    }

    @Override
    public void saveConfig(EmailConfiguration obj) {
        emailConfiguration = obj;
    }
}
