package org.example.ecommerce.Testcalc;

public class Calculator {
    int add(int a, int b){
        return a+b;
    }
    int divide(int a, int b){
        try{
            return a/b;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

}
