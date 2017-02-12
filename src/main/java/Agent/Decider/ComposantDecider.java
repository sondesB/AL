package Agent.Decider;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Decider.ComposantTraitementAnnonce.ITraitementAnnonce;
import Agent.Decider.ComposantTraitementAnnonce.TraitementAnnonce;
import Agent.Decider.ComposantTraitementDisparition.ITraitementDisparitionComposant;
import Agent.Decider.ComposantTraitementDisparition.TraitementDisparitionComposant;
import Agent.Decider.ComposantTraitementPerceptionVide.ITraitementPerceptionVide;
import Agent.Decider.ComposantTraitementPerceptionVide.TraitementPerceptionVide;
import Agent.Decider.ComposantTraitementReponse.ITraitementReponse;
import Agent.Decider.ComposantTraitementReponse.TraitementReponse;
import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;
import Agent.Percevoir.CreerPerception.Perceptions.PerceptionAnnonce;
import Agent.Percevoir.CreerPerception.Perceptions.PerceptionReponse;
import Agent.Percevoir.CreerPerception.Perceptions.PerceptionSonde;
import Agent.Percevoir.CreerPerception.Perceptions.PerceptionVide;
import interfaceswcomp.OCService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qsaieb on 10/02/2017.
 */
public class ComposantDecider implements IComposantDecider{

  private List<AbstractPerception> listePerceptions;
  private OCService service;
  private ITraitementAnnonce traitementAnnonce;
  private ITraitementDisparitionComposant traitementDisparitionComposant;
  private ITraitementPerceptionVide traitementPerceptionVide;
  private ITraitementReponse traitementReponse;

  public ComposantDecider(OCService service) {
    this.service = service;
    this.traitementAnnonce = new TraitementAnnonce();
    this.traitementDisparitionComposant = new TraitementDisparitionComposant();
    this.traitementPerceptionVide = new TraitementPerceptionVide();
    this.traitementReponse = new TraitementReponse();
    this.listePerceptions = new ArrayList<AbstractPerception>();
  }

  public List<AbstractDecision> decider() {
    List<AbstractDecision> listeDecisions = new ArrayList<AbstractDecision>();
    List<PerceptionAnnonce> listePerceptionAnnonce = new ArrayList<PerceptionAnnonce>();
    List<PerceptionVide> listePerceptionVide = new ArrayList<PerceptionVide>();
    List<PerceptionSonde> listePerceptionSonde = new ArrayList<PerceptionSonde>();
    List<PerceptionReponse> listePerceptionReponse = new ArrayList<PerceptionReponse>();

    for (AbstractPerception perception : this.listePerceptions) {
      if (perception instanceof PerceptionAnnonce) {
        listePerceptionAnnonce.add((PerceptionAnnonce) perception);
      } else if (perception instanceof PerceptionVide) {
        listePerceptionVide.add((PerceptionVide) perception);
      } else if (perception instanceof PerceptionSonde) {
        listePerceptionSonde.add((PerceptionSonde) perception);
      } else if (perception instanceof PerceptionReponse) {
        listePerceptionReponse.add((PerceptionReponse) perception);
      }
    }

    if (listePerceptionSonde.size() > 0) {
      this.traitementDisparitionComposant.traiter(listePerceptionSonde);
    } else if (listePerceptionAnnonce.size() > 0) {
      this.traitementAnnonce.traiter(listePerceptionAnnonce);
    } else if (listePerceptionReponse.size() > 0) {
      this.traitementReponse.traiter(listePerceptionReponse);
    } else if (listePerceptionVide.size() > 0) {
       this.traitementPerceptionVide.traiter(listePerceptionVide);
    }

    return listeDecisions;
  }

  public List<AbstractPerception> getListePerceptions() {
    return listePerceptions;
  }

  public void setListePerceptions(List<AbstractPerception> listePerceptions) {
    this.listePerceptions = listePerceptions;
  }
}
