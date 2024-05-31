package controllers;

import Entites.Personne;
import Services.ServicePersonne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;
import java.util.List;

public class AfficherPeronne {



    @FXML
    private Label afficher;

    @FXML
    private Label lage;
    @FXML
    private Label Lnom;
    @FXML
    private Label lprenom;

    public void setLage(String lage) {
        this.lage.setText(lage);
    }

    public void setLnom(String lnom) {
        Lnom.setText(lnom) ;
    }

    public void setLprenom(String lprenom) {
        this.lprenom.setText(lprenom);
    }

    ServicePersonne sp = new ServicePersonne();
    @FXML
    void afficherfromDB(ActionEvent event) {
        try {
            List<Personne> list =  sp.readAll();
            afficher.setText(list.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
