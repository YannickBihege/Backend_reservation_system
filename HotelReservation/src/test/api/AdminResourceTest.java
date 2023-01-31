package test.api;

import model.Customer;
import service.CustomerService;

public class AdminResourceTest {

    public static void main(String[] args) {
        getCustomerReturnsEmailCustomerSetIsEmpty();
    }
    CustomerService customerService = new CustomerService();
    public static void getCustomerReturnsEmailCustomerSetIsEmpty() {
        Customer result = CustomerService.customersMails.get("mail@y.com");
        if(result != null) {
            throw new RuntimeException(String.format(
                    "getCustomer not Passed Calling the function should return a null object "
                    ));
        } else {
            System.out.println("getCustomer Passed The method returned a not null object");
        }
    }
}
