package testMethodOrderPractice;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class RandomClassCalıstırma {

    @Test
    @Order(2)
    @DisplayName("1.Bolum")
    public void spartan1() {
        System.out.println("deneme 1");
    }

    @Test
    @Order(3)
    @DisplayName("2.Bolum")
    public void spartan2() {
        System.out.println("deneme 2");
    }

    @Test
    @Order(1)
    @DisplayName("3.Bolum")
    public void spartan3() {
        System.out.println("deneme 3");

    }
}


