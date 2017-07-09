package com.vidasoft.jpublish.generator.forge;

import com.vidasoft.jpublish.generator.ProjectGenerator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ForgeProjectGenerator implements ProjectGenerator {

    @Inject
    private ForgeClient forgeClient;

    @Override
    public void createNewProject(String named, String location) {
        forgeClient.executeCommand("project-new", location,
                new ForgeClient.Input("named", named),
                new ForgeClient.Input("stack", "JAVA_EE_7"),
                new ForgeClient.Input("topLevelPackage", "com.vidasoft"),
                new ForgeClient.Input("finalName", named));
    }
}
