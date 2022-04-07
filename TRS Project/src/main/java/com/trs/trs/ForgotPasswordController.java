package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class ForgotPasswordController {
    @FXML
    private Button passwordSaveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField masterUserTextField;
    @FXML
    private PasswordField companyCodeTextField;

    public void cancelButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login-view.fxml");
    }

    public void submitButtonClicked(ActionEvent event) throws IOException {
       String username = masterUserTextField.getText().toString();
       String companyCode = companyCodeTextField.getText().toString();
       MasterClass master = new MasterClass();

        if(username.equals(master.getMasterUsername()) && companyCode.equals(master.getMasterCompanyCode())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("*CONFIDENTIAL INFORMATION*");
            alert.setHeaderText("MASTER PASSWORD");
            alert.setContentText("The Master Password is: " + master.getMasterPassword());
            alert.show();
        }
        else{
            HashMap<String, Officer> map = Officer.officerMap;
            Iterator iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry) iterator.next();
                Officer officer = (Officer) mapElement.getValue();
                if (officer.getUsername().equals(username) && companyCode.equals(master.getMasterCompanyCode())) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("*CONFIDENTIAL INFORMATION*");
                    alert.setHeaderText("Forgot Password");
                    alert.setContentText("Your Personal Password is: " + officer.getPassword());
                    alert.show();
                    return;
                }

            }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("*ERROR*");
            alert.setHeaderText("INVALID ENTRY");
            alert.setContentText("The Master Username or Company Code is incorrect.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                alert.close();
                masterUserTextField.setText("");
                companyCodeTextField.setText("");
                masterUserTextField.requestFocus();
            }
            else if(result.get() == ButtonType.CLOSE)
                System.out.println("ERROR CLOSED");
        }
    }
}
