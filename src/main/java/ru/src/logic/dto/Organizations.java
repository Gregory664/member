package ru.src.logic.dto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.factory.HibernateUtils;
import ru.src.entities.Member;
import ru.src.logic.implementation.SearchParameter;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Organizations {
    private final static Integer DEFAULT_PAGE_SIZE = 10;

    private ObservableList<Member> members = FXCollections.observableArrayList();
    private Long fullSize;
    private int pageSize;
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
        lastPageNumber = (int) Math.ceil(fullSize * 1.0 / pageSize);
        currentPage = 1;
        fillMembers();
    }

    public Long getFullSize() {
        return fullSize;
    }

    public Organizations() {
        this.fullSize = DBConnection.getMemberCount();
        pageSize = DEFAULT_PAGE_SIZE;
        lastPageNumber = (int) Math.ceil(fullSize * 1.0 / pageSize);
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
        if (currentPage < 1) {
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

    public void refreshBySearchParam(SearchParameter parameter, String findParams) {
        List<Member> searchMemberList = DBConnection.getMemberListBySearchParameter(parameter, findParams);
        fullSize = (long) searchMemberList.size();
        members.clear();
        members.addAll(searchMemberList);
    }

    public void refresh() {
        if (HibernateUtils.isActive()) {
            this.fullSize = DBConnection.getMemberCount();
            setPageSize(DEFAULT_PAGE_SIZE);
        }
    }

    public void clear() {
        fullSize = 0L;
        pageSize = 0;
        currentPage = 1;
        lastPageNumber = 1;
        members.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizations that = (Organizations) o;
        return pageSize == that.pageSize &&
                lastPageNumber == that.lastPageNumber &&
                members.equals(that.members) &&
                fullSize.equals(that.fullSize) &&
                Objects.equals(currentPage, that.currentPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members, fullSize, pageSize, currentPage, lastPageNumber);
    }
}


