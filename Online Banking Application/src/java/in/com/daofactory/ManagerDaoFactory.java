package in.com.daofactory;

import in.com.dao.IManagerDao;
import in.com.dao.ManagerDaoImpl;

public class ManagerDaoFactory {

    private static IManagerDao managerDao = null;

    private ManagerDaoFactory() {

    }

    public static IManagerDao getManagerDao() {
        if (managerDao == null) {
            managerDao = new ManagerDaoImpl();
        }
        return managerDao;
    }

}
