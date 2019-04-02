package ru.src.entities;

import javafx.fxml.FXML;

import java.time.LocalDate;
import java.util.Objects;

public class DateOfCreationOrganization {
    @FXML
    private LocalDate dateOfCreation;
    @FXML
    private String memberId;
    @FXML
    private String shortName;

    public DateOfCreationOrganization(LocalDate dateOfCreation, String memberId, String shortName) {
        this.dateOfCreation = dateOfCreation;
        this.memberId = memberId;
        this.shortName = shortName;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateOfCreationOrganization that = (DateOfCreationOrganization) o;
        return dateOfCreation.equals(that.dateOfCreation) &&
                memberId.equals(that.memberId) &&
                shortName.equals(that.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfCreation, memberId, shortName);
    }

    @Override
    public String toString() {
        return "DateOfCreationOrganization{" +
                "dateOfCreation=" + dateOfCreation +
                ", memberId='" + memberId + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
