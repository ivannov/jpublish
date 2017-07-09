package com.vidasoft.jpublish.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Theme {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    private String name;

    private String header;

    private byte[] headerImage;

    @OneToMany
    private List<MenuItem> menuItems = new ArrayList<>();

    public Theme() {
    }

    public Theme(String name) {
        this(name, "", null, new ArrayList<>());
    }

    public Theme(String name, String header, byte[] headerImage, List<MenuItem> menuItems) {
        this.name = name;
        this.header = header;
        this.headerImage = headerImage;
        this.menuItems = menuItems;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public byte[] getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(byte[] headerImage) {
        this.headerImage = headerImage;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}