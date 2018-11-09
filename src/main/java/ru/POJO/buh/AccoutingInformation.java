package ru.POJO.buh;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUTING_INFORMATION")
public class AccoutingInformation {
    @Id
    @Column(name = "MEMBER_ID")
    //TODO Добавить связь  к классу ACCOUTING_INFORMATION - Member| 1-1
    private String memberId;

    @Column(name = "ACCOUTING_INFORMATION_OGRN")
    private String ogrn;

    @Column(name = "ACCOUTING_INFORMATION_KPP")
    private String kpp;

    @Column(name = "ACCOUTING_INFORMATION_TIN")
    private String tin;

    private AccoutingInformation() {

    }

    public AccoutingInformation(String memberId, String ogrn, String kpp, String tin) {
        this.memberId = memberId;
        this.ogrn = ogrn;
        this.kpp = kpp;
        this.tin = tin;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
}
