package ru.src.model;

public class FindMember {
    private String memberId;
    private String memberSerial;
    private String memberStatus;
    private String phone;
    private String memberShortName;

    public FindMember(String memberId, String memberSerial, String memberStatus, String phone, String memberShortName) {
        this.memberId = memberId;
        this.memberSerial = memberSerial;
        this.memberStatus = memberStatus;
        this.phone = phone;
        this.memberShortName = memberShortName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberSerial() {
        return memberSerial;
    }

    public void setMemberSerial(String memberSerial) {
        this.memberSerial = memberSerial;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemberShortName() {
        return memberShortName;
    }

    public void setMemberShortName(String memberShortName) {
        this.memberShortName = memberShortName;
    }
}
