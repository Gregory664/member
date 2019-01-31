package ru.src.model;

public class FindMember {
    private String memberId;
    private String memberSerial;
    private String memberStatus;
    private String phone;
    private String memberShortName;
    private String email;

    public FindMember(String memberId, String memberSerial, String phone, String memberStatus, String memberShortName, String email) {
        this.memberId = memberId;
        this.memberSerial = memberSerial;
        this.memberStatus = memberStatus;
        this.phone = phone;
        this.memberShortName = memberShortName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
