package ru.src.entities;

import java.time.LocalDate;
import java.util.Objects;

public class DirectorCalendar {
    private String memberId;
    private String fio;
    private String shortName;
    private LocalDate birthday;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorCalendar that = (DirectorCalendar) o;
        return memberId.equals(that.memberId) &&
                fio.equals(that.fio) &&
                shortName.equals(that.shortName) &&
                birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, fio, shortName, birthday);
    }

    @Override
    public String toString() {
        return "DirectorCalendar{" +
                "memberId='" + memberId + '\'' +
                ", fio='" + fio + '\'' +
                ", shortName='" + shortName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
