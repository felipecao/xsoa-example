package br.unirio.xsoa.service.core;

import br.unirio.xsoa.dao.ISiteDao;
import br.unirio.xsoa.entity.Site;
import br.unirio.xsoa.entity.User;
import br.unirio.xsoa.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
@Transactional(readOnly = true)
public class SiteService implements ISiteService {

    private ISiteDao siteDao;

    @Autowired
    public SiteService(ISiteDao siteDao) {
        this.siteDao = siteDao;
    }

    @Override
    public Set<Site> findByUser(User user) {
        return siteDao.findByUser(user);
    }
}
