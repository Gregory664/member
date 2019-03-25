package ru.src.logic.dto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.factory.HibernateUtils;
import ru.src.logic.interfaces.MemberLogic;
import ru.src.model.Member;

import java.util.Optional;

public class Organizations implements MemberLogic {

    private ObservableList<Member> members = FXCollections.observableArrayList();
    private Long fullSize;
    private int pageSize = 2;
    private Integer currentPage = 1;
    private int lastPageNumber;

    public int getLastPageNumber() {
        return lastPageNumber;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        lastPageNumber =  (int) Math.ceil(fullSize * 1.0 / pageSize);
        currentPage = 1;
        members.clear();
        members.addAll(DBConnection.getMemberListPage(currentPage, pageSize));
    }

    public Long getFullSize() {
        return fullSize;
    }


    public Organizations() {
        this.fullSize = DBConnection.getMemberCount();
        lastPageNumber =  (int) Math.ceil(fullSize * 1.0 / pageSize);
        fillMembers();
    }

    public void nextPage() {
        currentPage++;
        if (currentPage > lastPageNumber) {
            currentPage = 1;
        }
        fillMembers();
    }

    public void previousPage() {
        currentPage--;
        if(currentPage < 1) {
            currentPage = lastPageNumber;
        }
        fillMembers();
    }

    private void fillMembers() {
        members.clear();
        members.addAll(DBConnection.getMemberListPage(currentPage, pageSize));
    }

    public void addMember(Member member) {
        DBConnection.addMember(member);
        members.add(member);
    }

    public void deleteMember(Member member) {
        DBConnection.deleteMember(member);
        members.remove(member);
    }

    public void updateMember(Member member) {
        DBConnection.updateMember(member);
        Optional<Member> memberToModify = members.stream().filter(defaultMember -> defaultMember.getMemberId().equals(member.getMemberId())).findFirst();
        if (memberToModify.isPresent()) {
            int index = members.indexOf(memberToModify.get());
            members.set(index, member);
        }
    }

    public ObservableList<Member> getMembers() {
        return members;
    }

    public void refresh() {
        if(HibernateUtils.isActive()) {
            new Organizations();
        } //TODO check this
//        members.clear();
//        if (HibernateUtils.isActive()) initialize();
    }
}


