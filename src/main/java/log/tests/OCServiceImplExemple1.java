package log.tests;

import interfaceswcomp.OCService;

/**
 * Created by Blue on 16/02/2017.
 */
public class OCServiceImplExemple1 extends OCService {
    @Override
    public String getServiceName() {
        return "test 1";
    }

    @Override
    public String getServiceProperties() {
        return "properties 1";
    }
}
