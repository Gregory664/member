package ru.src.model.Personal;

import org.hibernate.annotations.CreationTimestamp;
import ru.src.model.Member;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "RELATE")
public class Relate implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "RELATE_FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "RELATE_SIZE", nullable = false)
    private Integer size;

    @Column(name = "RELATE_DATE_OF_CREATION")
    private LocalDate dateOfCreation;

    @Column(name = "RELATE_SERVICES", nullable = false)
    private String services;

    @Column(name = "RELATE_CHANGES")
    private String changes;


    private Relate() {

    }

    public Relate(Member member, String fullName, Integer size, String services) {
        this.member = member;
        this.fullName = fullName;
        this.size = size;
        this.services = services;
    }

    public Relate(Member member, String fullName, Integer size, LocalDate dateOfCreation, String services, String changes) {
        this.member = member;
        this.fullName = fullName;
        this.size = size;
        this.dateOfCreation = dateOfCreation;
        this.services = services;
        this.changes = changes;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
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


    @Override
    public String toString() {
        return "Relate{" +
                "member=" + member.getMemberId() +
                ", fullName='" + fullName + '\'' +
                ", size='" + size + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", services='" + services + '\'' +
                ", changes='" + changes + '\'' +
                '}';
    }
}
