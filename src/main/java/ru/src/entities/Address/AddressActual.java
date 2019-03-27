package ru.src.entities.Address;

import ru.src.entities.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ADDRESS_ACTUAL")
public class AddressActual implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "ADDRESS_ACTUAL_REGION_ID")
    private Integer regionId;

    @Column(name = "ADDRESS_ACTUAL_REGION_NAME")
    private String regionName;

    @Column(name = "ADDRESS_ACTUAL_INDEX", nullable = false)
    private Integer index;

    @Column(name = "ADDRESS_ACTUAL_TOWN", nullable = false)
    private String town;

    @Column(name = "ADDRESS_ACTUAL_STREET", nullable = false)
    private String street;

    @Column(name = "ADDRESS_ACTUAL_HOUSE", nullable = false)
    private String house;

    @Column(name = "ADDRESS_ACTUAL_OFFICE")
    private String office;

    @Column(name = "ADDRESS_ACTUAL_DISTRICT")
    private String district;

    @Column(name = "ADDRESS_ACTUAL_CHANGES")
    private String changes;

    public AddressActual() { }

    public AddressActual(Member member,
                         Integer regionId,
                         String regionName,
                         Integer index,
                         String town,
                         String street,
                         String house,
                         String office,
                         String district,
                         String changes) {
        this.member = member;
        this.regionId = regionId;
        this.regionName = regionName;
        this.index = index;
        this.town = town;
        this.street = street;
        this.house = house;
        this.office = office;
        this.district = district;
        this.changes = changes;
    }

    public AddressActual(Member member, Integer regionId, String regionName, Integer index, String town, String street, String house) {
        this.member = member;
        this.regionId = regionId;
        this.regionName = regionName;
        this.index = index;
        this.town = town;
        this.street = street;
        this.house = house;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressActual that = (AddressActual) o;
        return member.equals(that.member) &&
                regionId.equals(that.regionId) &&
                regionName.equals(that.regionName) &&
                index.equals(that.index) &&
                town.equals(that.town) &&
                street.equals(that.street) &&
                house.equals(that.house) &&
                Objects.equals(office, that.office) &&
                Objects.equals(district, that.district) &&
                Objects.equals(changes, that.changes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, regionId, regionName, index, town, street, house, office, district, changes);
    }

    @Override
    public String toString() {
        return "AddressActual{" +
                "member=" + member +
                ", regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                ", index=" + index +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", office='" + office + '\'' +
                ", district='" + district + '\'' +
                ", changes='" + changes + '\'' +
                '}';
    }
}
