package ru.src.model.Personal;

import ru.src.model.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "DIRECTOR")
public class Director implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "DIRECTOR_POSITION", nullable = false)
    private String position;

    @Column(name = "DIRECTOR_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "DIRECTOR_PHONE_MOBILE", nullable = false)
    private String phoneMobile;

    @Column(name = "DIRECTOR_PHONE_CITY")
    private String phoneCity;

    @Column(name = "DIRECTOR_EMAIL", nullable = false)
    private String email;

    @Column(name = "DIRECTOR_BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "DIRECTOR_CHANGES")
    private String changes;


    private Director() {

    }

    public Director(Member member,
                    String position,
                    String fullName,
                    String phoneMobile,
                    String email) {
        this.member = member;
        this.position = position;
        this.fullName = fullName;
        this.phoneMobile = phoneMobile;
        this.email = email;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneCity() {
        return phoneCity;
    }

    public void setPhoneCity(String phoneCity) {
        this.phoneCity = phoneCity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }
}
