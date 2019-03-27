package ru.src.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindMember that = (FindMember) o;
        return memberId.equals(that.memberId) &&
                memberSerial.equals(that.memberSerial) &&
                memberStatus.equals(that.memberStatus) &&
                phone.equals(that.phone) &&
                memberShortName.equals(that.memberShortName) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberSerial, memberStatus, phone, memberShortName, email);
    }

    @Override
    public String toString() {
        return "FindMember{" +
                "memberId='" + memberId + '\'' +
                ", memberSerial='" + memberSerial + '\'' +
                ", memberStatus='" + memberStatus + '\'' +
                ", phone='" + phone + '\'' +
                ", memberShortName='" + memberShortName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
