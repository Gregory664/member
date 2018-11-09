package ru.POJO;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS_LEGAL")
public class AddressLegal {

    @Id
    @Column(name = "MEMBER_ID")
    //TODO Добавить связь к классу ADDRESS_LEGAL-Member| 1-1
    private String memberId;

    @Column(name = "ADDRESS_LEGAL_INDEX")
    private Integer index;

    @Column(name = "ADDRESS_LEGAL_TOWN")
    private String town;

    @Column(name = "ADDRESS_LEGAL_STREET")
    private String street;

    @Column(name = "ADDRESS_LEGAL_HOUSE")
    private String house;

    @Column(name = "ADDRESS_LEGAL_OFFICE", nullable = false)
    private String office;

    @Column(name = "ADDRESS_LEGAL_DISTRICT")
    private String district;

    @Column(name = "ADDRESS_LEGAL_CHANGES", nullable = false)
    private String changes;

    private AddressLegal() {

    }

    public AddressLegal(String memberId, Integer index, String town, String street, String house, String office, String district, String changes) {
        this.memberId = memberId;
        this.index = index;
        this.town = town;
        this.street = street;
        this.house = house;
        this.office = office;
        this.district = district;
        this.changes = changes;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }
}
