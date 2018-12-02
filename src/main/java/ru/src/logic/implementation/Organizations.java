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

    //TODO Добавить обновление объекта в листе
    public void updateMember(Member member) { }




}
