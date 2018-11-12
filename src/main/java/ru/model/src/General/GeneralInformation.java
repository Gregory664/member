package ru.model.src.General;

import ru.model.src.Member;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GENERAL_INFORMATION")
public class GeneralInformation implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "ORGANIZATION_FORM", nullable = false)
    private String organizationForm;

    @Column(name = "ECONOMIC_SECTOR", nullable = false)
    private String economicSector;

    @Column(name = "OWNERSHIP_FORM", nullable = false)
    private String ownershipForm;

    @Column(name = "ACTIVITY_TYPE", nullable = false)
    private String activityType;

    @Column(name = "BUSINESS_FORM", nullable = false)
    private String businessForm;

    @Column(name = "VED_IMPORT", nullable = false)
    private String vedImport;

    @Column(name = "VED_EXPORT", nullable = false)
    private String vedExport;

    @Column(name = "INVESTMENTS_TARGET")
    private String investmentsTarget;

    @Column(name = "INVESTMENTS_SIZE")
    private String investmentsSize;

    @Column(name = "INTERACTION_OFFLINE", nullable = false)
    private String interactionOffline;

    @Column(name = "INTERACTION_ONLINE", nullable = false)
    private String interactionOnline;

    @Column(name = "GENERAL_INFORMATION_CHANGES")
    private String changes;

    private GeneralInformation() {

    }

    public GeneralInformation(Member member,
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
        this.member = member;
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

    public GeneralInformation(Member member,
                              String organizationForm,
                              String economicSector,
                              String ownershipForm,
                              String activityType,
                              String businessForm,
                              String vedImport,
                              String vedExport,
                              String interactionOffline,
                              String interactionOnline,
                              String changes) {
        this.member = member;
        this.organizationForm = organizationForm;
        this.economicSector = economicSector;
        this.ownershipForm = ownershipForm;
        this.activityType = activityType;
        this.businessForm = businessForm;
        this.vedImport = vedImport;
        this.vedExport = vedExport;
        this.interactionOffline = interactionOffline;
        this.interactionOnline = interactionOnline;
        this.changes = changes;
    }

    public GeneralInformation(Member member,
                              String organizationForm,
                              String economicSector,
                              String ownershipForm,
                              String activityType,
                              String businessForm,
                              String vedImport,
                              String vedExport,
                              String interactionOffline,
                              String interactionOnline) {
        this.member = member;
        this.organizationForm = organizationForm;
        this.economicSector = economicSector;
        this.ownershipForm = ownershipForm;
        this.activityType = activityType;
        this.businessForm = businessForm;
        this.vedImport = vedImport;
        this.vedExport = vedExport;
        this.interactionOffline = interactionOffline;
        this.interactionOnline = interactionOnline;
    }



    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    @Override
    public String toString() {
        return "GeneralInformation{" +
                "memberId='" + member.getMemberId() + '\'' +
                ", organizationForm='" + organizationForm + '\'' +
                ", economicSector='" + economicSector + '\'' +
                ", ownershipForm='" + ownershipForm + '\'' +
                ", activityType='" + activityType + '\'' +
                ", businessForm='" + businessForm + '\'' +
                ", vedImport='" + vedImport + '\'' +
                ", vedExport='" + vedExport + '\'' +
                ", investmentsTarget='" + investmentsTarget + '\'' +
                ", investmentsSize='" + investmentsSize + '\'' +
                ", interactionOffline='" + interactionOffline + '\'' +
                ", interactionOnline='" + interactionOnline + '\'' +
                ", changes='" + changes + '\'' +
                '}';
    }
}
