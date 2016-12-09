/*
 * Practical Exercise 3 developed by Diego Rivera for Programming Fundamentals class.
 * 25/08/2016
 * Professor Rachel Jeikishore
 * This program reads data from the supplied text file (Employees.txt) that contains a list of employee details including
 * their monthly pay. The program calculates payroll summary information and display this data on the monitor and also write
 * it to a textfile (PayrollReport.txt).
 */

/**
 * @author diegorivera
 * 25/08/2016
 * PayrollReport.java
 */

import javax.swing.JOptionPane;
import java.io.*;
import java.text.DecimalFormat;

public class PayrollReport {

    /*
     * @param args the command line arguments
     */
    
    //declares the object dec to get round down to 2 decimal places the amount numbers
    public static DecimalFormat dec = new DecimalFormat(".##");
    
    //main declaration with "throws IOException" to the program allow any error with input and or output data. 
    public static void main(String[] args) throws IOException {
        String text = "Employees.txt";
        BufferedReader b = new BufferedReader(new FileReader(text));
        String id, last, pos;
        Double sal, sumMan = 0.0, sumSal = 0.0, sumAdm = 0.0, total = 0.0, avg = 0.0, count = 0.0;
        // read data
        id = b.readLine();
        String out = "";
        while (id != null) {
            last = b.readLine();
            pos = b.readLine();
            sal = Double.parseDouble(b.readLine());
            Employee employee = new Employee(id, last, pos, sal);
            if (employee.getPosition().equalsIgnoreCase("Manager")) {
                sumMan = sumMan + employee.getSalary();
            }
            if (employee.getPosition().equalsIgnoreCase("Sales")) {
                sumSal = sumSal + employee.getSalary();
            } else if (employee.getPosition().equalsIgnoreCase("Administration")) {
                sumAdm = sumAdm + employee.getSalary();
            }
            count = count + 1;
            total = sumMan + sumSal + sumAdm;
            avg = total / count;
            id = b.readLine();
            out += employee.toString();
        }
        
        //first and second outputs
        JOptionPane.showMessageDialog(null, out);
        JOptionPane.showMessageDialog(null, "PAYROLL SUMMARY\n\nManagers          Sales                 Admin\n"
                + "$" + dec.format(sumMan) + "        $" + dec.format(sumSal) + "        $" + dec.format(sumAdm));
        b.close();//end of read and extract of data

        //declares of pw object to write the data in PayrollReport.txt, third output
        String s = "PayrollReport.txt";
        FileWriter ff = new FileWriter(s);
        BufferedWriter bb = new BufferedWriter(ff);
        PrintWriter pw = new PrintWriter(bb);
        pw.println("Total Payroll: $" + dec.format(total)
                + "\nAverage pay: $" + dec.format(avg)
                
                + "\n\nTotal pay for:"
                +"\nManagers: $"+ dec.format(sumMan)
                +"\nSales Staff: $" + dec.format(sumSal)
                + "\nAdmin Staff: $" + dec.format(sumAdm));
        pw.close();//end of write data

    }//end main

}