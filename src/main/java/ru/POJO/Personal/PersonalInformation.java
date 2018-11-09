package ru.POJO.Personal;

import javax.persistence.*;

@Entity
@Table(name = "PERSONAL_INFORMATION")
public class PersonalInformation {
    @Id
    @Column(name = "MEMBER_ID", nullable = false)
    private String memberId;

    @Column(name = "RELATE_ID", nullable = false)
    private Integer relateId;

    @Column(name = "DIRECTOR_ID", nullable = false)
    private Integer directorId;

    @Column(name = "CONTACT_PERSON_ID", nullable = false)
    private Integer contactPersonId;

    @Column(name = "CONTACT_ID", nullable = false)
    private Integer contactId;

    private PersonalInformation() {

    }

    public PersonalInformation(String memberId, Integer relateId,
                               Integer directorId, Integer contactPersonId,
                               Integer contactId) {
        this.memberId = memberId;
        this.relateId = relateId;
        this.directorId = directorId;
        this.contactPersonId = contactPersonId;
        this.contactId = contactId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getRelateId() {
        return relateId;
    }

    public void setRelateId(Integer relateId) {
        this.relateId = relateId;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public Integer getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(Integer contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }
}




