package ru.src.model.buh;

import ru.src.model.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {
    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    private Integer invoiceId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "INVOICE_NUMBER", nullable = false)
    private Integer invoiceNumber;

    @Column(name = "INVOICE_DATE_OF_CREATION", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "INVOICE_STATUS_OF_RECEIVING")
    private Boolean statusReceiving;

    @Column(name = "INVOICE_DATE_OF_RECEIVING")
    private LocalDate dateReceiving;

    @Column(name = "INVOICE_STATUS_OF_PAYMENT")
    private Boolean statusPayment;

    @Column(name = "INVOICE_ORDER_ID")
    private Integer orderId;

    @Column(name = "INVOICE_ORDER_DATE")
    private LocalDate orderDate;

    @Column(name = "INVOICE_PRICE", nullable = false)
    private Integer price;

    @Column(name = "INVOICE_COMMENT")
    private String comment;


    private Invoice() {

    }

    public Invoice(Member member, Integer invoiceNumber, LocalDate dateCreation, Integer price) {
        this.member = member;
        this.invoiceNumber = invoiceNumber;
        this.dateCreation = dateCreation;
        this.price = price;
        this.invoiceId = generateInvoiceId();
    }


    private Integer generateInvoiceId() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        BigDecimal numberFromSumParams = new BigDecimal(invoiceNumber + dateCreation.format(formatter) + price);
        double doubleSqrt = Math.sqrt(Math.sqrt(numberFromSumParams.doubleValue()));
        return Math.toIntExact(Math.round(doubleSqrt));
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

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getStatusReceiving() {
        return statusReceiving;
    }

    public void setStatusReceiving(Boolean statusReceiving) {
        this.statusReceiving = statusReceiving;
    }

    public LocalDate getDateReceiving() {
        return dateReceiving;
    }

    public void setDateReceiving(LocalDate dateReceiving) {
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
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
