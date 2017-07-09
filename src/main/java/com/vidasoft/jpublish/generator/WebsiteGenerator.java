package com.vidasoft.jpublish.generator;

import com.vidasoft.jpublish.model.Website;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestScoped
public class WebsiteGenerator {

    private static final String OUTPUT_PARENT = ".jpublish";

    @Inject
    private ProjectGenerator projectGenerator;

    public Path generateWebsite(Website website) throws IOException {
        Path projectParent = Files.createTempDirectory(OUTPUT_PARENT);
        projectGenerator.createNewProject(website.getName(), projectParent.toString());
        return Paths.get(projectParent.toString(), website.getName());
    }
}
