package br.unirio.xsoa.service.core;

import br.unirio.xsoa.dao.ISiteDao;
import br.unirio.xsoa.entity.Site;
import br.unirio.xsoa.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SiteServiceTest {
    private ISiteDao siteDaoMock;
    private SiteService siteService;

    @Before
    public void setup(){
        siteDaoMock = mock(ISiteDao.class);

        siteService = new SiteService(siteDaoMock);
    }

    @Test
    public void serviceDelegatesToDao(){
        Set<Site> mockSites = new HashSet<Site>(){{
            add(new Site(1L));
            add(new Site(2L));
        }};

        when(siteDaoMock.findByUser(any(User.class))).thenReturn(mockSites);

        Set<Site> sites = siteService.findByUser(new User());

        assertEquals(sites, mockSites);
    }
}
