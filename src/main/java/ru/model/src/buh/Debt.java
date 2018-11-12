package ru.model.src.buh;

import ru.model.src.Member;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DEBT")
public class Debt implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "DEBT_STATUS", nullable = false)
    private String status;

    @Column(name = "DEBT_PERIOD")
    private String period;

    @Column(name = "DEBT_COMMENT")
    private String comment;

    private Debt() {

    }

    public Debt(Member member, String status, String period, String comment) {
        this.member = member;
        this.status = status;
        this.period = period;
        this.comment = comment;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Debt{" +
                "member=" + member.getMemberId() +
                ", status='" + status + '\'' +
                ", period='" + period + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
