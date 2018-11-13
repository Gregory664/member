package ru.model.src.buh;

import ru.model.src.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID", nullable = false)
    private Integer invoiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "MEMBER")
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Temporal(TemporalType.DATE)
    @Column(name = "INVOICE_DATE", nullable = false)
    private Date date;

    @Column(name = "INVOICE_STATUS", nullable = false)
    private String status;

    @Column(name = "INVOICE_GET", nullable = false)
    private String delivery;

    @Column(name = "INVOICE_COMMENT")
    private String comment;

    private Invoice() {

    }

    public Invoice(Member member, Date date, String status, String delivery, String comment) {
        this.member = member;
        this.date = date;
        this.status = status;
        this.delivery = delivery;
        this.comment = comment;
    }

    public Invoice(Member member, Date date, String status) {
        this.member = member;
        this.date = date;
        this.status = status;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", member=" + member.getMemberId() +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", delivery='" + delivery + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
