package com.email.repository;

import com.email.model.EmailConfiguration;

public interface IEmailConfigurationRepository {
    EmailConfiguration getConfig();
    String[] getLanguages();
    Integer[] getPageSizes();
    void saveConfig(EmailConfiguration obj);
}
