package ru.POJO.buh;

import javax.persistence.*;

@Entity
@Table(name = "DEBT")
public class Debt {
    @Id
    @Column(name = "MEMBER_ID")
    //TODO Добавить связь к классу DEBT-Member| 1-1
    private String memberId;

    @Column(name = "DEBT_STATUS")
    private String status;

    @Column(name = "DEBT_PERIOD", nullable = false)
    private String period;

    @Column(name = "DEBT_COMMENT", nullable = false)
    private String comment;

    private Debt() {

    }

    public Debt(String memberId, String status, String period, String comment) {
        this.memberId = memberId;
        this.status = status;
        this.period = period;
        this.comment = comment;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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
}
