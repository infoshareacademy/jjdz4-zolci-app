package pl.isa.autopartsJee.domain;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public void setRole_group(String role_group) {
        this.role_group = role_group;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    private String user_login;
    private String user_role;
    private String role_group;
    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public String getUser_login() {
        return user_login;
    }

    public String getUser_role() {
        return user_role;
    }

    public String getRole_group() {
        return role_group;
    }

    public Integer getUser_id() {
        return user_id;
    }
}
