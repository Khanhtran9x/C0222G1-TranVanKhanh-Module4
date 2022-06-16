package com.email.model;

public class EmailConfiguration {
    private String language;
    private Integer pageSize;
    private Boolean enableSpamFilter;
    private String signature;

    public EmailConfiguration() {
    }

    public EmailConfiguration(String language, Integer pageSize, Boolean enableSpamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.enableSpamFilter = enableSpamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getEnableSpamFilter() {
        return enableSpamFilter;
    }

    public void setEnableSpamFilter(Boolean enableSpamFilter) {
        this.enableSpamFilter = enableSpamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
