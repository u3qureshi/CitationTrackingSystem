package com.trs.trs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.*;

public class LoginController {
    @FXML
    private Button loginButton;
    @FXML
    private Button loginCancelButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button forgotUsernameButton;

    public void loginButtonClicked(ActionEvent event) throws IOException {
        String username = usernameTextField.getText().toString();
        String password = passwordTextField.getText().toString();

        MasterClass master = new MasterClass();

        if (master.getMasterUsername().equals(username) && master.getMasterPassword().equals(password)) {
            Main m = new Main();
            m.changeScene("dashboard-view.fxml");
        } else {
            HashMap<String, Officer> map = Officer.officerMap;
            Iterator iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry) iterator.next();
                Officer officer = (Officer) mapElement.getValue();
                if (officer.getUsername().equals(username) && officer.getPassword().equals(password)) {
                    Main m = new Main();
                    m.changeScene("dashboard-view.fxml");
                    return;
                }

            }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Invalid Username or Password");
            alert.setContentText("Please enter a valid username and password combination.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                alert.close();
                usernameTextField.setText("");
                passwordTextField.setText("");
                usernameTextField.requestFocus();
            }
            else if(result.get() == ButtonType.CLOSE)
                System.out.println("ERROR CLOSED");
        }
    }

    public void cancelButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("main-view.fxml");
    }

    public void forgotUsernameButtonClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("forgot-username-view.fxml");
    }

    public void forgotPasswordClicked(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("forgot-password-view.fxml");
    }

}
