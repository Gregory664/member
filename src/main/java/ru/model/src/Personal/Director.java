package ru.model.src.Personal;

import ru.model.src.Member;

import javax.persistence.*;
import java.io.Serializable;
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

    public Director(Member member, String position, String fullName, String phone, String email, Date birthday, String changes) {
        this.member = member;
        this.position = position;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.changes = changes;
    }

    public Director(Member member, String position, String fullName, String phone, String email) {
        this.member = member;
        this.position = position;
        this.fullName = fullName;
        this.phone = phone;
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

    @Override
    public String toString() {
        return "Director{" +
                "member=" + member.getMemberId() +
                ", position='" + position + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", changes='" + changes + '\'' +
                '}';
    }
}
