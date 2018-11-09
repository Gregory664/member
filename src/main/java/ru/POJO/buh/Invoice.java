package ru.POJO.buh;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INVOICE")
public class Invoice {
    @Id
    //TODO Добавить автоинкрементную аннотацию
    @Column(name = "INVOICE_ID")
    private Integer invoiceId;

    @Column(name = "MEMBER_ID")
    //TODO Добавить связь к классу GENERAL_INFORMATION-Member| 1-1
    private String memberId;

    @Column(name = "INVOICE_DATE")
    private Date date;

    @Column(name = "INVOICE_STATUS")
    private String status;

    @Column(name = "INVOICE_GET")
    private String delivery;

    @Column(name = "INVOICE_COMMENT")
    private String comment;

    private Invoice() {

    }

    public Invoice(Integer invoiceId, String memberId, Date date, String status, String delivery, String comment) {
        this.invoiceId = invoiceId;
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
