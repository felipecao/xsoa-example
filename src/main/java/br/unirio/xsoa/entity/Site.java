package br.unirio.xsoa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 6/21/13
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="SITE")
@SequenceGenerator(name = "SQ_SITE", sequenceName = "SQ_SITE")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_SITE")
    @Column(name="SITE_ID")
    private Long id;

    @Column(name = "SITE_NAME", length = 100, nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "SITE_ACTIVITY", joinColumns = { @JoinColumn(name = "SITE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ACTIVITY_ID") })
    private Set<Activity> activities = new HashSet<Activity>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "SITE_SCENARIO", joinColumns = { @JoinColumn(name = "SITE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "SCENARIO_ID") })
    @OrderBy("id")
    private Set<Scenario> scenarios = new HashSet<Scenario>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "SITE_USER", joinColumns = { @JoinColumn(name = "SITE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private Set<User> users = new HashSet<User>();

    public Site() {
    }

    public Site(String name) {
        this.name = name;
    }

    public Site(Long i) {
        this.id = i;
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

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(Set<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Site site = (Site) o;

        if (id != null ? !id.equals(site.id) : site.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
