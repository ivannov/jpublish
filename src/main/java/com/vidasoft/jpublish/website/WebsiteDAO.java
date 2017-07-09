package com.vidasoft.jpublish.website;

import com.vidasoft.jpublish.model.Website;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class WebsiteDAO {

    @PersistenceContext
    private EntityManager entityManager;

    List<Website> getWebsitesForUser(String userName) {
        TypedQuery<Website> query = entityManager.createNamedQuery("getWebsitesForUser", Website.class);
        query.setParameter("owner", userName);
        return query.getResultList();
    }

    Website findWebsiteById(Long id) {
        return entityManager.find(Website.class, id);
    }

    @Transactional
    Website createWebsite(Website newWebsite) {
        entityManager.persist(newWebsite);
        return newWebsite;
    }

    @Transactional
    Website updateWebsite(Website website) {
        if (entityManager.find(Website.class, website.getId()) == null) {
            throw new IllegalArgumentException();
        }
        entityManager.merge(website);
        return website;
    }
}
