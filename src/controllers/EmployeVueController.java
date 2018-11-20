/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Employe;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import services.EmployeService;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class EmployeVueController implements Initializable {

    EmployeService ms = new EmployeService();
    ObservableList<Employe> employeList = FXCollections.observableArrayList();
    private static int index;
    Date dt = new Date();

    @FXML
    private TextField marque;
    @FXML
    private TableView<Employe> etudiants;


    @FXML
    private void saveAction(ActionEvent event) {
    

        ms.create(new Employe());
        load();
        clean();
    }

    @FXML
    private void delete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation de suppression");
        alert.setContentText("Vous vous vraiment supprimer cette machine?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            ms.delete(ms.findById(index));
            employeList.clear();
            load();
        } else {
           
        }

    }

    @FXML
    private void update() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation de modification");
        alert.setContentText("Vous vous vraiment modifier cette machine?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Employe m2 = ms.findById(index);
          //  m2.setNom(nom);
            ms.update(m2);
            employeList.clear();
            load();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        etudiants.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TablePosition pos = (TablePosition) etudiants.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                Employe item = etudiants.getItems().get(row);
                
                index = item.getId();
              
//                System.out.println(localDate.MIN);
                load();
            }
        });
    }

    public void clean() {
       // marque.setText("");
    }

    public void load() {
        employeList.clear();
       // cMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        for (Employe m : ms.findAll()) {
            //employeList.add(new Employe(m.getId()));
        }

        etudiants.setItems(employeList);
    }
    
}
