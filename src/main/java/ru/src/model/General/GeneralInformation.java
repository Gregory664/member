package ru.src.model.General;

import ru.src.model.Member;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GENERAL_INFORMATION")
public class GeneralInformation implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
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
    private boolean interactionOffline;

    @Column(name = "INTERACTION_ONLINE", nullable = false)
    private boolean interactionOnline;

    @Column(name = "B2B", nullable = false)
    private boolean b2b;

    @Column(name = "B2C", nullable = false)
    private boolean b2c;

    @Column(name = "BUSINESS_MISSION_VISITING", nullable = false)
    private boolean businessMissionVisiting;

    @Column(name = "BUSINESS_MISSION_REGIONAL", nullable = false)
    private boolean businessMissionRegional;

    @Column(name = "MKAS", nullable = false)
    private boolean mkas;

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
                              boolean interactionOffline,
                              boolean interactionOnline,
                              boolean b2b,
                              boolean b2c,
                              boolean businessMissionVisiting,
                              boolean businessMissionRegional,
                              boolean mkas,
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
        this.b2b = b2b;
        this.b2c = b2c;
        this.businessMissionVisiting = businessMissionVisiting;
        this.businessMissionRegional = businessMissionRegional;
        this.mkas = mkas;
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
                              boolean interactionOffline,
                              boolean interactionOnline,
                              boolean b2b,
                              boolean b2c,
                              boolean businessMissionVisiting,
                              boolean businessMissionRegional,
                              boolean mkas) {
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
        this.b2b = b2b;
        this.b2c = b2c;
        this.businessMissionVisiting = businessMissionVisiting;
        this.businessMissionRegional = businessMissionRegional;
        this.mkas = mkas;
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

    public boolean isInteractionOffline() {
        return interactionOffline;
    }

    public void setInteractionOffline(boolean interactionOffline) {
        this.interactionOffline = interactionOffline;
    }

    public boolean isInteractionOnline() {
        return interactionOnline;
    }

    public void setInteractionOnline(boolean interactionOnline) {
        this.interactionOnline = interactionOnline;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public boolean isB2b() {
        return b2b;
    }

    public void setB2b(boolean b2b) {
        this.b2b = b2b;
    }

    public boolean isB2c() {
        return b2c;
    }

    public void setB2c(boolean b2c) {
        this.b2c = b2c;
    }

    public boolean isBusinessMissionVisiting() {
        return businessMissionVisiting;
    }

    public void setBusinessMissionVisiting(boolean businessMissionVisiting) {
        this.businessMissionVisiting = businessMissionVisiting;
    }

    public boolean isBusinessMissionRegional() {
        return businessMissionRegional;
    }

    public void setBusinessMissionRegional(boolean businessMissionRegional) {
        this.businessMissionRegional = businessMissionRegional;
    }

    public boolean isMkas() {
        return mkas;
    }

    public void setMkas(boolean mkas) {
        this.mkas = mkas;
    }
}
