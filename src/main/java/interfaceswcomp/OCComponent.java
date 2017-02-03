package interfaceswcomp;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Opportunistic Composition Component : abstract model of component
 * @version 0.1.0
 */
public abstract class OCComponent {

	protected ArrayList<OCService> required;
	protected ArrayList<OCService> provided;
	protected Properties properties;

	public abstract ArrayList<OCService> getRequiredServices();
	public abstract ArrayList<OCService> getProvidedServices();
	public abstract String getComponentProperties();
}
