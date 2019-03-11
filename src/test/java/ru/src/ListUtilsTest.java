package ru.src;

import de.saxsys.javafx.test.JfxRunner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.src.logic.implementation.ListUtils;
import ru.src.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static ru.src.logic.implementation.ListConstants.*;

@RunWith(JfxRunner.class)
public class ListUtilsTest {

    @Test
    public void testGetMethods() {
        assertEquals(ACTIVITY_TYPE_LIST, ListUtils.getActivityType());
        assertEquals(BUSINESS_FORM_LIST, ListUtils.getBusinessForm());
        assertEquals(DEDB_STATUS_LIST, ListUtils.getDedbStatusList());
        assertEquals(DISTRICT_LIST, ListUtils.getDistrict());
        assertEquals(ECONOMIC_SECTOR_LIST, ListUtils.getEconomicSector());
        assertEquals(FIND_PARAMS_LIST, ListUtils.getFindParamsList());
        assertEquals(INTERESTING_LIST, ListUtils.getInteresting());
        assertEquals(MEMBER_STATUS_LIST, ListUtils.getMemberStatusList());
        assertEquals(ORGANIZATION_FORM_LIST, ListUtils.getOrganizationForm());
        assertEquals(OWNERSHIP_FORM_LIST, ListUtils.getOwnershipForm());
        assertEquals(VED_LIST, ListUtils.getYesNo());
        assertEquals(MONTHS_LIST, ListUtils.getMonth());
        assertEquals(REGION_MAP, ListUtils.getRegionMap());
    }

    @Test
    public void testGetDataFromCheckBoxMassive() {
        String title = "NewTestTitleForCheckBox";
        String expectedString = "selectedCheckBox_1, selectedCheckBox_2, selectedCheckBox_3, selectedCheckBox_4, selectedCheckBox_5.";
        List<CheckBox> checkBoxes = prepareCheckBoxList(true);

        String[] result = ListUtils.getDataFromCheckBoxMassive(title, checkBoxes);
        assertEquals(result[0], title);
        assertEquals(result[1], expectedString);
    }

    @Test
    public void testGetDataFromCheckBoxMassiveWithoutSelected() {
        String title = "NewTestTitleForCheckBox";
        List<CheckBox> checkBoxes = prepareCheckBoxList(false);

        String[] result = ListUtils.getDataFromCheckBoxMassive(title, checkBoxes);
        assertNull(result);
    }

    @Test
    public void testGetDataFromEmptyCheckBoxMassive() {
        String title = "NewTestTitleForCheckBox";
        List<CheckBox> checkBoxes = new ArrayList<>();

        String[] result = ListUtils.getDataFromCheckBoxMassive(title, checkBoxes);
        assertNull(result);
    }

    @Test
    public void testUpdateUser() {
        User defaultFirstUser = new User("userLogin_1", "default_user_password", false, "default_full_name", "default_position");
        ObservableList<User> allUsersList = prepareUsersList(defaultFirstUser);
        User modifiedFirstUser = new User("userLogin_1", "modified_user_password", true, "modified_full_name", "modified_position");

        ListUtils.updateUser(allUsersList, modifiedFirstUser);

        Optional<User> defaultUserInResultList = allUsersList.stream().filter(user -> user.equals(defaultFirstUser)).findAny();
        assertFalse(defaultUserInResultList.isPresent());

        Optional<User> modifiedFirstUserInResultList = allUsersList.stream().filter(user -> user.equals(modifiedFirstUser)).findFirst();
        assertTrue(modifiedFirstUserInResultList.isPresent());
        assertEquals(modifiedFirstUser, modifiedFirstUserInResultList.get());
    }

    @Test
    public void testUpdateUserIfNotExist() {
        User defaultFirstUser = new User("userLogin_1", "default_user_password", false, "default_full_name", "default_position");
        ObservableList<User> allUsersList = prepareUsersList(defaultFirstUser);
        User modifiedFirstUser = new User("userLogin_123", "modified_user_password", true, "modified_full_name", "modified_position");

        ListUtils.updateUser(allUsersList, modifiedFirstUser);

        Optional<User> defaultUserInResultList = allUsersList.stream().filter(user -> user.equals(defaultFirstUser)).findAny();
        assertTrue(defaultUserInResultList.isPresent());
        assertEquals(defaultFirstUser, defaultUserInResultList.get());

        Optional<User> modifiedFirstUserInResultList = allUsersList.stream().filter(user -> user.equals(modifiedFirstUser)).findFirst();
        assertFalse(modifiedFirstUserInResultList.isPresent());
    }

    private List<CheckBox> prepareCheckBoxList(boolean selectedExists) {
        List<CheckBox> result = new ArrayList<>();

        if(selectedExists) {
            for (int i = 1; i <= 5; i++) {
                CheckBox selectedCheckBox = new CheckBox("selectedCheckBox_" + i);
                selectedCheckBox.setSelected(true);
                result.add(selectedCheckBox);
            }
        }

        for (int i = 1; i <= 5; i++) {
            CheckBox unselectedCheckBox = new CheckBox("unselectedCheckBox_" + i);
            result.add(unselectedCheckBox);
        }
        return result;
    }

    private ObservableList<User> prepareUsersList(User firstUser) {
        ObservableList<User> result = FXCollections.observableArrayList();
        result.add(firstUser);
        for (int i = 2; i <= 5; i++) {
            result.add(new User("userLogin_" + i, "default_user_password", false, "default_full_name", "default_position"));
        }
        return result;
    }
}
