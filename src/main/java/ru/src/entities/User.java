package ru.src.entities;

import ru.src.logic.implementation.MemberUtils;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "USER_LOGIN", nullable = false)
    private String login;
    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;
    @Column(name = "USER_IS_ADMIN", nullable = false)
    private Boolean isAdmin;
    @Column(name = "USER_FULL_NAME", nullable = false)
    private String fullName;
    @Column(name = "USER_POSITION", nullable = false)
    private String position;

    public User() { }

    public User(String login, String password, Boolean isAdmin, String fullName, String position) {
        this.login = login;
        this.password = MemberUtils.getPasswordHash(password);
        this.isAdmin = isAdmin;
        this.fullName = fullName;
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = MemberUtils.getPasswordHash(login);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) &&
                password.equals(user.password) &&
                isAdmin.equals(user.isAdmin) &&
                fullName.equals(user.fullName) &&
                position.equals(user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, isAdmin, fullName, position);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
