package com.vidasoft.jpublish.repository.themes;

import java.util.Collection;

public interface ThemesRepositoryAccessor {

    Collection<RepositoryTheme> getAvailableThemes();

    RepositoryTheme getThemeByName(String themeName);
}
