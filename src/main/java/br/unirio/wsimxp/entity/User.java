package br.unirio.wsimxp.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@SequenceGenerator(name = "SQ_USER", sequenceName = "SQ_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_USER")
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_LOGIN", length = 100, nullable = false)
    private String login;

    @Column(name = "USER_PWD", length = 100, nullable = false)
    private String password;

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
