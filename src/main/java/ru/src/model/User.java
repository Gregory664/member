package ru.src.model;

import ru.src.logic.implementation.MemberUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private User() { }

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
