package com.vidasoft.jpublish.config;

import com.vidasoft.jpublish.model.User;
import com.vidasoft.jpublish.model.Website;

public class Defaults {

    public static final User DEFAULT_USER = new User("bob", "Bob", "Bob");

    public static Website getWebsiteTemplate() {
        return new Website("New site", DEFAULT_USER.getUserName());
    }
}
