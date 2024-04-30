package br.com.sample.demo;

import org.junit.jupiter.api.Test;

class GeneralTest {

    @Test
    public void test() {
        for (int i = 0; i < 50; i++) {
            System.out.println((int)(Math.random() * 11));
        }
    }

}
