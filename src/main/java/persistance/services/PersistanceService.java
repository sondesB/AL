package persistance.services;

import interfaceswcomp.OCService;
import persistance.interfaces.BaseDePlanAbstraite;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.*;

/**
 * Created by seb on 03/02/17.
 */
public class PersistanceService {

    private String Bdd;
    private PreparedStatement  prstatement = null;
    private Connection connection;

    /**
     * Instruction d'insertion sql.
     */
    private static final String SQL_SERIALIZE_OBJECT = "INSERT INTO serialized_java_objects(object_name, serialized_object) VALUES (?, ?)";
    private static final String SQL_DESERIALIZE_OBJECT = "SELECT serialized_object FROM serialized_java_objects WHERE serialized_id = ?";

    

    /**
     * Permet de récuperer la base de plan d'un service donnée
     * @return La base de plan.
     */
    public BaseDePlanAbstraite getBaseDePlan(int id)  {
        connect();
        BaseDePlanAbstraite basedeplan = null;
        try {
            prstatement = connection
                    .prepareStatement(SQL_DESERIALIZE_OBJECT);
        prstatement.setInt(1,id);
        ResultSet rs = prstatement.executeQuery();
        rs.next();

        // Object object = rs.getObject(1);

      /*  byte[] buf = rs.getBytes(1);*/
        ObjectInputStream objectIn = null;
       // Blob buf = rs.getBytes(1);
        if ( rs.getBytes(1) != null) {
            objectIn = new ObjectInputStream(new ByteArrayInputStream( rs.getBytes(1)));
        }
            //objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));

        basedeplan = (BaseDePlanAbstraite) objectIn.readObject();

        rs.close();

        close();
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
            //Class.forName("org.sqlite.Driver");
           // connection = DriverManager.getConnection(url, username, password);
            long serialized_id = serializeJavaObjectToDB(baseDePlan);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Connexion à la base de donnée.
     * @param bdd
     */
    public void setConnexion(String bdd)  {
       /* this.username = username;
        this.password = password;
        this.url = url;
        this.driver = driver;
       this.infConnexion=infConnexion;*/
       this.Bdd = bdd;
    }

    /**
     * @param objectToSerialize
     * @return
     * @throws SQLException
     */
    private long serializeJavaObjectToDB(Object objectToSerialize) throws SQLException {
        connect();
        prstatement = connection
                .prepareStatement(SQL_SERIALIZE_OBJECT);


        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        byte[] yourBytes;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(objectToSerialize);
            out.flush();
            yourBytes= bos.toByteArray();
            Blob blob = new SerialBlob(yourBytes);
        // just setting the class name
        prstatement.setString(1, objectToSerialize.getClass().getName());
        prstatement.setBytes(2, blob.getBytes(1,(int)blob.length()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        prstatement.executeUpdate();
        ResultSet rs = prstatement.getGeneratedKeys();
        int serialized_id = -1;
        if (rs.next()) {
            serialized_id = rs.getInt(1);
        }
        rs.close();
        close();
        System.out.println("Java object serialized to database. Object: "
                + objectToSerialize);
        return serialized_id;
    }


    /**
     * Active la cconnection avec les param�tres d�finis
     *
     */
    private void connect() {

        try {
         //   File resourcesDirectory = new File("src/main/java/persistance/bdd/database.db");
         //   System.out.println(" path = "+ resourcesDirectory.getAbsolutePath());

            Class.forName("org.sqlite.JDBC");
         //   connection = DriverManager.getConnection("jdbc:sqlite::resource:" + Bdd );
            connection = DriverManager.getConnection("jdbc:sqlite:" + Bdd  );
            //prstatement = connection.createStatement();
            System.out.println("Connexion a " + Bdd + " avec succ�s :" + connection.getMetaData().getDatabaseProductName());
        } catch (ClassNotFoundException | SQLException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Path database :" + Bdd);
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
           // prstatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
