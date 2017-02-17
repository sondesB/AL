package persistance.implementations;

import interfaceswcomp.OCService;
import persistance.interfaces.BaseDePlanAbstraite;
import persistance.interfaces.IPersistance;
import persistance.interfaces.IRecuperationPlan;
import persistance.services.PersistanceService;

import java.io.File;

/**
 * Created by seb on 03/02/17.
 */
public class PersistanceImpl implements IPersistance,IRecuperationPlan {

    PersistanceService persistanceService = new PersistanceService();

    @Override
    public void persisterBaseDePlan(BaseDePlanAbstraite baseDePlan) {
        this.persistanceService.setConnexion(".."+ File.separator+"bdd"+ File.separator+"database.db");
        this.persistanceService.persisterBaseDePlan(baseDePlan);
    }

    @Override
    public BaseDePlanAbstraite recupererBasePlan(int id) {
        this.persistanceService.setConnexion(".."+ File.separator+"bdd"+ File.separator+"database.db");
        return this.persistanceService.getBaseDePlan(id);
    }

    /**
     * Définir les informations de connexions à la base de données.
     * @param username L'utilisateur.
     * @param password Le mot de passe.
     * @param url L'url de connexion.
     * @param driver Le driver sql.
     */
    /*public void setDonneeConnexion(String username,String password, String url, String driver) {
        this.persistanceService.setConnexion(username,password,url,driver);
    }*/
}
