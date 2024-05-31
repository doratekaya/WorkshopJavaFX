import java.sql.*;

public class Test {

    private static String url="jdbc:mysql://localhost:3306/pidevesprit";
    private static String login="root";
    private static String pwd="";
    private static Connection con;
    private static Statement ste;
    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion établie");
        }catch (SQLException e)
        {
            System.out.println(e);
        }
        String req="INSERT INTO `personne` ( `nom`, `prenom`, `age`) VALUES ( 'ben fadhel', 'sana', '12');";
        try {
            ste= con.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
        try {
           int res= ste.executeUpdate(req);
            System.out.println("personne ajoutée ");
        }catch (SQLException e)
        {
            System.out.println(e);
        }

        String req1="select * from personne";

        try {
            ResultSet res = ste.executeQuery(req1);
            while (res.next()){

                int id=res.getInt(1);
                String nom=res.getString("nom");
                String prenom=res.getString("prenom");
                int age=res.getInt(4);
                System.out.println("id ="+id);
                System.out.println("nom ="+nom);
                System.out.println("prenom ="+prenom);
                System.out.println("age ="+age);
            }
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
