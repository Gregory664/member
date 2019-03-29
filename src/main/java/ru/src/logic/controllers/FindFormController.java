package ru.src.logic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import ru.src.logic.factory.OrganizationFactory;
import ru.src.logic.implementation.ListUtils;
import ru.src.logic.implementation.SearchParameter;

public class FindFormController {
    @FXML
    public ComboBox<String> comboBox_params;
    @FXML
    public Button btn_search;
    @FXML
    public TextField text_searchText;
    @FXML
    public Label label_count;
    @FXML
    public Button btn_clear;

    @FXML
    public void initialize() {
        comboBox_params.setItems(ListUtils.getFindParamsList());
        btn_search.setDisable(true);
        label_count.setText(null);
    }

    @FXML
    public void search() {
        if(!text_searchText.getText().isEmpty()) {
            switch (comboBox_params.getSelectionModel().getSelectedItem()) {
                case "Номер билета":
                    OrganizationFactory.getOrganization().refreshBySearchParam(SearchParameter.ID, text_searchText.getText());
                    break;
                case "Полное название":
                    OrganizationFactory.getOrganization().refreshBySearchParam(SearchParameter.FULL_NAME, text_searchText.getText());
                    break;
                case "Сокращенное название":
                    OrganizationFactory.getOrganization().refreshBySearchParam(SearchParameter.SHORT_NAME, text_searchText.getText());
                    break;
                case "ФИО руководителя":
                    OrganizationFactory.getOrganization().refreshBySearchParam(SearchParameter.DIRECTOR_FULL_NAME, text_searchText.getText());
                    break;
                case "Деятельность/Услуги":
                    OrganizationFactory.getOrganization().refreshBySearchParam(SearchParameter.SERVICES, text_searchText.getText());
                    break;
            }
        } else {
            OrganizationFactory.getOrganization().getMembers().clear();
            label_count.setText("0");
        }
        label_count.setText(String.valueOf(OrganizationFactory.getOrganization().getFullSize()));
    }

    @FXML
    public void selectParams() {
        btn_search.setDisable(false);
    }

    public void clearOrganization() {
        label_count.setText("0");
        text_searchText.clear();
        OrganizationFactory.getOrganization().refresh();
    }
}
