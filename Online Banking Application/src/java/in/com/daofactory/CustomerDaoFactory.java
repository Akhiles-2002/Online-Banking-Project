package in.com.daofactory;

import in.com.dao.CustomerDaoImpl;
import in.com.dao.ICustomerDao;

public class CustomerDaoFactory {

    private static ICustomerDao customerDao = null;

    private CustomerDaoFactory() {

    }

    public static ICustomerDao getCustomerDao() {
        if (customerDao == null) {
            customerDao = new CustomerDaoImpl();
        }
        return customerDao;
    }

}
