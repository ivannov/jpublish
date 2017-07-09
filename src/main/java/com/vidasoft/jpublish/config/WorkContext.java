package com.vidasoft.jpublish.config;

import com.vidasoft.jpublish.model.Website;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class WorkContext implements Serializable {

    private Website currentWebsite;

    public Website getCurrentWebsite() {
        return currentWebsite;
    }

    public void setCurrentWebsite(Website currentWebsite) {
        this.currentWebsite = currentWebsite;
    }
}
