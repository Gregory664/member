package ru.src.model;

import ru.src.model.Address.AddressActual;
import ru.src.model.Address.AddressLegal;
import ru.src.model.General.GeneralInformation;
import ru.src.model.Personal.Contact;
import ru.src.model.Personal.ContactPerson;
import ru.src.model.Personal.Director;
import ru.src.model.Personal.Relate;
import ru.src.model.buh.AccoutingInformation;
import ru.src.model.buh.Debt;
import ru.src.model.buh.Invoice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_ID", nullable = false)
    private String memberId;

    @Column(name = "MEMBER_SERIAL", nullable = false)
    private Integer memberSerial;

    @Column(name = "MEMBER_STATUS", nullable = false)
    private String memberStatus;

    @Column(name = "MEMBER_DATE_OF_ENTRY", nullable = false)
    private LocalDate memberDate;

    @Column(name = "MEMBER_SHORT_NAME", nullable = false)
    private String memberShortName;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private AddressActual addressActual;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private AddressLegal addressLegal;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Debt debt;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private AccoutingInformation accoutingInformation;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="member", orphanRemoval = true)
    public List<Invoice> invoice;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private GeneralInformation generalInformation;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Contact contact;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,  mappedBy="member")
    private List<ContactPerson> contactPerson;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Director director;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Relate relate;


    private Member() {

    }

    public Member(String memberId, Integer memberSerial, String memberStatus, LocalDate memberDate, String memberShortName) {
        this.memberId = memberId;
        this.memberSerial = memberSerial;
        this.memberStatus = memberStatus;
        this.memberDate = memberDate;
        this.memberShortName = memberShortName;
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberSerial() {
        return memberSerial;
    }

    public void setMemberSerial(Integer memberSerial) {
        this.memberSerial = memberSerial;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public LocalDate getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(LocalDate memberDate) {
        this.memberDate = memberDate;
    }

    public String getMemberShortName() {
        return memberShortName;
    }

    public void setMemberShortName(String memberShortName) {
        this.memberShortName = memberShortName;
    }

    public AddressActual getAddressActual() {
        return addressActual;
    }

    public void setAddressActual(AddressActual addressActual) {
        this.addressActual = addressActual;
    }

    public AddressLegal getAddressLegal() {
        return addressLegal;
    }

    public void setAddressLegal(AddressLegal addressLegal) {
        this.addressLegal = addressLegal;
    }

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    public AccoutingInformation getAccoutingInformation() {
        return accoutingInformation;
    }

    public void setAccoutingInformation(AccoutingInformation accoutingInformation) {
        this.accoutingInformation = accoutingInformation;
    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<ContactPerson> getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(List<ContactPerson> contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Relate getRelate() {
        return relate;
    }

    public void setRelate(Relate relate) {
        this.relate = relate;
    }
}
