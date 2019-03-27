package ru.src.entities.buh;

import ru.src.entities.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "INVOICE")
public class Invoice implements Serializable {
    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    private String invoiceId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    public Member member;

    @Column(name = "INVOICE_NUMBER", nullable = false)
    private Integer invoiceNumber;

    @Column(name = "INVOICE_DATE_OF_CREATION", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "INVOICE_STATUS_OF_RECEIVING", nullable = false)
    private Boolean statusReceiving;

    @Column(name = "INVOICE_DATE_OF_RECEIVING")
    private LocalDate dateReceiving;

    @Column(name = "INVOICE_STATUS_OF_PAYMENT", nullable = false)
    private Boolean statusPayment;

    @Column(name = "INVOICE_ORDER_ID")
    private String orderId;

    @Column(name = "INVOICE_ORDER_DATE")
    private LocalDate orderDate;

    @Column(name = "INVOICE_PRICE", nullable = false)
    private Integer price;

    @Column(name = "INVOICE_COMMENT")
    private String comment;

    public Invoice() {
    }

    public Invoice(Member member, Integer invoiceNumber, LocalDate dateCreation, Integer price) {
        this.member = member;
        this.invoiceNumber = invoiceNumber;
        this.dateCreation = dateCreation;
        this.price = price;
        this.invoiceId = generateInvoiceId();
    }

    private String generateInvoiceId() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        return this.invoiceNumber + this.dateCreation.format(formatter);
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId.equals(invoice.invoiceId) &&
                member.equals(invoice.member) &&
                invoiceNumber.equals(invoice.invoiceNumber) &&
                dateCreation.equals(invoice.dateCreation) &&
                statusReceiving.equals(invoice.statusReceiving) &&
                Objects.equals(dateReceiving, invoice.dateReceiving) &&
                statusPayment.equals(invoice.statusPayment) &&
                Objects.equals(orderId, invoice.orderId) &&
                Objects.equals(orderDate, invoice.orderDate) &&
                price.equals(invoice.price) &&
                Objects.equals(comment, invoice.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, member, invoiceNumber, dateCreation, statusReceiving, dateReceiving, statusPayment, orderId, orderDate, price, comment);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", member=" + member +
                ", invoiceNumber=" + invoiceNumber +
                ", dateCreation=" + dateCreation +
                ", statusReceiving=" + statusReceiving +
                ", dateReceiving=" + dateReceiving +
                ", statusPayment=" + statusPayment +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                '}';
    }
}
