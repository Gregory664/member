package ru.src.logic.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import ru.src.logic.interfaces.MemberLogic;
import ru.src.model.Member;

public class Organizations implements MemberLogic {

    private ObservableList<Member> members = FXCollections.observableArrayList();

    public ObservableList<Member> getMembers() {
        return members;
    }

    public Organizations() {
        initialize();
    }

    private void initialize() {
        members.addAll(DBConnection.getAllMembers());
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public void updateMember(Member member) {
        int searchIndex = 0;
        for(Member searchMember: members) {
            if(searchMember.getMemberId().equals(member.getMemberId())) {
                searchIndex = members.indexOf(searchMember);
            }
        }
        members.set(searchIndex, member);
    }

    public void refresh() {
        members.clear();
        if(HibernateUtils.isActive()) initialize();
    }

    public Integer getLength() {
        return members.size();
    }




}
