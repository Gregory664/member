package ru.POJO;

import javax.persistence.*;
import java.util.Date;

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
}
