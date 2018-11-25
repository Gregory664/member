package ru.src.model.buh;

import ru.src.model.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID", nullable = false)
    private Integer invoiceId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "INVOICE_NUMBER", nullable = false)
    private Integer invoiceNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "INVOICE_DATE_OF_CREATION", nullable = false)
    private Date dateCreation;

    @Column(name = "INVOICE_STATUS_OF_RECEIVING")
    private Boolean statusReceiving;

    @Temporal(TemporalType.DATE)
    @Column(name = "INVOICE_DATE_OF_RECEIVING")
    private Date dateReceiving;

    @Column(name = "INVOICE_STATUS_OF_PAYMENT")
    private Boolean statusPayment;

    @Column(name = "INVOICE_ORDER_ID")
    private Integer orderId;

    @Temporal(TemporalType.DATE)
    @Column(name = "INVOICE_ORDER_DATE")
    private Date orderDate;

    @Column(name = "INVOICE_PRICE")
    private Integer price;

    @Column(name = "INVOICE_COMMENT")
    private String comment;

    private Invoice() {

    }

    public Invoice(Integer invoiceId, Member member, Integer invoiceNumber, Date dateCreation) {
        this.invoiceId = invoiceId;
        this.member = member;
        this.invoiceNumber = invoiceNumber;
        this.dateCreation = dateCreation;
    }

    public Invoice(Integer invoiceId,
                   Member member,
                   Integer invoiceNumber,
                   Date dateCreation,
                   Boolean statusReceiving,
                   Date dateReceiving,
                   Boolean statusPayment,
                   Integer orderId,
                   Date orderDate,
                   Integer price,
                   String comment) {
        this.invoiceId = invoiceId;
        this.member = member;
        this.invoiceNumber = invoiceNumber;
        this.dateCreation = dateCreation;
        this.statusReceiving = statusReceiving;
        this.dateReceiving = dateReceiving;
        this.statusPayment = statusPayment;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.price = price;
        this.comment = comment;
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

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getStatusReceiving() {
        return statusReceiving;
    }

    public void setStatusReceiving(Boolean statusReceiving) {
        this.statusReceiving = statusReceiving;
    }

    public Date getDateReceiving() {
        return dateReceiving;
    }

    public void setDateReceiving(Date dateReceiving) {
        this.dateReceiving = dateReceiving;
    }

    public Boolean getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(Boolean statusPayment) {
        this.statusPayment = statusPayment;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
