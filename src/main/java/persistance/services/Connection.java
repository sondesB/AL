import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Connexion {
    private String Bdd;
    private Connection connection = null;
    private Statement statement = null;
 
    /**
     * Constructeur 
     * @param nom du chemin de la base de données.
     */
    public Connexion(String database) {
        this.Bdd = database;
    }
    /**
     * Active la cconnection avec les paramétres définis 
     * 
     */
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + Bdd);
            statement = connection.createStatement();
            System.out.println("Connexion a " + Bdd + " avec succès");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connecxion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connecxion");
        }
    }
    /**
     * Ferme la cconnection en cours
     * 
     */
    public void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
