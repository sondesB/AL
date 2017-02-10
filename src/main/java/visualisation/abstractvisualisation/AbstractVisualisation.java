package visualisation.abstractvisualisation;


import visualisation.interfaces.IServiceNotification;
import visualisation.interfaces.IServiceSouscription;
import visualisation.interfaces.ITransfert;

@SuppressWarnings("all")
public abstract class AbstractVisualisation {
  public interface Requires {
    /**
     * This can be called by the implementation to access this required port.
     * 
     */
    public IServiceSouscription souscription();
  }
  
  public interface Component extends Provides {
  }
  
  public interface Provides {
    /**
     * This can be called to access the provided port.
     * 
     */
    public IServiceNotification notification();
  }
  
  public interface Parts {
    /**
     * This can be called by the implementation to access the part and its provided ports.
     * It will be initialized after the required ports are initialized and before the provided ports are initialized.
     * 
     */
    public AbstractAffichage.Component affichage();
    
    /**
     * This can be called by the implementation to access the part and its provided ports.
     * It will be initialized after the required ports are initialized and before the provided ports are initialized.
     * 
     */
    public AbstractJournalisation.Component journalisation();
  }
  
  public static class ComponentImpl implements Component, Parts {
    private final Requires bridge;
    
    private final AbstractVisualisation implementation;
    
    public void start() {
      assert this.affichage != null: "This is a bug.";
      ((AbstractAffichage.ComponentImpl) this.affichage).start();
      assert this.journalisation != null: "This is a bug.";
      ((AbstractJournalisation.ComponentImpl) this.journalisation).start();
      this.implementation.start();
      this.implementation.started = true;
    }
    
    private void init_affichage() {
      assert this.affichage == null: "This is a bug.";
      assert this.implem_affichage == null: "This is a bug.";
      this.implem_affichage = this.implementation.make_affichage();
      if (this.implem_affichage == null) {
      	throw new RuntimeException("make_affichage() in abstractvisualisation.AbstractVisualisation should not return null.");
      }
      this.affichage = this.implem_affichage._newComponent(new BridgeImpl_affichage(), false);
      
    }
    
    private void init_journalisation() {
      assert this.journalisation == null: "This is a bug.";
      assert this.implem_journalisation == null: "This is a bug.";
      this.implem_journalisation = this.implementation.make_journalisation();
      if (this.implem_journalisation == null) {
      	throw new RuntimeException("make_journalisation() in abstractvisualisation.AbstractVisualisation should not return null.");
      }
      this.journalisation = this.implem_journalisation._newComponent(new BridgeImpl_journalisation(), false);
      
    }
    
    protected void initParts() {
      init_affichage();
      init_journalisation();
    }
    
    protected void initProvidedPorts() {
      
    }
    
    public ComponentImpl(final AbstractVisualisation implem, final Requires b, final boolean doInits) {
      this.bridge = b;
      this.implementation = implem;
      
      assert implem.selfComponent == null: "This is a bug.";
      implem.selfComponent = this;
      
      // prevent them to be called twice if we are in
      // a specialized component: only the last of the
      // hierarchy will call them after everything is initialised
      if (doInits) {
      	initParts();
      	initProvidedPorts();
      }
    }
    
    public IServiceNotification notification() {
      return this.journalisation().notification();
    }
    
    private AbstractAffichage.Component affichage;
    
    private AbstractAffichage implem_affichage;
    
    private final class BridgeImpl_affichage implements AbstractAffichage.Requires {
      public final ITransfert donneRecu() {
        return ComponentImpl.this.journalisation().donneEnvoyer();
      }
    }
    
    public final AbstractAffichage.Component affichage() {
      return this.affichage;
    }
    
    private AbstractJournalisation.Component journalisation;
    
    private AbstractJournalisation implem_journalisation;
    
    private final class BridgeImpl_journalisation implements AbstractJournalisation.Requires {
    }
    
    public final AbstractJournalisation.Component journalisation() {
      return this.journalisation;
    }
  }
  
  /**
   * Used to check that two components are not created from the same implementation,
   * that the component has been started to call requires(), provides() and parts()
   * and that the component is not started by hand.
   * 
   */
  private boolean init = false;;
  
  /**
   * Used to check that the component is not started by hand.
   * 
   */
  private boolean started = false;;
  
  private ComponentImpl selfComponent;
  
  /**
   * Can be overridden by the implementation.
   * It will be called automatically after the component has been instantiated.
   * 
   */
  protected void start() {
    if (!this.init || this.started) {
    	throw new RuntimeException("start() should not be called by hand: to create a new component, use newComponent().");
    }
  }
  
  /**
   * This can be called by the implementation to access the provided ports.
   * 
   */
  protected Provides provides() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("provides() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if provides() is needed to initialise the component.");
    }
    return this.selfComponent;
  }
  
  /**
   * This can be called by the implementation to access the required ports.
   * 
   */
  protected Requires requires() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("requires() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if requires() is needed to initialise the component.");
    }
    return this.selfComponent.bridge;
  }
  
  /**
   * This can be called by the implementation to access the parts and their provided ports.
   * 
   */
  protected Parts parts() {
    assert this.selfComponent != null: "This is a bug.";
    if (!this.init) {
    	throw new RuntimeException("parts() can't be accessed until a component has been created from this implementation, use start() instead of the constructor if parts() is needed to initialise the component.");
    }
    return this.selfComponent;
  }
  
  /**
   * This should be overridden by the implementation to define how to create this sub-component.
   * This will be called once during the construction of the component to initialize this sub-component.
   * 
   */
  protected abstract AbstractAffichage make_affichage();
  
  /**
   * This should be overridden by the implementation to define how to create this sub-component.
   * This will be called once during the construction of the component to initialize this sub-component.
   * 
   */
  protected abstract AbstractJournalisation make_journalisation();
  
  /**
   * Not meant to be used to manually instantiate components (except for testing).
   * 
   */
  public synchronized Component _newComponent(final Requires b, final boolean start) {
    if (this.init) {
    	throw new RuntimeException("This instance of AbstractVisualisation has already been used to create a component, use another one.");
    }
    this.init = true;
    ComponentImpl  _comp = new ComponentImpl(this, b, true);
    if (start) {
    	_comp.start();
    }
    return _comp;
  }
}
