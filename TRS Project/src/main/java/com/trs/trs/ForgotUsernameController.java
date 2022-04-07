package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ForgotUsernameController {
    @FXML
    private Button usernameSaveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField newUsernameTextField;
    @FXML
    private TextField confirmUsernameTextField;

    public void cancelButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login-view.fxml");
    }

    public void saveButtonClicked(ActionEvent event) throws IOException {
        //logic
    }
}
