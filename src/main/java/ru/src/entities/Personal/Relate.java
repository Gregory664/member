package ru.src.entities.Personal;

import ru.src.entities.Member;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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

    public Relate() {
    }

    public Relate(Member member, String fullName, Integer size, String services) {
        this.member = member;
        this.fullName = fullName;
        this.size = size;
        this.services = services;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relate relate = (Relate) o;
        return member.equals(relate.member) &&
                fullName.equals(relate.fullName) &&
                size.equals(relate.size) &&
                Objects.equals(dateOfCreation, relate.dateOfCreation) &&
                services.equals(relate.services) &&
                Objects.equals(changes, relate.changes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, fullName, size, dateOfCreation, services, changes);
    }

    @Override
    public String toString() {
        return "Relate{" +
                "member=" + member +
                ", fullName='" + fullName + '\'' +
                ", size=" + size +
                ", dateOfCreation=" + dateOfCreation +
                ", services='" + services + '\'' +
                ", changes='" + changes + '\'' +
                '}';
    }
}
