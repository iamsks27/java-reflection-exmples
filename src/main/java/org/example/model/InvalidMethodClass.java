package org.example.model;

/**
 * @author sksingh created on 07/01/24
 */
public class InvalidMethodClass {

    // This method will fail validation & the program will throw RuntimeException
    public void PrintData(String data) {
        System.out.printf("Printing data: %s%n", data);
    }
}
