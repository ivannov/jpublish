package com.vidasoft.jpublish.website;

import com.vidasoft.jpublish.config.Defaults;
import com.vidasoft.jpublish.config.WorkContext;
import com.vidasoft.jpublish.model.Website;
import com.vidasoft.jpublish.repository.RepositoryAccessor;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/GeneralInfo")
public class GeneralInfoServlet extends HttpServlet {

    @Inject
    private WebsiteDAO websiteDAO;

    @Inject
    private WorkContext workContext;

    @Inject
    private RepositoryAccessor repositoryAccessor;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Website website;
        if (idParam == null) {
            website = websiteDAO.createWebsite(Defaults.getWebsiteTemplate());
        } else {
            website = websiteDAO.findWebsiteById(Long.parseLong(idParam));
        }

        workContext.setCurrentWebsite(website);
        req.setAttribute("website", website);
        req.setAttribute("availableThemes", repositoryAccessor.getAvailableThemes());
        req.getRequestDispatcher("generalInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Website currentWebsite = workContext.getCurrentWebsite();
        currentWebsite.setName(req.getParameter("name"));
        currentWebsite.getTheme().setName(req.getParameter("theme"));
        websiteDAO.updateWebsite(currentWebsite);
        resp.sendRedirect("GeneralInfo?id=" + currentWebsite.getId()    );
    }
}
