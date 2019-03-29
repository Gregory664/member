package ru.src.entities.Personal;

import ru.src.entities.Member;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CONTACT_PERSON")
public class ContactPerson implements Serializable {
    @Id
    @Column(name = "CONTACT_PERSON_ID", nullable = false)
    private String contactPersonId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "CONTACT_PERSON_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "CONTACT_PERSON_POSITION", nullable = false)
    private String position;

    @Column(name = "CONTACT_PERSON_PHONE_MOBILE", nullable = false)
    private String phoneMobile;

    @Column(name = "CONTACT_PERSON_PHONE_CITY")
    private String phoneCity;

    @Column(name = "CONTACT_PERSON_EMAIL", nullable = false)
    private String email;

    @Column(name = "CONTACT_CHANGES")
    private String changes;

    public ContactPerson() { }

    public ContactPerson(Member member,
                         String fullName,
                         String position,
                         String phoneMobile,
                         String email) {
        this.member = member;
        this.fullName = fullName;
        this.position = position;
        this.phoneMobile = phoneMobile;
        this.email = email;
        this.contactPersonId = generateContactPersonId();
    }

    private String generateContactPersonId() {
        String id = String.valueOf(this.fullName.length()) + String.valueOf(this.position.length());
        String time = String.valueOf(System.nanoTime()).substring(7);
        return id + time;
    }

    public String getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(String contactPersonId) {
        this.contactPersonId = contactPersonId;
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
        ContactPerson that = (ContactPerson) o;
        return contactPersonId.equals(that.contactPersonId) &&
                fullName.equals(that.fullName) &&
                position.equals(that.position) &&
                phoneMobile.equals(that.phoneMobile) &&
                Objects.equals(phoneCity, that.phoneCity) &&
                email.equals(that.email) &&
                Objects.equals(changes, that.changes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactPersonId, fullName, position, phoneMobile, phoneCity, email, changes);
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "contactPersonId='" + contactPersonId + '\'' +
                ", member=" + member.getMemberId() +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", phoneCity='" + phoneCity + '\'' +
                ", email='" + email + '\'' +
                ", changes='" + changes + '\'' +
                '}';
    }
}
