package Test;
import Entites.Personne;
import Services.ServicePersonne;
import Utils.DataSource;
import java.sql.*;
public class Main {
    public static void main(String[] args) {

        ServicePersonne ser=new ServicePersonne();

        Personne p1=new Personne("zoglem","feriel",20);
        try {
            ser.ajouter(p1);
            System.out.println("personne ajouteé");
        }catch (SQLException e){
            System.out.println(e);
        }


        try {
            ser.readAll().forEach(e-> System.out.println(e));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
