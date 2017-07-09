package com.vidasoft.jpublish.repository.themes;

public class RepositoryTheme {

    private String name;
    private String displayName;
    // TODO repositoryFiles


    public RepositoryTheme(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
