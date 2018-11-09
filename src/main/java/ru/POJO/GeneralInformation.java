package ru.POJO;

import javax.persistence.*;

@Entity
@Table(name = "GENERAL_INFORMATION")
public class GeneralInformation {
    @Id
    @Column(name = "MEMBER_ID")
    //TODO Добавить связь к классу GENERAL_INFORMATION-Member| 1-1
    private String memberId;

    @Column(name = "ORGANIZATION_FORM")
    private String organizationForm;

    @Column(name = "ECONOMIC_SECTOR")
    private String economicSector;

    @Column(name = "OWNERSHIP_FORM")
    private String ownershipForm;

    @Column(name = "ACTIVITY_TYPE")
    private String activityType;

    @Column(name = "BUSINESS_FORM")
    private String businessForm;

    @Column(name = "VED_IMPORT")
    private String vedImport;

    @Column(name = "VED_EXPORT")
    private String vedExport;

    @Column(name = "INVESTMENTS_TARGET", nullable = false)
    private String investmentsTarget;

    @Column(name = "INVESTMENTS_SIZE", nullable = false)
    private String investmentsSize;

    @Column(name = "INTERACTION_OFFLINE")
    private String interactionOffline;

    @Column(name = "INTERACTION_ONLINE")
    private String interactionOnline;

    @Column(name = "GENERAL_INFORMATION_CHANGES", nullable = false)
    private String changes;

    private GeneralInformation() {

    }

    public GeneralInformation(String memberId,
                              String organizationForm,
                              String economicSector,
                              String ownershipForm,
                              String activityType,
                              String businessForm,
                              String vedImport,
                              String vedExport,
                              String investmentsTarget,
                              String investmentsSize,
                              String interactionOffline,
                              String interactionOnline,
                              String changes) {

        this.memberId = memberId;
        this.organizationForm = organizationForm;
        this.economicSector = economicSector;
        this.ownershipForm = ownershipForm;
        this.activityType = activityType;
        this.businessForm = businessForm;
        this.vedImport = vedImport;
        this.vedExport = vedExport;
        this.investmentsTarget = investmentsTarget;
        this.investmentsSize = investmentsSize;
        this.interactionOffline = interactionOffline;
        this.interactionOnline = interactionOnline;
        this.changes = changes;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrganizationForm() {
        return organizationForm;
    }

    public void setOrganizationForm(String organizationForm) {
        this.organizationForm = organizationForm;
    }

    public String getEconomicSector() {
        return economicSector;
    }

    public void setEconomicSector(String economicSector) {
        this.economicSector = economicSector;
    }

    public String getOwnershipForm() {
        return ownershipForm;
    }

    public void setOwnershipForm(String ownershipForm) {
        this.ownershipForm = ownershipForm;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getBusinessForm() {
        return businessForm;
    }

    public void setBusinessForm(String businessForm) {
        this.businessForm = businessForm;
    }

    public String getVedImport() {
        return vedImport;
    }

    public void setVedImport(String vedImport) {
        this.vedImport = vedImport;
    }

    public String getVedExport() {
        return vedExport;
    }

    public void setVedExport(String vedExport) {
        this.vedExport = vedExport;
    }

    public String getInvestmentsTarget() {
        return investmentsTarget;
    }

    public void setInvestmentsTarget(String investmentsTarget) {
        this.investmentsTarget = investmentsTarget;
    }

    public String getInvestmentsSize() {
        return investmentsSize;
    }

    public void setInvestmentsSize(String investmentsSize) {
        this.investmentsSize = investmentsSize;
    }

    public String getInteractionOffline() {
        return interactionOffline;
    }

    public void setInteractionOffline(String interactionOffline) {
        this.interactionOffline = interactionOffline;
    }

    public String getInteractionOnline() {
        return interactionOnline;
    }

    public void setInteractionOnline(String interactionOnline) {
        this.interactionOnline = interactionOnline;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }
}
