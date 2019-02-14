package pl.rengreen.todolist.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String name;
    @Size(min = 8)
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")},
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;

    public User() {
    }

    public User(@Email @NotEmpty String email, @NotEmpty String name, @Size(min = 8) String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public User(@Email @NotEmpty String email, @NotEmpty String name, @Size(min = 8) String password, List<Task> tasks, List<Role> roles) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.tasks = tasks;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
