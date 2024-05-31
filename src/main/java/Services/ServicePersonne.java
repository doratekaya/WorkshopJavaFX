package Services;

import Entites.Personne;
import Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicePersonne implements IService<Personne>{
   private Connection con1= DataSource.getInstance().getCon();
   private Statement ste;


   public ServicePersonne(){

       try {
           ste=con1.createStatement();
       } catch (SQLException e) {
           System.out.println(e);
       }
   }
   @Override

    public void ajouter(Personne personne) throws SQLException {
       String req="INSERT INTO `personne` ( `nom`, `prenom`, `age`) VALUES ( '"+personne.getNom()+"', '"+personne.getPrenom()+"', '"+personne.getAge()+"');";
        ste.executeUpdate(req);
   }


   public void ajout(Personne p) throws SQLException
   {
       PreparedStatement pre= con1.prepareStatement("INSERT INTO `personne` ( `nom`, `prenom`, `age`) VALUES ( ?,?,?);");
       pre.setString(1,p.getNom());
       pre.setString(2,p.getPrenom());
       pre.setInt(3,p.getAge());
       pre.executeUpdate();
   }
    @Override
    public void supprimer(Personne personne) throws SQLException {

    }

    @Override
    public void update(Personne personne) throws SQLException {

    }

    @Override
    public Personne findbyId(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Personne> readAll() throws SQLException {
      List<Personne> l1=new ArrayList<>();
       String req="select * from personne";

        ResultSet res=ste.executeQuery(req);
        while (res.next())
        {
            int id=res.getInt(1);
            String nom=res.getString("nom");
            String prenom=res.getString("prenom");
            int age=res.getInt(4);
            Personne p=new Personne(id,nom,prenom,age);
            l1.add(p);
        }
        return l1;
    }
}
