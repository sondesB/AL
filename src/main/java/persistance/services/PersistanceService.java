package persistance.services;

import interfaceswcomp.OCService;
import persistance.interfaces.BaseDePlanAbstraite;

import java.sql.*;

/**
 * Created by seb on 03/02/17.
 */
public class PersistanceService {

    private String username,password,url,driver;

    private Connection connection;

    /**
     * Instruction d'insertion.
     */
    private static final String SQL_SERIALIZE_OBJECT = "INSERT INTO serialized_java_objects(object_name, serialized_object) VALUES (?, ?)";
    private static final String SQL_DESERIALIZE_OBJECT = "SELECT serialized_object FROM serialized_java_objects WHERE serialized_id = ?";

    

    /**
     * Permet de récuperer la base de plan d'un service donnée.
     * @param ocService Le service.
     * @return La base de plan.
     */
    public BaseDePlanAbstraite getBaseDePlan(OCService ocService) {
        return null;
    }

    /**
     * Permet de sauvegarder une base de plan dans une base de données.
     * @param baseDePlan La base de plan.
     */
    public void persisterBaseDePlan(BaseDePlanAbstraite baseDePlan) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            long serialized_id = serializeJavaObjectToDB(connection, baseDePlan);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Connexion à la base de donnée.
     * @param username
     * @param password
     * @param url
     * @param driver
     */
    public void setConnexion(String username,String password, String url, String driver)  {
        this.username = username;
        this.password = password;
        this.url = url;
        this.driver = driver;
    }

    /**
     *
     * @param connection
     * @param objectToSerialize
     * @return
     * @throws SQLException
     */
    private long serializeJavaObjectToDB(Connection connection,
                                               Object objectToSerialize) throws SQLException {

        PreparedStatement pstmt = connection
                .prepareStatement(SQL_SERIALIZE_OBJECT);

        // just setting the class name
        pstmt.setString(1, objectToSerialize.getClass().getName());
        pstmt.setObject(2, objectToSerialize);
        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        int serialized_id = -1;
        if (rs.next()) {
            serialized_id = rs.getInt(1);
        }
        rs.close();
        pstmt.close();
        System.out.println("Java object serialized to database. Object: "
                + objectToSerialize);
        return serialized_id;
    }
}
