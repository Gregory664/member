package ru.model.src;

import ru.model.src.Address.AddressActual;
import ru.model.src.Address.AddressLegal;
import ru.model.src.General.GeneralInformation;
import ru.model.src.Personal.PersonalInformation;
import ru.model.src.buh.AccoutingInformation;
import ru.model.src.buh.Debt;
import ru.model.src.buh.Invoice;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @Temporal(TemporalType.DATE)
    @Column(name = "MEMBER_DATE_OF_ENTRY", nullable = false)
    private Date memberDate;

    @Column(name = "MEMBER_SHORT_NAME", nullable = false)
    private String memberShortName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "ADDRESS_ACTUAL")
    @JoinColumn(name = "MEMBER_ID")
    private AddressActual addressActual;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "ADDRESS_LEGAL")
    @JoinColumn(name = "MEMBER_ID")
    private AddressLegal addressLegal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "DEBT")
    @JoinColumn(name = "MEMBER_ID")
    private Debt debt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "ACCOUTING_INFORMATION")
    @JoinColumn(name = "MEMBER_ID")
    private AccoutingInformation accoutingInformation;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "INVOICE")
    @JoinColumn(name = "MEMBER_ID")
    private Invoice invoice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "GENERAL_INFORMATION")
    @JoinColumn(name = "MEMBER_ID")
    private GeneralInformation generalInformation;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "PERSONAL_INFORMATION")
    @JoinColumn(name = "MEMBER_ID")
    private PersonalInformation personalInformation;

    private Member() {

    }

    public Member(String memberId, Integer memberSerial, String memberStatus, Date memberDate, String memberShortName) {
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

    public Date getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(Date memberDate) {
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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
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
                ", debt=" + debt.toString() +
                ", accoutingInformation=" + accoutingInformation +
                ", invoice=" + invoice +
                ", generalInformation=" + generalInformation +
                ", personalInformation=" + personalInformation +
                '}';
    }
}
