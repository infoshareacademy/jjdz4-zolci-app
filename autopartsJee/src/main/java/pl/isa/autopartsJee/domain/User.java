package pl.isa.autopartsJee.domain;

import javax.persistence.*;


@Entity
@Access(AccessType.FIELD)

//@NamedQueries({
//        @NamedQuery(name = "findUserByLogin", query = "from users u where u.login=:login")
//})

@Table(name = "users")
public class User {
    private String login;
    private String password;
    private String email;
    private String name;
    private String surname;


    public Integer getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
