package com.email.service;

import com.email.model.EmailConfiguration;

public interface IEmailConfigurationService {
    EmailConfiguration getConfig();
    String[] getLanguages();
    Integer[] getPageSizes();
    void saveConfig(EmailConfiguration emailConfiguration);
}
