package in.com.servicefactory;

import in.com.service.IManagerService;
import in.com.service.ManagerServiceImpl;

public class ManagerServiceFactory {

    private static IManagerService managerService = null;

    private ManagerServiceFactory() {

    }

    public static IManagerService getManagerService() {
        if (managerService == null) {
            managerService = new ManagerServiceImpl();
        }
        return managerService;
    }

}
