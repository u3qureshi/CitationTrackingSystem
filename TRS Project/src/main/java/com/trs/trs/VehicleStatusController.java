package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class VehicleStatusController {
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
        if (IssueCitation.vehicleOffenseMap.containsKey(driversLicense)) {
            List<VehicleStatus> list = IssueCitation.vehicleOffenseMap.get(driversLicense);
            //Get the most recent VehicleStatus Object (last in the list)
            VehicleStatus v = list.get(list.size() - 1);
            String vehicleInfo = (
                    "Date of Citation: -------------- " + v.getDate().toUpperCase() +
                    "\nFull Name: -------------------- " + v.getOwnerFullName().toUpperCase() +
                    "\nDriver's License: -------------- " + v.getDriversLicense().toUpperCase() +
                    "\nIssuing Officer: --------------- " + v.getAgentId().toUpperCase() +
                    "\nLicense Plate Number: ------- " + v.getCarLicensePlate().toUpperCase() +
                    "\nVehicle Violation: ------------- " + v.getVehicleViolation().toUpperCase() +
                    "\nAdditional Comments: -------- " + v.getAdditionalComments().toUpperCase());
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

        if (IssueCitation.vehicleOffenseMap.containsKey(driversLicense)) {

            //get name of the corresponding drivers license
            Citizen c = Citizen.citizenMap.get(driversLicense);
            String name = c.getFullName();

            //alert message as extra security, but only if the vehicleOffenseMap has records for this particular driver
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Expunge Vehicle Record");
            alert.setHeaderText("Are you sure you would like to expunge all vehicle records of " + name + "?");
            alert.setContentText("This action cannot be undone.");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isEmpty())
                System.out.println("Alert closed");
            else if(result.get() == ButtonType.OK){
                IssueCitation.vehicleOffenseMap.remove(driversLicense);
                textArea.setText("The records for " + name + " have been erased and expunged.");
            }
            else if(result.get() == ButtonType.CANCEL)
                System.out.println("Alert cancelled");

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
