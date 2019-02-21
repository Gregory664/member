package ru.src.model;

import javafx.fxml.FXML;

import java.time.LocalDate;

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
}
