package com.vidasoft.jpublish.website;

import com.vidasoft.jpublish.config.Defaults;
import com.vidasoft.jpublish.config.WorkContext;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Websites")
public class WebsitesServlet extends HttpServlet {

    @Inject
    private WebsiteDAO websiteDAO;

    @Inject
    private WorkContext workContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        workContext.setCurrentWebsite(null);
        req.setAttribute("websites", websiteDAO.getWebsitesForUser(Defaults.DEFAULT_USER.getUserName()));
        req.getRequestDispatcher("websites.jsp").forward(req, resp);
    }
}
