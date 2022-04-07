package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SearchController {
    @FXML
    private Button backButton;
    @FXML
    private Button vehicleStatusButton;
    @FXML
    private Button driverStatusButton;
    @FXML
    private Button driverRecordButton;

    public void vehicleStatusButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("vehicle-status-view.fxml");
    }

    public void driverRecordButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("driver-record-view.fxml");
    }

    public void driverStatusButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("driver-status-view.fxml");
    }

    public void backButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("dashboard-view.fxml");
    }
}
