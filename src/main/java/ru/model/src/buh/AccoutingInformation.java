package ru.model.src.buh;

import ru.model.src.Member;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUTING_INFORMATION")
public class AccoutingInformation implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "ACCOUTING_INFORMATION_OGRN", nullable = false)
    private String ogrn;

    @Column(name = "ACCOUTING_INFORMATION_KPP", nullable = false)
    private String kpp;

    @Column(name = "ACCOUTING_INFORMATION_TIN", nullable = false)
    private String tin;

    private AccoutingInformation() {

    }

    public AccoutingInformation(Member member, String ogrn, String kpp, String tin) {
        this.member = member;
        this.ogrn = ogrn;
        this.kpp = kpp;
        this.tin = tin;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    @Override
    public String toString() {
        return "AccoutingInformation{" +
                "member=" + member.getMemberId() +
                ", ogrn='" + ogrn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", tin='" + tin + '\'' +
                '}';
    }
}
