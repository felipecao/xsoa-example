package br.unirio.xsoa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="SCENARIO")
@SequenceGenerator(name = "SQ_SCENARIO", sequenceName = "SQ_SCENARIO")
public class Scenario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_SCENARIO")
    @Column(name="SCENARIO_ID")
    private Long id;

    @Column(name = "SCENARIO_NAME", length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "scenario", fetch = FetchType.EAGER)
    @OrderBy("id")
    private Set<Value> values = new HashSet<Value>();

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

    public Set<Value> getValues() {
        return values;
    }

    public void setValues(Set<Value> values) {
        this.values = values;
    }
}
