package br.unirio.wsimxp.entity;

import javax.persistence.*;

@Entity
@Table(name="ACTIVITY")
@SequenceGenerator(name = "SQ_ACTIVITY", sequenceName = "SQ_ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_ACTIVITY")
    @Column(name="ACTIVITY_ID")
    private Long id;

    @Column(name = "ACTIVITY_NAME", length = 100, nullable = false)
    private String name;

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
