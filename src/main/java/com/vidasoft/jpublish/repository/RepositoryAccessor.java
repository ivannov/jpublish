package com.vidasoft.jpublish.repository;

import com.vidasoft.jpublish.model.Theme;
import com.vidasoft.jpublish.repository.themes.RepositoryTheme;
import com.vidasoft.jpublish.repository.themes.ThemesRepositoryAccessor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class RepositoryAccessor {

    @Inject
    private ThemesRepositoryAccessor themesRepositoryAccessor;

    public Collection<RepositoryTheme> getAvailableThemes() {
        return themesRepositoryAccessor.getAvailableThemes();
    }

    public RepositoryTheme getThemeByName(String themeName) {
        return themesRepositoryAccessor.getThemeByName(themeName);
    }
}
