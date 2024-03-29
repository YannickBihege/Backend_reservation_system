package model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Customer {

    private String firstName;
    private final String lastName;
    private String email;

    private static final String emailRegex ="(.+)@(.+).com";
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;

        try {
            if (!pattern.matcher(email).matches()) {
                throw new IllegalArgumentException("Please give a valid email:");
            } else {
                this.email = email;
            }
        }catch(Exception e){
            System.out.println("The email does not follow a required pattern");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(emailRegex, emailRegex) && Objects.equals(pattern, customer.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, emailRegex, pattern);
    }
}
