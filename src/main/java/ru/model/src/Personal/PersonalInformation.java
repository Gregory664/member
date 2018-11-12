package ru.model.src.Personal;

import ru.model.src.Member;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSONAL_INFORMATION")
public class PersonalInformation implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RELATE_ID")
    private Relate relateId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DIRECTOR_ID")
    private Director directorId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_PERSON_ID")
    private ContactPerson contactPersonId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_ID")
    private ContactOrg contactOrgId;

    private PersonalInformation() {

    }

    public PersonalInformation(Member member, Relate relateId, Director directorId, ContactPerson contactPersonId, ContactOrg contactOrgId) {
        this.member = member;
        this.relateId = relateId;
        this.directorId = directorId;
        this.contactPersonId = contactPersonId;
        this.contactOrgId = contactOrgId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Relate getRelateId() {
        return relateId;
    }

    public void setRelateId(Relate relateId) {
        this.relateId = relateId;
    }

    public Director getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Director directorId) {
        this.directorId = directorId;
    }

    public ContactPerson getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(ContactPerson contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public ContactOrg getContactOrgId() {
        return contactOrgId;
    }

    public void setContactOrgId(ContactOrg contactOrgId) {
        this.contactOrgId = contactOrgId;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "member=" + member +
                ", relateId=" + relateId +
                ", directorId=" + directorId +
                ", contactPersonId=" + contactPersonId +
                ", contactOrgId=" + contactOrgId +
                '}';
    }


}




