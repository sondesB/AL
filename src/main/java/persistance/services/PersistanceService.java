package persistance.services;

import interfaceswcomp.OCService;
import persistance.interfaces.BaseDePlanAbstraite;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by seb on 03/02/17.
 */
public class PersistanceService {

    /**
     * Permet de récuperer la base de plan d'un service donnée.
     * @param ocService Le service.
     * @return La base de plan.
     */
    public BaseDePlanAbstraite getBaseDePlan(OCService ocService) {

        BaseDePlanAbstraite bp = null;
        PreparedStatement ps;
        ResultSet rs;
        String sql = null;

        // Forme du select a determiner
        //sql="select * from BasesDePlan where ?????";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if(rs.next())
            {
                ByteArrayInputStream bais;
                ObjectInputStream ins;

                bais = new ByteArrayInputStream(rs.getBytes("javaObject"));
                ins = new ObjectInputStream(bais);
                bp =(BaseDePlanAbstraite) ins.readObject();
                ins.close();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bp;
    }

    /**
     * Permet de sauvegarder une base de plan dans une base de don7nées.
     * @param baseDePlan La base de plan.
     */
    public void persisterBaseDePlan(BaseDePlanAbstraite baseDePlan) {
        try{
            PreparedStatement ps;
            String sql;

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(baseDePlan);
            oos.flush();
            oos.close();
            bos.close();

            byte[] data = bos.toByteArray();

            sql = "insert into BasesDePlan (baseDePlan) values(?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, data);
            ps.executeUpdate();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
