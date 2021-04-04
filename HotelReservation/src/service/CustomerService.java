package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    public static  ArrayList<Customer> customers = new ArrayList<Customer>();

    public static Map<String, Customer> customersMails = new HashMap<String, Customer>();

    public static void addCustomer(String email, String firstName, String lastName){
            Customer customer = new Customer(firstName, lastName, email);
            // Add it to the arraylist customers
            customers.add(customer);
            // add it to the map
        customersMails.put(email,customer);
    }

    public static Customer getCustomer(String customerEmail){
        /**
         * @params Takes a customer email as onput
         * @returns a customer on the base of a Map of key values: <email, Customer></email,>
         */
        return customersMails.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers(){
        /**
         * @returns the function returns a list of customers.
         */
        for (Customer customer: customers
             ) {
            System.out.println(customer);
        }
            return customers;
    }
}
