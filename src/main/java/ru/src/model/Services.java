package ru.src.model;

import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "SERVICES")
public class Services {
    @Id
    @Column(name = "SERVICES_ID", nullable = false)
    private Integer servicesId;

    @Column(name = "SERVICES_NAME", nullable = false)
    private String servicesName;

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

    private Services() {}

    public Services(Integer servicesId, String servicesName) {
        this.servicesId = servicesId;
        this.servicesName = servicesName;
    }
}
