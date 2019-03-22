package ru.src.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SOCIAL_NETWORKS")
public class SocialNetworks implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member memberId;

    @Column(name = "SOCIAL_NETWORKS_VKONTAKTE")
    private String vkontakte;

    @Column(name = "SOCIAL_NETWORKS_FACEBOOK")
    private String facebook;

    @Column(name = "SOCIAL_NETWORKS_TELEGRAM")
    private String telegram;

    @Column(name = "SOCIAL_NETWORKS_WHATSAPP")
    private String whatsapp;

    @Column(name = "SOCIAL_NETWORKS_VIBER")
    private String viber;

    @Column(name = "SOCIAL_NETWORKS_SKYPE")
    private String skype;

    @Column(name = "SOCIAL_NETWORKS_INSTAGRAM")
    private String instagram;

    @Column(name = "SOCIAL_NETWORKS_TWITTER")
    private String twitter;

    @Column(name = "SOCIAL_NETWORKS_YOUTUBE")
    private String youtube;

    public SocialNetworks(Member memberId) {
        this.memberId = memberId;
    }

    private SocialNetworks() { }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public String getVkontakte() {
        return vkontakte;
    }

    public void setVkontakte(String vkontakte) {
        this.vkontakte = vkontakte;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getViber() {
        return viber;
    }

    public void setViber(String viber) {
        this.viber = viber;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
