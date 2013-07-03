package br.unirio.xsoa.endpoint.core.domain;

import br.unirio.xsoa.entity.Value;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 7/3/13
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
public class ValueWSO {
    private Long id;
    private String value;

    public ValueWSO() {
    }

    public ValueWSO(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public static ValueWSO fromEntity(Value v){
        if(null == v){
            return null;
        }

        return new ValueWSO(v.getId(), v.getValue());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
