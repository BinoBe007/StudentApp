package com.mycompany.studentapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bino
 */
public class LoginController implements Initializable, EventHandler<ActionEvent> {
    static String loggedinUser;
    @FXML
    TextField tfUser;
    @FXML
    PasswordField pfPass;
    @FXML
    Label lblError;
    @FXML
    Button btnLogin, btnCancel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogin.setOnAction(this);
        btnCancel.setOnAction(this);
    }    

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource().equals(btnLogin)){
            try {
                if(tfUser.getText().equals("Admin") && pfPass.getText().equals("123")){
                    loggedinUser = tfUser.getText();
                    App.sceneFactory("/fxml/dashboard");
                }else{
                    lblError.setText("Invalid Username or Password");
                }
                   
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(event.getSource().equals(btnCancel)){
//           Optionally we can close a program usingthe following code 
//            Node source = (Node)event.getSource();
//            Stage stage = (Stage)source.getScene().getWindow();
//            stage.close();
            System.exit(0);
        }
    }
    
}
