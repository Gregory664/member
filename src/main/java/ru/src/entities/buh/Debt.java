package ru.src.entities.buh;

import ru.src.entities.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "DEBT")
public class Debt implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "DEBT_STATUS", nullable = false)
    private boolean status;

    @Column(name = "DEBT_PERIOD")
    private String period;

    @Column(name = "DEBT_COMMENT")
    private String comment;

    public Debt() {
    }

    public Debt(Member member, boolean status) {
        this.member = member;
        this.status = status;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Debt debt = (Debt) o;
        return status == debt.status &&
                Objects.equals(period, debt.period) &&
                Objects.equals(comment, debt.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, period, comment);
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
