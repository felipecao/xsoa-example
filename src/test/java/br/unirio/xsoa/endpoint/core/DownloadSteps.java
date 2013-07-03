package br.unirio.xsoa.endpoint.core;

import br.unirio.xsoa.dbunit.DbUnitManager;
import br.unirio.xsoa.endpoint.ISmartBrickEndpoint;
import br.unirio.xsoa.endpoint.core.domain.SiteWSO;
import br.unirio.xsoa.service.ISiteService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class DownloadSteps {

    @Autowired
    private DbUnitManager dbUnitManager;

    @Autowired
    ISmartBrickEndpoint endpoint;

    SiteWSO[] sites;

    @Given("^two sites, both assigned to admin user and one of them assigned to backup user$")
    public void two_sites_both_assigned_to_admin_user_and_one_of_them_assigned_to_backup_user() throws Throwable {
        dbUnitManager.cleanAndInsert(DownloadSteps.class);
    }

    @When("^\"([^\"]*)\" user requests the download of his sites$")
    public void user_requests_the_download_of_his_sites(String userName) throws Throwable {
        DownloadResponse response = endpoint.download(new DownloadRequest(userName));
        sites = response.sites;
    }

    @Then("^\"([^\"]*)\" sites are downloaded, namely \"([^\"]*)\" and \"([^\"]*)\", in this order$")
    public void sites_are_downloaded_namely_and_in_this_order(int totalSites, String firstSiteName, String secondSiteName) throws Throwable {
        assertEquals(totalSites, sites.length);
        assertEquals(sites[0].getName(), firstSiteName);
        assertEquals(sites[1].getName(), secondSiteName);
    }

    @Then("^\"([^\"]*)\" has \"([^\"]*)\" activities$")
    public void has_activities(String siteName, int totalExpectedActivites) throws Throwable {
        for(SiteWSO s: sites){
            if(siteName.equals(s.getName())){
                assertEquals(totalExpectedActivites, s.getActivities().length);
                return;
            }
        }
        fail();
    }

    @Then("^\"([^\"]*)\" has \"([^\"]*)\" scenarios$")
    public void has_scenarios(String siteName, int totalExpectedScenarios) throws Throwable {
        for(SiteWSO s: sites){
            if(siteName.equals(s.getName())){
                assertEquals(totalExpectedScenarios, s.getScenarios().length);
                return;
            }
        }
        fail();
    }

    @Then("^\"([^\"]*)\" activities are \"([^\"]*)\" and \"([^\"]*)\" in this order$")
    public void activities_are_and_in_this_order(String siteName, String activity1, String activity2) throws Throwable {
        assertEquals(sites[1].getName(), siteName);
        assertEquals(sites[1].getActivities()[0].getName(), activity1);
        assertEquals(sites[1].getActivities()[1].getName(), activity2);
    }
}
