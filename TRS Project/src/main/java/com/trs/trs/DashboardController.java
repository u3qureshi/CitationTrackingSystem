package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DashboardController {
    @FXML
    private Button signoutButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button vehicleOffenseButton;
    @FXML
    private Button driverOffenseButton;
    @FXML
    private Button agentButton;
    @FXML
    private Button guideButton;
    @FXML
    private Button faqButton;
    @FXML
    private Button tutorialButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label createdLabel;
    @FXML
    private Label pendingLabel;
    @FXML
    private Label closedLabel;

    public void searchButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("search-view.fxml");
    }

    public void vehicleOffenseButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("vehicle-offense-view.fxml");
    }

    public void driverOffenseButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("driver-offense-view.fxml");
    }


    public void signoutButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("main-view.fxml");
    }

    public void agentButtonClicked(ActionEvent event) throws IOException {

    }

    public void guideButtonClicked(ActionEvent event) throws IOException {

    }

    public void faqButtonClicked(ActionEvent event) throws IOException {

    }

    public void tutiorialButtonClicked(ActionEvent event) throws IOException {

    }
}
