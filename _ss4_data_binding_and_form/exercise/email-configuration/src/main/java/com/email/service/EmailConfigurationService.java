package com.email.service;

import com.email.model.EmailConfiguration;
import com.email.repository.IEmailConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailConfigurationService implements IEmailConfigurationService{
    @Autowired
    private IEmailConfigurationRepository emailConfigurationRepository;

    @Override
    public EmailConfiguration getConfig() {
        return emailConfigurationRepository.getConfig();
    }

    @Override
    public String[] getLanguages() {
        return emailConfigurationRepository.getLanguages();
    }

    @Override
    public Integer[] getPageSizes() {
        return emailConfigurationRepository.getPageSizes();
    }

    @Override
    public void saveConfig(EmailConfiguration emailConfiguration) {
        emailConfigurationRepository.saveConfig(emailConfiguration);
    }
}
