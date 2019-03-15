package ru.src.logic.implementation;

import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import ru.src.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.src.logic.implementation.ListConstants.*;

public class ListUtils {

    public static ObservableList<String> getMemberStatusList() {
        return MEMBER_STATUS_LIST;
    }

    public static ObservableList<String> getOrganizationForm() {
        return ORGANIZATION_FORM_LIST;
    }

    public static ObservableList<String> getEconomicSector() {
        return ECONOMIC_SECTOR_LIST;
    }

    public static ObservableList<String> getOwnershipForm() {
        return OWNERSHIP_FORM_LIST;
    }

    public static ObservableList<String> getActivityType() {
        return ACTIVITY_TYPE_LIST;
    }

    public static ObservableList<String> getBusinessForm() {
        return BUSINESS_FORM_LIST;
    }

    public static ObservableList<String> getInteresting() {
        return INTERESTING_LIST;
    }

    public static ObservableList<String> getYesNo() {
        return VED_LIST;
    }

    public static ObservableList<String> getDedbStatusList() {
        return DEDB_STATUS_LIST;
    }

    public static ObservableList<String> getDistrict() {
        return DISTRICT_LIST;
    }

    public static HashMap<Integer, String> getRegionMap() {
        return REGION_MAP;
    }

    public static HashMap<Integer, String> getMonth() {
        return MONTHS_LIST;
    }

    public static ObservableList<String> getFindParamsList() {
        return FIND_PARAMS_LIST;
    }

    public static ObservableList<String> getPayment() {
        return PAYMENT_LIST;
    }

    public static ObservableList<String> getReceive() {
        return RECEIVE_LIST;
    }


    public static String[] getDataFromCheckBoxMassive(String title, List<CheckBox> checkBoxes) {
        String[] result = new String[2];
        List<String> selectedCheckBox = checkBoxes.stream()
                .filter(checkBox -> checkBox.isSelected())
                .map(checkBox -> checkBox.getText())
                .collect(Collectors.toList());

        if (selectedCheckBox.size() == 0) {
            return null;
        }

        result[0] = title;
        result[1] = String.join(", ", selectedCheckBox) + ".";
        return result;
    }

    public static void updateUser(ObservableList<User> usersList, User modifiedUser) {
        Optional<User> userToModify = usersList.stream().filter(defaultUser -> defaultUser.getLogin().equals(modifiedUser.getLogin())).findFirst();
        if (userToModify.isPresent()) {
            int index = usersList.indexOf(userToModify.get());
            usersList.set(index, modifiedUser);
        }
    }
}