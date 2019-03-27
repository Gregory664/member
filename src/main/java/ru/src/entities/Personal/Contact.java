package ru.src.entities.Personal;

import ru.src.entities.Member;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "CONTACT_PHONE", nullable = false)
    private String phone;

    @Column(name = "CONTACT_FAX")
    private String fax;

    @Column(name = "CONTACT_SITE")
    private String site;

    @Column(name = "CONTACT_EMAIL", nullable = false)
    private String email;

    @Column(name = "CONTACT_CHANGES")
    private String changes;

    public Contact() { }

    public Contact(Member member, String phone, String email) {
        this.member = member;
        this.phone = phone;
        this.email = email;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        Contact contact = (Contact) o;
        return member.equals(contact.member) &&
                phone.equals(contact.phone) &&
                Objects.equals(fax, contact.fax) &&
                Objects.equals(site, contact.site) &&
                email.equals(contact.email) &&
                Objects.equals(changes, contact.changes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, phone, fax, site, email, changes);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "member=" + member.getMemberId() +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", site='" + site + '\'' +
                ", email='" + email + '\'' +
                ", changes='" + changes + '\'' +
                '}';
    }
}
