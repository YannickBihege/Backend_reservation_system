package service;

import model.Customer;

import java.util.*;

public class CustomerService {

    public static Set<Customer> customers = new HashSet<Customer>();

    public static Set<String> mails = new HashSet<String>();

    public static Map<String, Customer> customersMails = new HashMap<String, Customer>();

    public static void addCustomer(String email, String firstName, String lastName){
        /*
          Customers are defined as a set . That is a list of unique elements.
          Therefore, the customer is not added if the object already exists.
          The email address should be available. I introduced a set to verify the availability.
         */
            Customer customer = new Customer(firstName, lastName, email);

            if(! customers.contains(customer) && ! mails.contains(email) ){
                // Add it to the arraylist customers
                customers.add(customer);
                // add it to the map
                customersMails.put(email,customer);

            }
            else {
                System.out.println("The corresponding customer already exists. Choose a different email address.");
            }

    }

    public static Customer getCustomer(String customerEmail){
        /**
         * @params Takes a customer email as input
         * @returns a customer on the base of a Map of key values: <email, Customer></email,>
         */
        return customersMails.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers(){
        /**
         * @returns the function returns a list of customers.
         */
            return customers;
    }
}
