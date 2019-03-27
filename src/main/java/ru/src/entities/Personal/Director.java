package ru.src.entities.Personal;

import ru.src.entities.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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

    public Director() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return member.equals(director.member) &&
                position.equals(director.position) &&
                fullName.equals(director.fullName) &&
                phoneMobile.equals(director.phoneMobile) &&
                Objects.equals(phoneCity, director.phoneCity) &&
                email.equals(director.email) &&
                Objects.equals(birthday, director.birthday) &&
                Objects.equals(changes, director.changes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, position, fullName, phoneMobile, phoneCity, email, birthday, changes);
    }

    @Override
    public String toString() {
        return "Director{" +
                "member=" + member +
                ", position='" + position + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", phoneCity='" + phoneCity + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", changes='" + changes + '\'' +
                '}';
    }
}
