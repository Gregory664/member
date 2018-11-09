package ru.POJO.Personal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DIRECTOR")
public class Director {

    @Id
    //TODO Добавить автоинкрементную аннотацию
    @Column(name = "DIRECTOR_ID", nullable = false)
    private Integer directorId;

    @Column(name = "DIRECTOR_POSITION", nullable = false)
    private String position;

    @Column(name = "DIRECTOR_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "DIRECTOR_PHONE")
    private String phone;

    @Column(name = "DIRECTOR_EMAIL")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "DIRECTOR_BIRTHDAY")
    private Date birthday;

    @Column(name = "DIRECTOR_CHANGES")
    private String changes;

    private Director() {

    }

    public Director(Integer directorId, String position, String fullName, String phone, String email, Date birthday, String changes) {
        this.directorId = directorId;
        this.position = position;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.changes = changes;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }


}
