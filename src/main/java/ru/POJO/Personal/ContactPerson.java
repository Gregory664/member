package ru.POJO.Personal;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_PERSON")
public class ContactPerson {

    @Id
    //TODO Добавить автоинкрементную аннотацию
    @Column(name = "CONTACT_PERSON_ID")
    private Integer ContactPersonID;

    @Column(name = "CONTACT_PERSON_FULL_NAME")
    private String fullName;

    @Column(name = "CONTACT_PERSON_POSITION")
    private String position;

    @Column(name = "CONTACT_PERSON_PHONE")
    private String phone;

    @Column(name = "CONTACT_PERSON_EMAIL")
    private String email;

    @Column(name = "CONTACT_CHANGES")
    private String changes;

    private ContactPerson() {

    }

    public ContactPerson(Integer contactPersonID, String fullName, String position, String phone, String email, String changes) {
        ContactPersonID = contactPersonID;
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.changes = changes;
    }

    public Integer getContactPersonID() {
        return ContactPersonID;
    }

    public void setContactPersonID(Integer contactPersonID) {
        ContactPersonID = contactPersonID;
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
}
