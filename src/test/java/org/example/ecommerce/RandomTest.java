package org.example.ecommerce;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {
//    public static void main(String[] args) {
//        testRandom();
//    }

    @Test
    public  void testRandom(){
        Random random = new Random();
        int n = random.nextInt(10);
        assert(n < 5);
    }

}
