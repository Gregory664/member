package ru.src.logic.dto;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.util.List;

public class CheckBoxGroup {

    private Label label;
    private List<CheckBox> checkBoxes;
    private List<DatePicker> datePickers;
    private boolean isEmpty;
    private int whereFlag;
    private String wherePattern;

    public CheckBoxGroup(Label label, List<CheckBox> checkBoxes, String wherePattern, int whereFlag) {
        this.label = label;
        this.checkBoxes = checkBoxes;
        this.wherePattern = wherePattern;
        this.whereFlag = whereFlag;
    }

    public CheckBoxGroup(Label label, List<CheckBox> checkBoxes, List<DatePicker> datePickers, String wherePattern, int whereFlag) {
        this.label = label;
        this.checkBoxes = checkBoxes;
        this.datePickers = datePickers;
        this.wherePattern = wherePattern;
        this.whereFlag = whereFlag;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public List<CheckBox> getCheckBoxes() {
        return checkBoxes;
    }

    public void setCheckBoxes(List<CheckBox> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public void addCheckBox(CheckBox checkBox) {
        checkBoxes.add(checkBox);
    }

    public String getWherePattern() {
        return wherePattern;
    }

    public void setWherePattern(String wherePattern) {
        this.wherePattern = wherePattern;
    }

    public int getWhereFlag() {
        return whereFlag;
    }

    public void setWhereFlag(int whereFlag) {
        this.whereFlag = whereFlag;
    }

    public void changeState() {
        isEmpty = !isEmpty;
        checkBoxes.forEach(checkBox -> checkBox.setSelected(isEmpty));
    }

    public void changeState(boolean value) {
        isEmpty = value;
        checkBoxes.forEach(checkBox -> checkBox.setSelected(isEmpty));
    }

    public List<DatePicker> getDatePickers() {
        return datePickers;
    }

    public void setDatePickers(List<DatePicker> datePickers) {
        this.datePickers = datePickers;
    }
}
