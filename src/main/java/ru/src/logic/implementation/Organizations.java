package ru.src.logic.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.src.logic.interfaces.MemberLogic;
import ru.src.model.Member;

import java.util.Optional;

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
        Optional<Member> memberToModify = members.stream().filter(defaultMember -> defaultMember.getMemberId().equals(member.getMemberId())).findFirst();
        if(memberToModify.isPresent()) {
            int index = members.indexOf(memberToModify.get());
            members.set(index, member);
        }
    }

    public void refresh() {
        members.clear();
        if(HibernateUtils.isActive()) initialize();
    }

    public Integer getLength() {
        return members.size();
    }




}
