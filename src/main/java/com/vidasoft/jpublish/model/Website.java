package com.vidasoft.jpublish.model;

import javax.persistence.*;

@Entity
@NamedQueries(@NamedQuery(name = "getWebsitesForUser", query = "SELECT w FROM Website w WHERE w.owner = :owner"))
public class Website {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    private String name;

    private String owner;

    @OneToOne(cascade = CascadeType.ALL)
    private Theme theme;

    public Website() {
    }

    public Website(String name, String owner) {
        this(name, owner, null);
    }

    public Website(String name, String owner, Theme theme) {
        this.name = name;
        this.owner = owner;
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
