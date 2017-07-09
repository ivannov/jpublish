package com.vidasoft.jpublish.repository.themes;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@ApplicationScoped
public class PackagedThemesRepositoryAccessor implements ThemesRepositoryAccessor {

    private Map<String, RepositoryTheme> packagedThemes = new HashMap<>();

    @PostConstruct
    public void loadPackagedThemes() {
        File themesFolder = new File(this.getClass().getResource("/themes").getPath());
        File[] availableThemes = themesFolder.listFiles();
        if (availableThemes != null) {
            Stream.of(availableThemes).forEach(this::loadTheme);
        }
    }

    private void loadTheme(File file) {
        try (JsonReader jsonReader = Json.createReader(new FileReader(new File(file, "theme.json")))) {
            JsonObject themeJson = jsonReader.readObject();
            RepositoryTheme repositoryTheme = new RepositoryTheme(themeJson.getString("name"),
                    themeJson.getString("displayName"));
            packagedThemes.put(repositoryTheme.getName(), repositoryTheme);
        } catch (FileNotFoundException e) {
            System.out.println("Theme named " + file.getName() + " could not be loaded.");
            e.printStackTrace();
        }
    }

    @Override
    public Collection<RepositoryTheme> getAvailableThemes() {
        return packagedThemes.values();
    }

    @Override
    public RepositoryTheme getThemeByName(String themeName) {
        return packagedThemes.get(themeName);
    }
}
