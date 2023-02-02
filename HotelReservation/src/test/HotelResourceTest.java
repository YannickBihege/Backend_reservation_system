package test;

import api.HotelResource;
import service.CustomerService;

public class HotelResourceTest {

    public static void createACustomerReturnsAcustomer() {
        String email = "a@mail.com";
        String firstName = "y";
        String lastName = "Y";

        HotelResource.createACustomer(email, firstName, lastName);
        Boolean result = CustomerService.getAllCustomers().isEmpty();
        System.out.println(result);
        Boolean expected = false;
        if (result != expected) {
            throw new RuntimeException(String.format("createACustomerReturnsAcustomer not passed. Your result is %s ", result)
            );
        }
    }

    public static void main(String args[]) {
        createACustomerReturnsAcustomer();
    }

}
