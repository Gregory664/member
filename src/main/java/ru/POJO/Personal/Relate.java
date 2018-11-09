package ru.POJO.Personal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RELATE")
public class Relate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RELATE_ID", nullable = false)
    private Integer relateId;

    @Column(name = "RELATE_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "RELATE_SIZE", nullable = false)
    private String size;

    @Temporal(TemporalType.DATE)
    @Column(name = "RELATE_DATE_OF_CREATION")
    private Date dateOfCreation;

    @Column(name = "RELATE_SERVICES", nullable = false)
    private String services;

    @Column(name = "RELATE_CHANGES")
    private String changes;

    private Relate() {

    }

    public Relate(String fullName, String size, Date dateOfCreation, String services, String changes) {
        this.fullName = fullName;
        this.size = size;
        this.dateOfCreation = dateOfCreation;
        this.services = services;
        this.changes = changes;
    }

    public Integer getRelateId() {
        return relateId;
    }

    public void setRelateId(Integer relateId) {
        this.relateId = relateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }
}
