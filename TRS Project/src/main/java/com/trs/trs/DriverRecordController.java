package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class DriverRecordController {
    @FXML
    private Button backButton;
    @FXML
    private Button reportButton;
    @FXML
    private Button completedButton;
    @FXML
    private TextField searchTextField;
    @FXML
    private TextArea textArea;

    String driversLicense;

    public void reportButtonClicked(ActionEvent event) throws IOException {
        driversLicense = searchTextField.getText().toLowerCase().trim().toString();
        if (IssueCitation.vehicleOffenseMap.containsKey(driversLicense) || IssueCitation.driverOffenseMap.containsKey(driversLicense)) {
            List<VehicleStatus> vehicleList = IssueCitation.vehicleOffenseMap.get(driversLicense);
            List<DriverStatus> driverList = IssueCitation.driverOffenseMap.get(driversLicense);

            String report = "";
            if(IssueCitation.vehicleOffenseMap.containsKey(driversLicense)) {
                //First we iterate through the vehicleList of VehicleStatus objects to get the info of all citations
                for (VehicleStatus l : vehicleList) {
                    report += "> VEHICLE VIOLATION: " + l.getVehicleViolation().toUpperCase() + ",\n      On " + l.getDate() + ",\n        " + l.getOwnerFullName() + ",\n          DL#: " + l.getDriversLicense() + ",\n            Issued by: " + l.getAgentId() + "\n              Additional comments: " + l.getAdditionalComments()+"\n";
                }
            }
            if(IssueCitation.driverOffenseMap.containsKey(driversLicense)) {
                //Second we iterate through the driverList of DriverStatus objects to the info of all the citations given
                for (DriverStatus d : driverList) {
                    report += "> DRIVER VIOLATION: " + d.getViolationType().toUpperCase() + ",\n      On " + d.getDate() + ",\n        " + d.getOwnerFullName() + ",\n          DL#: " + d.getDriversLicense() + ",\n            Issued by: " + d.getAgentId() + "\n              Additional comments: " +d.getAdditionalComments()+"\n";
                }
            }

            textArea.setText(report);
        }
        else if(new Citizen().isValid(driversLicense)){
            textArea.setText("There are no citations for this record.");
        }
        else {
            textArea.setText("Driver's License is invalid.");
        }
    }

    //If this button is clicked, ALL the records (THE ENTIRE LIST, DRIVER AND VEHICLE VIOLATIONS) for that person will be deleted completely
    public void completedButtonClicked(ActionEvent event) throws IOException {
        driversLicense = searchTextField.getText().toLowerCase().trim().toString();

        if (IssueCitation.vehicleOffenseMap.containsKey(driversLicense) || IssueCitation.driverOffenseMap.containsKey(driversLicense)) {

            //get name of the corresponding drivers license
            Citizen c = Citizen.citizenMap.get(driversLicense);
            String name = c.getFullName();

            //alert message as extra security, but only if the vehicleOffenseMap has records for this particular driver
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Expunge Record");
            alert.setHeaderText("Are you sure you would like to expunge records of " + name + "?");
            alert.setContentText("This will remove ANY and ALL records of " + name+ ". This action cannot be undone.");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isEmpty())
                System.out.println("Alert closed");
            else if(result.get() == ButtonType.OK){
                if(IssueCitation.vehicleOffenseMap.containsKey(driversLicense))
                    IssueCitation.vehicleOffenseMap.remove(driversLicense);
                if(IssueCitation.driverOffenseMap.containsKey(driversLicense))
                    IssueCitation.driverOffenseMap.remove(driversLicense);
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
