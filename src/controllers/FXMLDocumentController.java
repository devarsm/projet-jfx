/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Employe;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.EmployeService;

/**
 *
 * @author Dell
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label labelmsg;
    @FXML
    private Button submit;
    @FXML
    private TextField email;
    @FXML
    private TextField password;

    Employe emp = new Employe();
    EmployeService es = new EmployeService();

    @FXML
    private void verifier(ActionEvent event) throws IOException {
        String user = email.getText().toString();
        String pass = password.getText().toString();
        boolean a = false;
        for (Employe object : es.findAll()) {

            if (object.getEmail().equals(user) && object.getPassword().equals(pass)) {

                a = true;
              //  labelmsg.setText("vueillez remplir tous les champs ");
                Parent homepageparent = FXMLLoader.load(getClass().getResource("../vue/ProfiVue.fxml"));
                Scene homepage = new Scene(homepageparent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.hide();
                app_stage.setScene(homepage);
                app_stage.show();
            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODo
    }

}
