package br.unirio.xsoa.endpoint.core.domain;

import br.unirio.xsoa.entity.Activity;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 7/3/13
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */
public class ActivityWSO {
    private Long id;
    private String name;

    public ActivityWSO() {
    }

    public ActivityWSO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ActivityWSO fromEntity(Activity a){
        if(null == a){
            return null;
        }
        return new ActivityWSO(a.getId(), a.getName());
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
}
