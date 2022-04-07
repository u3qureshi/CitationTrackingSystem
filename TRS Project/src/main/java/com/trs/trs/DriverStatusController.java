package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class DriverStatusController {
    @FXML
    private Button backButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button completedButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private TextArea textArea;

    String driversLicense;

    public void searchButtonClicked(ActionEvent event) throws IOException {
        driversLicense = searchTextField.getText().toLowerCase().trim().toString();
        if (IssueCitation.driverOffenseMap.containsKey(driversLicense)) {
            List<DriverStatus> list = IssueCitation.driverOffenseMap.get(driversLicense);
            //Get the most recent VehicleStatus Object (last in the list)
            DriverStatus d = list.get(list.size() - 1);
            String vehicleInfo = (
                    "Date of Citation: ------------- " + d.getDate().toUpperCase() +
                            "\nArrest Warrant: -------------- " + String.valueOf(d.isArrestWarrant()).toUpperCase() +
                            "\nFull Name: ------------------- " + d.getOwnerFullName().toUpperCase() +
                            "\nDriver's License: ------------- " + d.getDriversLicense().toUpperCase() +
                            "\nIssuing Officer: -------------- " + d.getAgentId().toUpperCase() +
                            "\nDriver Violation: ------------- " + d.getViolationType().toUpperCase() +
                            "\nAdditional Comments: ------ " + d.getAdditionalComments().toUpperCase());
            textArea.setText(vehicleInfo);
        }
        else if(new Citizen().isValid(driversLicense)){
            textArea.setText("There are no citations for this record.");
        }
        else {
            textArea.setText("Driver's License is invalid.");
        }
    }

    public void completedButtonClicked(ActionEvent event) throws IOException {
        driversLicense = searchTextField.getText().toLowerCase().trim().toString();

        if (IssueCitation.driverOffenseMap.containsKey(driversLicense)) {
            //get the driver list and change the arrest warrant to false
            List<DriverStatus> list = IssueCitation.driverOffenseMap.get(driversLicense);
            DriverStatus d = list.get(list.size()-1);

            if(d.isArrestWarrant() == true) {

                //get name of the corresponding drivers license
                Citizen c = Citizen.citizenMap.get(driversLicense);
                String name = c.getFullName();

                //alert message as extra security, but only if the vehicleOffenseMap has records for this particular driver
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Remove Warrant");
                alert.setHeaderText("Are you sure you would like to remove the arrest warrant on " + name + "?");
                alert.setContentText("This action cannot be undone.");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.isEmpty())
                    System.out.println("Alert closed");
                else if (result.get() == ButtonType.OK) {
                    d.setArrestWarrant(false);
                    textArea.setText("The arrest warrant on " + name + " has been removed.");
                } else if (result.get() == ButtonType.CANCEL)
                    System.out.println("Alert cancelled");
            }
            else
                textArea.setText("This person does not have an arrest warrant on them.");
        }
        else if (new Citizen().isValid(driversLicense)) {
            textArea.setText("There are no citations for this record.");
        } else {
            textArea.setText("Driver's License is invalid.");
        }
    }

    public void backButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("search-view.fxml");
    }
}
