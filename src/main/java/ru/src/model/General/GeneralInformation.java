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
    private boolean vedImport;

    @Column(name = "VED_EXPORT", nullable = false)
    private boolean vedExport;

    @Column(name = "INVESTMENTS_TARGET")
    private String investmentsTarget;

    @Column(name = "INVESTMENTS_SIZE")
    private Integer investmentsSize;

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

    @Column(name = "NEED_FOR_YOUNG_PERSONNEL", nullable = false)
    private boolean needForYoungPersonnel;

    @Column(name = "DISCOUNTS", nullable = false)
    private boolean discounts;

    @Column(name = "RELIABLE_PARTNERS", nullable = false)
    private boolean reliablePartners;

    @Column(name = "PILOT_PROJECTS", nullable = false)
    private boolean pilotProjects;

    @Column(name = "ANTI_CORRUPTION_CHARTER", nullable = false)
    private boolean antiCorruptionCharter;

    @Column(name = "NEWSLETTER", nullable = false)
    private boolean newsletter;

    @Column(name = "COMMITTEES", nullable = false)
    private boolean committees;

    @Column(name = "CORPORATE_MEMBER", nullable = false)
    private boolean corporateMember;

    @Column(name = "GENERAL_INFORMATION_CHANGES")
    private String changes;


    private GeneralInformation() {

    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public boolean isCommittees() {
        return committees;
    }

    public void setCommittees(boolean committees) {
        this.committees = committees;
    }

    public boolean isCorporateMember() {
        return corporateMember;
    }

    public void setCorporateMember(boolean corporateMember) {
        this.corporateMember = corporateMember;
    }

    public boolean isNeedForYoungPersonnel() {
        return needForYoungPersonnel;
    }

    public void setNeedForYoungPersonnel(boolean needForYoungPersonnel) {
        this.needForYoungPersonnel = needForYoungPersonnel;
    }

    public boolean isDiscounts() {
        return discounts;
    }

    public void setDiscounts(boolean discounts) {
        this.discounts = discounts;
    }

    public boolean isReliablePartners() {
        return reliablePartners;
    }

    public void setReliablePartners(boolean reliablePartners) {
        this.reliablePartners = reliablePartners;
    }

    public boolean isPilotProjects() {
        return pilotProjects;
    }

    public void setPilotProjects(boolean pilotProjects) {
        this.pilotProjects = pilotProjects;
    }

    public boolean isAntiCorruptionCharter() {
        return antiCorruptionCharter;
    }

    public void setAntiCorruptionCharter(boolean antiCorruptionCharter) {
        this.antiCorruptionCharter = antiCorruptionCharter;
    }

    public GeneralInformation(Member member,
                              String organizationForm,
                              String economicSector,
                              String ownershipForm,
                              String activityType,
                              String businessForm,
                              boolean vedImport,
                              boolean vedExport,
                              boolean interactionOffline,
                              boolean interactionOnline,
                              boolean b2b,
                              boolean b2c,
                              boolean businessMissionVisiting,
                              boolean businessMissionRegional,
                              boolean mkas,
                              boolean needForYoungPersonnel,
                              boolean discounts,
                              boolean reliablePartners,
                              boolean pilotProjects,
                              boolean antiCorruptionCharter,
                              boolean newsletter,
                              boolean committees,
                              boolean corporateMember) {
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
        this.needForYoungPersonnel = needForYoungPersonnel;
        this.discounts = discounts;
        this.reliablePartners = reliablePartners;
        this.pilotProjects = pilotProjects;
        this.antiCorruptionCharter = antiCorruptionCharter;
        this.newsletter = newsletter;
        this.committees = committees;
        this.corporateMember = corporateMember;
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

    public boolean isVedImport() {
        return vedImport;
    }

    public void setVedImport(boolean vedImport) {
        this.vedImport = vedImport;
    }

    public boolean isVedExport() {
        return vedExport;
    }

    public void setVedExport(boolean vedExport) {
        this.vedExport = vedExport;
    }

    public String getInvestmentsTarget() {
        return investmentsTarget;
    }

    public void setInvestmentsTarget(String investmentsTarget) {
        this.investmentsTarget = investmentsTarget;
    }

    public Integer getInvestmentsSize() {
        return investmentsSize;
    }

    public void setInvestmentsSize(Integer investmentsSize) {
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

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }
}
