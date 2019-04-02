package ru.src.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.src.entities.Address.AddressActual;
import ru.src.entities.Address.AddressLegal;
import ru.src.entities.General.GeneralInformation;
import ru.src.entities.Personal.Contact;
import ru.src.entities.Personal.ContactPerson;
import ru.src.entities.Personal.Director;
import ru.src.entities.Personal.Relate;
import ru.src.entities.buh.AccoutingInformation;
import ru.src.entities.buh.Debt;
import ru.src.entities.buh.Invoice;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column(name = "MEMBER_ID", nullable = false, length = 10)
    private String memberId;

    @Column(name = "MEMBER_SERIAL", nullable = false)
    private Integer memberSerial;

    @Column(name = "MEMBER_STATUS", nullable = false)
    private String memberStatus;

    @Column(name = "MEMBER_DATE_OF_ENTRY", nullable = false)
    private LocalDate memberDate;

    @Column(name = "MEMBER_SHORT_NAME", nullable = false)
    private String memberShortName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private AddressActual addressActual;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private AddressLegal addressLegal;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Debt debt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private AccoutingInformation accoutingInformation;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "member", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Invoice> invoices;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private GeneralInformation generalInformation;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Contact contact;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "member", orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ContactPerson> contactPersons;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Director director;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Relate relate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private SocialNetworks socialNetworks;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "MEMBER_SERVICES",
            joinColumns = {@JoinColumn(name = "MEMBER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SERVICES_ID")})
    private List<Services> services;

    public Member() {
    }

    public Member(String memberId, Integer memberSerial, String memberStatus, LocalDate memberDate, String memberShortName) {
        this.memberId = memberId;
        this.memberSerial = memberSerial;
        this.memberStatus = memberStatus;
        this.memberDate = memberDate;
        this.memberShortName = memberShortName;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
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

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
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

    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
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

    public SocialNetworks getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(SocialNetworks socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId.equals(member.memberId) &&
                memberSerial.equals(member.memberSerial) &&
                memberStatus.equals(member.memberStatus) &&
                memberDate.equals(member.memberDate) &&
                memberShortName.equals(member.memberShortName) &&
                addressActual.equals(member.addressActual) &&
                addressLegal.equals(member.addressLegal) &&
                debt.equals(member.debt) &&
                accoutingInformation.equals(member.accoutingInformation) &&
                Objects.equals(invoices, member.invoices) &&
                generalInformation.equals(member.generalInformation) &&
                contact.equals(member.contact) &&
                Objects.equals(contactPersons, member.contactPersons) &&
                director.equals(member.director) &&
                relate.equals(member.relate) &&
                socialNetworks.equals(member.socialNetworks) &&
                Objects.equals(services, member.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberSerial, memberStatus, memberDate, memberShortName, addressActual, addressLegal, debt, accoutingInformation, invoices, generalInformation, contact, contactPersons, director, relate, socialNetworks, services);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", memberSerial=" + memberSerial +
                ", memberStatus='" + memberStatus + '\'' +
                ", memberDate=" + memberDate +
                ", memberShortName='" + memberShortName + '\'' +
                ", addressActual=" + addressActual +
                ", addressLegal=" + addressLegal +
                ", debt=" + debt +
                ", accoutingInformation=" + accoutingInformation +
                ", invoices=" + invoices +
                ", generalInformation=" + generalInformation +
                ", contact=" + contact +
                ", contactPersons=" + contactPersons +
                ", director=" + director +
                ", relate=" + relate +
                ", socialNetworks=" + socialNetworks +
                ", services=" + services +
                '}';
    }
}
