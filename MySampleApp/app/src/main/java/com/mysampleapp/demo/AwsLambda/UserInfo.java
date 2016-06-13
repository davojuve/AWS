package com.mysampleapp.demo.AwsLambda;

/**
 * A simple POJO
 */
public class UserInfo {
    private String userId;
    private String firstName;
    private String externalId;
    private String lastName;
    private String provider;
    private String token;

    public UserInfo() {}

    public UserInfo(String userId, String firstName, String externalId, String lastName, String provider, String token) {
        this.userId = userId;
        this.firstName = firstName;
        this.externalId = externalId;
        this.lastName = lastName;
        this.provider = provider;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}