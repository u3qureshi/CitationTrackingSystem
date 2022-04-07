package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class DriverOffenseController {
    @FXML
    private Button proceedButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField officerIDTextField;
    @FXML
    private TextField offenderNameTextField;
    @FXML
    private TextField driverLicenseTextField;
    @FXML
    private RadioButton yesRadioButton;
    @FXML
    private RadioButton noRadioButton;
    @FXML
    private TextField driverViolationTypeTextField;
    @FXML
    private TextField additionalTextField;
    @FXML
    private DatePicker dateField;
    private boolean warrant = false;
    @FXML
    private void initialize() {
        ToggleGroup group = new ToggleGroup();
        yesRadioButton.setToggleGroup(group);
        noRadioButton.setToggleGroup(group);
    }
    public void noRadio(ActionEvent event){
        warrant = false;
    }
    public void yesRadio(ActionEvent event){
        warrant = true;
    }

    public void proceedButtonClicked(ActionEvent event) throws IOException {
        String date = "";
        if(dateField.getValue() != null)
            date = dateField.getValue().toString();
        else {
            errorAlert("Please select a date.", additionalTextField);
        }
        String id = officerIDTextField.getText().toLowerCase();
        String name = offenderNameTextField.getText().toLowerCase();
        String dl = driverLicenseTextField.getText().toLowerCase();
        String violation = driverViolationTypeTextField.getText().toLowerCase();
        String additional = additionalTextField.getText().toLowerCase();

        if (verifyCitizen(name, dl)) {
            if(verifyOfficer(id)){
                    IssueCitation ic = new IssueCitation();
                    ic.addCitationToDriverOffenseMap(warrant,id,name,dl,violation,additional,date);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("*COMPLETED*");
                    alert.setHeaderText("Entry successful!");
                    alert.setContentText("Citation has been entered into the Driver Violation Database.");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        alert.close();
                        officerIDTextField.setText("");
                        offenderNameTextField.setText("");
                        driverLicenseTextField.setText("");
                        additionalTextField.setText("");
                        driverViolationTypeTextField.setText("");
                        yesRadioButton.setSelected(false);
                        noRadioButton.setSelected(false);
                        dateField.getEditor().clear();
                    }
            }
            else{
                errorAlert("The officer ID you entered is invalid.", officerIDTextField);
            }
        }
        else{
            errorAlert("The offender name or driver's license you entered is invalid.", offenderNameTextField);
        }
    }

    public void cancelButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("dashboard-view.fxml");
    }
    public boolean verifyCitizen(String name, String driversLicense) throws FileNotFoundException {
        return new Citizen().isValid(name, driversLicense);
    }

    public boolean verifyOfficer(String id) throws FileNotFoundException {
        return new Officer().isValid(id);
    }
    public boolean isCarValid(String plate) throws FileNotFoundException {
        plate.toLowerCase();
        Citizen c = new Citizen();
        HashMap<String, Citizen> map = c.getCitizenMap();
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry mapElement = (Map.Entry) iterator.next();
            Citizen object = (Citizen) mapElement.getValue();
            if(object.getLicensePlate().toLowerCase().equals(plate))
                return true;
        }
        return false;
    }
    public void errorAlert(String message, TextField tf) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("*ERROR*");
        alert.setHeaderText("INVALID ENTRY");
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            alert.close();
            tf.setText("");
            tf.requestFocus();
        }
        else if(result.get() == ButtonType.CLOSE)
            System.out.println("ERROR CLOSED");
    }
}
