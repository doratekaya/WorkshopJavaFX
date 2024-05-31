package Utils;
import java.sql.*;
public class DataSource {
    private  String url="jdbc:mysql://localhost:8889/pidevesprit";
    private  String login="root";
    private  String pwd="root";



    //Cree une variable globale pour stocker l'instance cree
    private static DataSource data;

   private Connection con;

   //1 rendre le constucteur privee
   private DataSource(){
       try {
           con=DriverManager.getConnection(url,login,pwd);
           System.out.println("connexion établie");
       } catch (SQLException e) {

           System.out.println(e);
       }
   }
    public Connection getCon() {
         return con;
    }


    //2 cree une methode intermediaire pour faire appel au constructeur
    public static DataSource getInstance() {
        //tester si une instance est cree?
       if(data==null)
           data=new DataSource();
        return data;
    }
}
