package br.unirio.xsoa.endpoint.core.domain;

import br.unirio.xsoa.entity.Scenario;
import br.unirio.xsoa.entity.Value;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 7/3/13
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */
public class ScenarioWSO {
    private Long id;
    private String name;
    private ValueWSO[] values;

    public ScenarioWSO() {
    }

    public ScenarioWSO(Long id, String name, ValueWSO[] values) {
        this.id = id;
        this.name = name;
        this.values = values;
    }

    public static ScenarioWSO fromEntity(Scenario s){
        if(null == s){
            return null;
        }

        ValueWSO[] values = null;

        if(null != s.getValues() && !s.getValues().isEmpty()){
            values = new ValueWSO[s.getValues().size()];
            int i = 0;

            for(Value v: s.getValues()){
                values[i++] = ValueWSO.fromEntity(v);
            }
        }

        return new ScenarioWSO(s.getId(), s.getName(), values);
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

    public ValueWSO[] getValues() {
        return values;
    }

    public void setValues(ValueWSO[] values) {
        this.values = values;
    }
}
