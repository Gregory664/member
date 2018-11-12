package ru.model.src.Personal;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT")
public class ContactOrg {

    //FIXME Разобраться с этим классом
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID", nullable = false)
    private Integer contactId;

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

    public ContactOrg(Integer contactId, String phone, String fax, String site, String email, String changes) {
        this.contactId = contactId;
        this.phone = phone;
        this.fax = fax;
        this.site = site;
        this.email = email;
        this.changes = changes;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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


}
