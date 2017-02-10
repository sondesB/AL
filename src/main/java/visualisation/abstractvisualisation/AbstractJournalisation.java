package visualisation.abstractvisualisation;


import com.m2dl.sma.infrastructure.annuaire.AgentListener;
import visualisation.interfaces.ITransfert;

@SuppressWarnings("all")
public abstract class AbstractJournalisation {
  public interface Requires {
  }
  
  public interface Component extends Provides {
  }
  
  public interface Provides {
    /**
     * This can be called to access the provided port.
     * 
     */
    public ITransfert donneEnvoyer();
    
    /**
     * This can be called to access the provided port.
     * 
     */
    public AgentListener notification();
  }
  
  public interface Parts {
  }
  
  public static class ComponentImpl implements Component, Parts {
    private final Requires bridge;
    
    private final AbstractJournalisation implementation;
    
    public void start() {
      this.implementation.start();
      this.implementation.started = true;
    }
    
    protected void initParts() {
      
    }
    
    private void init_donneEnvoyer() {
      assert this.donneEnvoyer == null: "This is a bug.";
      this.donneEnvoyer = this.implementation.make_donneEnvoyer();
      if (this.donneEnvoyer == null) {
      	throw new RuntimeException("make_donneEnvoyer() in abstractvisualisation.AbstractJournalisation should not return null.");
      }
    }
    
    private void init_notification() {
      assert this.notification == null: "This is a bug.";
      this.notification = this.implementation.make_notification();
      if (this.notification == null) {
      	throw new RuntimeException("make_notification() in abstractvisualisation.AbstractJournalisation should not return null.");
      }
    }
    
    protected void initProvidedPorts() {
      init_donneEnvoyer();
      init_notification();
    }
    
    public ComponentImpl(final AbstractJournalisation implem, final Requires b, final boolean doInits) {
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
    
    private ITransfert donneEnvoyer;
    
    public ITransfert donneEnvoyer() {
      return this.donneEnvoyer;
    }
    
    private AgentListener notification;
    
    public AgentListener notification() {
      return this.notification;
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
   * This should be overridden by the implementation to define the provided port.
   * This will be called once during the construction of the component to initialize the port.
   * 
   */
  protected abstract ITransfert make_donneEnvoyer();
  
  /**
   * This should be overridden by the implementation to define the provided port.
   * This will be called once during the construction of the component to initialize the port.
   * 
   */
  protected abstract AgentListener make_notification();
  
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
   * Not meant to be used to manually instantiate components (except for testing).
   * 
   */
  public synchronized Component _newComponent(final Requires b, final boolean start) {
    if (this.init) {
    	throw new RuntimeException("This instance of AbstractJournalisation has already been used to create a component, use another one.");
    }
    this.init = true;
    ComponentImpl  _comp = new ComponentImpl(this, b, true);
    if (start) {
    	_comp.start();
    }
    return _comp;
  }
  
  /**
   * Use to instantiate a component from this implementation.
   * 
   */
  public Component newComponent() {
    return this._newComponent(new Requires() {}, true);
  }
}
