package in.com.servicefactory;

import in.com.service.CustomerServiceImpl;
import in.com.service.ICustomerService;

public class CustomerServiceFactory {

    private static ICustomerService customerService = null;

    private CustomerServiceFactory() {

    }

    public static ICustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerServiceImpl();
        }
        return customerService;
    }

}
