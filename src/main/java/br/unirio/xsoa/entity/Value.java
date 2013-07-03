package br.unirio.xsoa.entity;

import javax.persistence.*;

@Entity
@Table(name="VALUE")
@SequenceGenerator(name = "SQ_VALUE", sequenceName = "SQ_VALUE")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_VALUE")
    @Column(name="VALUE_ID")
    private Long id;

    @Column(name = "VALUE_VALUE", length = 100, nullable = false)
    private String value;

    @ManyToOne
    private Scenario scenario;

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

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
