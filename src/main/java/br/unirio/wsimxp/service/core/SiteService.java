package br.unirio.wsimxp.service.core;

import br.unirio.wsimxp.dao.ISiteDao;
import br.unirio.wsimxp.entity.Site;
import br.unirio.wsimxp.entity.User;
import br.unirio.wsimxp.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
