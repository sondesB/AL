package log.tests;

import interfaceswcomp.OCService;

/**
 * Created by Blue on 16/02/2017.
 */
public class OCServiceImplExemple2 extends OCService {
    @Override
    public String getServiceName() {
        return "test 2";
    }

    @Override
    public String getServiceProperties() {
        return "properties 2";
    }
}
