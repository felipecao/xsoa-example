package br.unirio.xsoa.dao.core;

import br.unirio.xsoa.dao.ISiteDao;
import br.unirio.xsoa.entity.Scenario;
import br.unirio.xsoa.entity.Site;
import br.unirio.xsoa.entity.User;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@DataSet
@SpringApplicationContext({"/META-INF/spring/applicationContext.xml", "testContext.xml"})
public class SiteDaoTest extends UnitilsJUnit4 {

    @SpringBeanByType
    private ISiteDao siteDao;

    @Test
    public void ifUserKeyIsEmptyReturnIsEmpty(){
        assertEquals(new HashSet<Site>(), siteDao.findByUser(new User()));
    }

    @Test
    public void ifUserObjectIsNullReturnIsEmpty(){
        assertEquals(new HashSet<Site>(), siteDao.findByUser(new User()));
    }

    @Test
    public void adminUserSees2Sites(){
        Set<Site> sites = siteDao.findByUser(new User("admin"));
        List<Site> sitesAsList = new ArrayList<Site>(sites);

        assertNotNull(sites);
        assertEquals(2, sites.size());

        List<Scenario> scenarios = new ArrayList<Scenario>(sitesAsList.get(0).getScenarios());

        assertEquals(2, scenarios.size());
        assertEquals(4, sitesAsList.get(0).getActivities().size());
        assertEquals(2, sitesAsList.get(0).getScenarios().size());
        assertEquals(2, scenarios.get(0).getValues().size());
        assertEquals(3, scenarios.get(1).getValues().size());

        scenarios = new ArrayList<Scenario>(sitesAsList.get(1).getScenarios());

        assertEquals(2, scenarios.size());
        assertEquals(2, sitesAsList.get(1).getActivities().size());
        assertEquals(2, sitesAsList.get(1).getScenarios().size());
        assertEquals(2, scenarios.get(0).getValues().size());
        assertEquals(3, scenarios.get(1).getValues().size());
    }

    @Test
    public void adminUserSees2SitesRegardlessOfCaps(){
        Set<Site> sites = siteDao.findByUser(new User("AdMin"));

        assertNotNull(sites);
        assertEquals(2, sites.size());
    }

    @Test
    public void backupUserSees1Site(){
        Set<Site> sites = siteDao.findByUser(new User("backup-user"));
        List<Site> sitesAsList = new ArrayList<Site>(sites);

        assertNotNull(sites);
        assertEquals(1, sites.size());

        List<Scenario> scenarios = new ArrayList<Scenario>(sitesAsList.get(0).getScenarios());

        assertEquals(2, scenarios.size());
        assertEquals(2, sitesAsList.get(0).getActivities().size());
        assertEquals(2, sitesAsList.get(0).getScenarios().size());
        assertEquals(2, scenarios.get(0).getValues().size());
        assertEquals(3, scenarios.get(1).getValues().size());
    }

}
