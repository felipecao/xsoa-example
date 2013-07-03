package br.unirio.xsoa.dao.core;

import br.unirio.xsoa.dao.ISiteDao;
import br.unirio.xsoa.entity.Site;
import br.unirio.xsoa.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.apache.commons.lang.StringUtils.isBlank;

@Component
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class SiteDao implements ISiteDao {

    private SessionFactory sessionFactory;

    @Autowired
    public SiteDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Set<Site> findByUser(User user) {

        if(null == user || isBlank(user.getLogin())){
            return new TreeSet<Site>();
        }

        Set<Site> sites = new LinkedHashSet<Site>(sessionFactory.getCurrentSession().createCriteria(Site.class)
                .createAlias("users", "usr")
                .add(Restrictions.eq("usr.login", user.getLogin()))
                .list());

        return sites;
    }
}
