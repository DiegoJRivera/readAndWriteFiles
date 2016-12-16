/*
 * Practical Exercise 3 developed by Diego Rivera for Programming Fundamentals class.
 * 25/08/2016
 * This java file is the class to employee object.
 */

/**
 *
 * @author diegorivera
 * 25/08/2016
 * Employee.java
 * 
 */
public class Employee {

    private String ID, lastName, position;
    private Double salary;

    //constructor with parameters
    public Employee(String ID, String lastName, String position, Double salary) {
        this.ID = ID;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }
   //get and set methods for ID,lastName, position, salary
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    //toString method, send it to make the first output
    @Override
    public String toString() {
        return "ID: " + ID + ", last: " + lastName + " (" + position + "), Salary: $" + salary+"\n";
    }

}
