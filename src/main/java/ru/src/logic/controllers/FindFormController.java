package ru.src.logic.controllers;

import com.sun.javaws.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.src.logic.implementation.ListUtils;
import ru.src.logic.implementation.Organizations;
import ru.src.model.Member;

import java.util.ArrayList;

public class FindFormController {
    @FXML
    public ComboBox comboBox_params;
    @FXML
    public Button btn_search;
    @FXML
    public TextField text_searchText;
    @FXML
    public Button btn_last;
    @FXML
    public Button btn_next;
    @FXML
    public Label label_count;

    private ObservableList<String> paramsList = ListUtils.getFindParamsList();
    private ArrayList<Integer> findParams = new ArrayList<>();

    private TableView tableView;
    private int findIndex = 0;

    public void setParams(TableView tableView) {
        this.tableView = tableView;
    }

    @FXML
    public void initialize() {
        comboBox_params.setItems(paramsList);
        btn_last.setDisable(true);
        btn_next.setDisable(true);
        btn_search.setDisable(true);
        label_count.setText(null);

    }

    public void search(ActionEvent actionEvent) {

        findParams.clear();
        int searchIndex = 0;
        findIndex = 0;

        switch (comboBox_params.getSelectionModel().getSelectedIndex()) {
            case 0:
                for (Object member : tableView.getItems()) {
                    if (member instanceof Member) {
                        String memberId = ((Member) member).getMemberId();
                        if (memberId.contains(text_searchText.getText())) {
                            findParams.add(searchIndex);
                        }
                        ++searchIndex;
                    }
                }
                break;
            case 1:
                for (Object member: tableView.getItems()) {
                    if(member instanceof Member) {
                        String memberFullName = ((Member) member).getRelate().getFullName().toLowerCase();
                        if(memberFullName.contains(text_searchText.getText().toLowerCase())) {
                            findParams.add(searchIndex);
                        }
                        ++searchIndex;
                    }
                }
                break;
            case 2:
                for (Object member: tableView.getItems()) {
                    if(member instanceof Member) {
                        String memberShortName = ((Member) member).getMemberShortName().toLowerCase();
                        if(memberShortName.contains(text_searchText.getText().toLowerCase())) {
                            findParams.add(searchIndex);
                        }
                        ++searchIndex;
                    }
                }
                break;
            case 3:
                for (Object member: tableView.getItems()) {
                    if(member instanceof Member) {
                        String memberDirectorFullName = ((Member) member).getDirector().getFullName().toLowerCase();
                        if(memberDirectorFullName.contains(text_searchText.getText().toLowerCase())) {
                            findParams.add(searchIndex);
                        }
                        ++searchIndex;
                    }
                }
                break;
        }
        if(findParams.size() > 1) {
            btn_last.setDisable(false);
            btn_next.setDisable(false);
        } else {
            btn_last.setDisable(true);
            btn_next.setDisable(true);
        }

        label_count.setText(String.valueOf(findParams.size()));
        if(findParams.size() > 0) {
            int selectRow = findParams.get(0);
            tableView.getSelectionModel().select(selectRow);
            checkRowCount();
        }
        printFindParams();

    }

    private void printFindParams() {
        System.out.println("findparams: ");
        findParams.forEach(integer -> System.out.println(integer));
    }


    public void next(ActionEvent actionEvent) {
        tableView.getSelectionModel().clearSelection();
        ++findIndex;
        if(findIndex >= findParams.size()) findIndex = 0;
        int selectRow = findParams.get(findIndex);
        tableView.getSelectionModel().select(selectRow);
        checkRowCount();
    }

    public void last(ActionEvent actionEvent) {
        tableView.getSelectionModel().clearSelection();
        --findIndex;
        if(findIndex < 0) findIndex = findParams.size() - 1;
        int selectRow = findParams.get(findIndex);
        tableView.getSelectionModel().select(selectRow);
        checkRowCount();
    }

    private void checkRowCount() {
        label_count.setText(findParams.size() + " (" + Integer.toString(findIndex + 1) + " из " + String.valueOf(findParams.size()) + ")");
    }

    public void clear() {
        text_searchText.clear();
        comboBox_params.getSelectionModel().clearSelection();
        btn_last.setDisable(true);
        btn_next.setDisable(true);
        label_count.setText(null);
        findIndex = 0;
    }

    public void selectParams(ActionEvent actionEvent) {
        btn_search.setDisable(false);
    }
}
