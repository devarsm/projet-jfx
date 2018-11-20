/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import services.EtablissementService;
import beans.Etablissement;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class EtablissementVueController implements Initializable {

    EtablissementService ms = new EtablissementService();
    ObservableList<Etablissement> etablissementList = FXCollections.observableArrayList();
    private static int index;
    Date dt = new Date();

    @FXML
    private TextField marque;
    @FXML
    private TableView<Etablissement> etablissements;


    @FXML
    private void saveAction(ActionEvent event) {
    

        ms.create(new Etablissement());
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
            etablissementList.clear();
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
            Etablissement m2 = ms.findById(index);
          //  m2.setNom(nom);
            ms.update(m2);
            etablissementList.clear();
            load();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        etablissements.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TablePosition pos = (TablePosition) etablissements.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                Etablissement item = etablissements.getItems().get(row);
                
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
        etablissementList.clear();
       // cMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        for (Etablissement m : ms.findAll()) {
            //etablissementList.add(new Etablissement(m.getId()));
        }

        etablissements.setItems(etablissementList);
    }
    
}
