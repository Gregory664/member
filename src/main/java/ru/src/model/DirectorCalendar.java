package ru.src.model;

import java.time.LocalDate;

public class DirectorCalendar {
    private String memberId;
    private String fio;
    private String shortName;
    private LocalDate birthday;

    private DirectorCalendar() {}

    public DirectorCalendar(String memberId, String fio, String shortName, LocalDate birthday) {
        this.memberId = memberId;
        this.fio = fio;
        this.shortName = shortName;
        this.birthday = birthday;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
