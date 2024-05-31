package controllers;

import Entites.Personne;
import Services.ServicePersonne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class AjouterPersonneController {
    @FXML
    private TextField tfage;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfprenom;

    ServicePersonne sp = new ServicePersonne();

    @FXML
    void ajoutertoDB(ActionEvent event) {
        //
        try {
            sp.ajouter(new Personne(tfnom.getText(),tfprenom.getText(),Integer.parseInt(tfage.getText())));
            //1
            FXMLLoader l = new FXMLLoader(getClass().getResource("/AfficherPeronne.fxml"));
            try {
                Parent root = l.load();
                AfficherPeronne controllerAfficher = l.getController();
                controllerAfficher.setLnom(tfnom.getText());
                controllerAfficher.setLprenom(tfprenom.getText());
                controllerAfficher.setLage(tfage.getText());
                tfnom.getScene().setRoot(root);
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    @FXML
    void navigation(ActionEvent event) {
       //1
        FXMLLoader l = new FXMLLoader(getClass().getResource("/AfficherPeronne.fxml"));
        try {
            Parent root = l.load();
            AfficherPeronne controllerAfficher = l.getController();
            controllerAfficher.setLnom(tfnom.getText());
            controllerAfficher.setLprenom(tfprenom.getText());
            controllerAfficher.setLage(tfage.getText());
           tfnom.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
