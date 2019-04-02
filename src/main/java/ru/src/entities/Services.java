package ru.src.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SERVICES")
public class Services {
    @Id
    @Column(name = "SERVICES_ID", nullable = false)
    private Integer servicesId;

    @Column(name = "SERVICES_NAME", nullable = false)
    private String servicesName;

    public Services() { }

    public Services(Integer servicesId, String servicesName) {
        this.servicesId = servicesId;
        this.servicesName = servicesName;
    }

    public Integer getServicesId() {
        return servicesId;
    }

    public void setServicesId(Integer servicesId) {
        this.servicesId = servicesId;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Services services = (Services) o;
        return servicesId.equals(services.servicesId) &&
                servicesName.equals(services.servicesName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicesId, servicesName);
    }

    @Override
    public String toString() {
        return "Services{" +
                "servicesId=" + servicesId +
                ", servicesName='" + servicesName + '\'' +
                '}';
    }
}
