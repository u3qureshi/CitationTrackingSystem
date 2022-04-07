package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class IssueCitationController {
    @FXML
    private Button proceedButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button uploadButton;
    @FXML
    private TextField officerNameTextField;
    @FXML
    private TextField offenderNameTextField;
    @FXML
    private TextField offenderContactTextField;
    @FXML
    private TextField driverLicenseTextField;
    @FXML
    private TextField subjectTextField;
    @FXML
    private TextField vehicleNumberTextField;
    @FXML
    private TextField arrestWarrantTextField;
    @FXML
    private TextField citationTextField;
    @FXML
    private TextField additionalTextField;
    @FXML
    private ImageView image;

    public void proceedButtonClicked(ActionEvent event) throws IOException {
        //proceed logic
    }

    public void cancelButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("dashboard-view.fxml");
    }
}
