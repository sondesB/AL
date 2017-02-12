package persistance.services;

import interfaceswcomp.OCService;
import persistance.interfaces.BaseDePlanAbstraite;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;

/**
 * Created by seb on 03/02/17.
 */
public class PersistanceService {

    private String username,password,url,driver;
    private String infConnexion;

    private Connection connection;

    /**
     * Instruction d'insertion sql.
     */
    private static final String SQL_SERIALIZE_OBJECT = "INSERT INTO serialized_java_objects(object_name, serialized_object) VALUES (?, ?)";
    private static final String SQL_DESERIALIZE_OBJECT = "SELECT serialized_object FROM serialized_java_objects WHERE serialized_id = ?";

    

    /**
     * Permet de récuperer la base de plan d'un service donnée.
     * @param ocService Le service.
     * @return La base de plan.
     */
    public BaseDePlanAbstraite getBaseDePlan(OCService ocService)  {
        PreparedStatement pstmt = null;
        BaseDePlanAbstraite basedeplan = null;
        try {
            pstmt = connection
                    .prepareStatement(SQL_DESERIALIZE_OBJECT);

        ResultSet rs = pstmt.executeQuery();
        rs.next();

        // Object object = rs.getObject(1);

        byte[] buf = rs.getBytes(1);
        ObjectInputStream objectIn = null;
        if (buf != null)
            objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));

        basedeplan = (BaseDePlanAbstraite) objectIn.readObject();

        rs.close();
        pstmt.close();
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        return basedeplan;
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
     * @param infConnexion
     */
    public void setConnexion(String infConnexion)  {
       /* this.username = username;
        this.password = password;
        this.url = url;
        this.driver = driver;*/
       this.infConnexion=infConnexion;
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
