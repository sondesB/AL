package interfaceswcomp;

import java.util.Properties;

/**
 * Opportunistic Composition Service : abstract model of service
 * @version 0.1.0
 */
public abstract class OCService {

	protected String name;
	protected Properties properties;  // at least : provided or required
	
	public abstract String getServiceName();	
	public abstract String getServiceProperties();
}
