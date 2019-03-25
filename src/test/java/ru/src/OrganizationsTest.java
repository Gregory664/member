package ru.src;

import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.dto.Organizations;
import ru.src.model.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DBConnection.class)
public class OrganizationsTest {

    private Organizations organizations;

    @Before
    public void setUp() {
        List<Member> mockedMembers = prepareMembers();

        mockStatic(DBConnection.class);
        Mockito.when(DBConnection.getAllMembers()).thenReturn(mockedMembers);
        organizations = new Organizations();
    }

    @Test
    public void testInitialization() {
        List<Member> expected = prepareMembers();
        ObservableList<Member> members = organizations.getMembers();
        assertEquals(members.size(), expected.size());
    }

    @Test
    public void testUpdateMember() {
        Member modifiedMember = new Member("memberId_1", 123, "modifiedMemberStatus", LocalDate.now(), "modifiedMemberShortName");
        Member defaultMember = prepareMembers().stream().filter(member -> member.getMemberId().equals("memberId_1")).findFirst().get();

        organizations.updateMember(modifiedMember);

        Optional<Member> defaultMemberInResultList = organizations.getMembers().stream().filter(member -> member.equals(defaultMember)).findAny();
        assertFalse(defaultMemberInResultList.isPresent());

        Optional<Member> modifiedMemberInResultList = organizations.getMembers().stream().filter(user -> user.equals(modifiedMember)).findFirst();
        assertTrue(modifiedMemberInResultList.isPresent());
        assertEquals(modifiedMember, modifiedMemberInResultList.get());
    }

    @Ignore
    @Test
    public void testRefresh() {
        Member modifiedMember = new Member("memberId_1", 123, "modifiedMemberStatus", LocalDate.now(), "modifiedMemberShortName");
        Member defaultMember = prepareMembers().stream().filter(member -> member.getMemberId().equals("memberId_1")).findFirst().get();

        organizations.updateMember(modifiedMember);

        Optional<Member> defaultMemberInResultList = organizations.getMembers().stream().filter(member -> member.equals(defaultMember)).findAny();
        assertFalse(defaultMemberInResultList.isPresent());

        Optional<Member> modifiedMemberInResultList = organizations.getMembers().stream().filter(user -> user.equals(modifiedMember)).findFirst();
        assertTrue(modifiedMemberInResultList.isPresent());
        assertEquals(modifiedMember, modifiedMemberInResultList.get());

        organizations.refresh();

        defaultMemberInResultList = organizations.getMembers().stream().filter(member -> member.equals(defaultMember)).findAny();
        assertTrue(defaultMemberInResultList.isPresent());

        modifiedMemberInResultList = organizations.getMembers().stream().filter(user -> user.equals(modifiedMember)).findFirst();
        assertFalse(modifiedMemberInResultList.isPresent());
    }

    private List<Member> prepareMembers() {
        List<Member> result = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            result.add(new Member("memberId_" + i, i, "memberStatus_" + i, LocalDate.now(), "memberShortName_" + i));
        }
        return result;
    }
}
