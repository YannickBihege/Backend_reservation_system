package model;

import java.util.regex.Pattern;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;


    private final String emailRegex ="(.+)@(.+).com";
    private final Pattern pattern = Pattern.compile(emailRegex);


    public Customer(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;

        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Please give a valid email:");
        }else{
            this.email = email;
                }
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
