package com.vidasoft.jpublish.website;

import com.vidasoft.jpublish.config.WorkContext;
import com.vidasoft.jpublish.generator.WebsiteGenerator;
import com.vidasoft.jpublish.utils.ZipUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

@WebServlet(urlPatterns = "Generate")
public class GenerateServlet extends HttpServlet {

    @Inject
    private WorkContext workContext;

    @Inject
    private WebsiteGenerator generator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = generator.generateWebsite(workContext.getCurrentWebsite());
        File targetFile = new File(path.getParent().toFile(), path.getFileName().toString() + ".zip");
        ZipUtil.zip(path.toFile(), targetFile);
        resp.setContentType("application/zip");
        resp.setHeader("Content-disposition", "attachment; filename=" + targetFile.getName());
        ServletOutputStream outputStream = resp.getOutputStream();
        try (FileInputStream in = new FileInputStream(targetFile)) {
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
        }
    }
}
