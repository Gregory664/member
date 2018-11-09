package ru.POJO.buh;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INVOICE")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID", nullable = false)
    private Integer invoiceId;

    @Column(name = "MEMBER_ID", nullable = false)
    //TODO Добавить связь к классу GENERAL_INFORMATION-Member| 1-1
    private String memberId;

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

    public Invoice(String memberId, Date date, String status, String delivery, String comment) {
        this.memberId = memberId;
        this.date = date;
        this.status = status;
        this.delivery = delivery;
        this.comment = comment;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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
}
