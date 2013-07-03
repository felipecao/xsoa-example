package br.unirio.xsoa.endpoint.core.domain;

import br.unirio.xsoa.entity.Activity;
import br.unirio.xsoa.entity.Scenario;
import br.unirio.xsoa.entity.Site;
import br.unirio.xsoa.entity.Value;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 7/3/13
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class SiteWSO {

    private Long id;
    private String name;
    private ActivityWSO[] activities;
    private ScenarioWSO[] scenarios;

    public SiteWSO() {
    }

    public SiteWSO(Long id, String name, ActivityWSO[] activities, ScenarioWSO[] scenarios) {
        this.id = id;
        this.name = name;
        this.activities = activities;
        this.scenarios = scenarios;
    }

    public static SiteWSO fromEntity(Site s){

        if(null == s){
            return null;
        }


        ActivityWSO[] activities = null;
        ScenarioWSO[] scenarios = null;

        if(null != s.getActivities() && !s.getActivities().isEmpty()){
            activities = new ActivityWSO[s.getActivities().size()];
            int i = 0;

            for(Activity a: s.getActivities()){
                activities[i++] = ActivityWSO.fromEntity(a);
            }
        }

        if(null != s.getScenarios() && !s.getScenarios().isEmpty()){
            scenarios = new ScenarioWSO[s.getScenarios().size()];
            int i = 0;

            for(Scenario scn: s.getScenarios()){
                scenarios[i++] = ScenarioWSO.fromEntity(scn);
            }
        }

        return new SiteWSO(s.getId(), s.getName(), activities, scenarios);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActivityWSO[] getActivities() {
        return activities;
    }

    public void setActivities(ActivityWSO[] activities) {
        this.activities = activities;
    }

    public ScenarioWSO[] getScenarios() {
        return scenarios;
    }

    public void setScenarios(ScenarioWSO[] scenarios) {
        this.scenarios = scenarios;
    }
}
