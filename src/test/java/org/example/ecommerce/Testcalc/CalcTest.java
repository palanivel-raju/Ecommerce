package org.example.ecommerce.Testcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void Test_Add_RunSucessfully() {
        //Arrange
        Calculator cal = new Calculator();
        //Act
        int res = cal.add(1,3);
        //Assert
        assertEquals(res, 4);
    }

    @Test
    void Test_divide_runSucessfully() {
        //Arrange
        Calculator calc = new Calculator();
//        Act
        int div = calc.divide(15, 3);
        //Assert
        assertEquals(div, 5);
    }
    @Test
    void Test_divide_throwsException(){
        //Arrange
        Calculator calc = new Calculator();
        //Act &&  //Assert
        assertThrows(ArithmeticException.class, ()-> calc.divide(1,0));
    }

}