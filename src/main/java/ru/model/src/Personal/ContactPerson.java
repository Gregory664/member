package ru.model.src.Personal;

import ru.model.src.Member;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONTACT_PERSON")
public class ContactPerson implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "CONTACT_PERSON_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "CONTACT_PERSON_POSITION", nullable = false)
    private String position;

    @Column(name = "CONTACT_PERSON_PHONE", nullable = false)
    private String phone;

    @Column(name = "CONTACT_PERSON_EMAIL", nullable = false)
    private String email;

    @Column(name = "CONTACT_CHANGES")
    private String changes;

    private ContactPerson() {

    }

    public ContactPerson(Member member, String fullName, String position, String phone, String email, String changes) {
        this.member = member;
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.changes = changes;
    }



    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "member=" + member.getMemberId() +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", changes='" + changes + '\'' +
                '}';
    }
}
