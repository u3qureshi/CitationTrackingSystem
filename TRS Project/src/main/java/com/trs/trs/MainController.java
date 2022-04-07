package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {
    @FXML
    private Button mainLoginButton;
    @FXML
    private Button mainRegisterButton;

    public void loginButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login-view.fxml");
    }

    public void registerButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("register-view.fxml");
    }
}