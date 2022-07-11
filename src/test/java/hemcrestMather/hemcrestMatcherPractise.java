package hemcrestMather;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hemcrestMatcherPractise {

    @Test
    @Order(2)
    @DisplayName("1.Bolum")
    public void spartan1() {
        System.out.println("deneme 1");

        ////ORNEK
           assertThat(3,is(3));       // Positive Scenario
        ////ORNEK
           assertThat(3,is(not(4))); // Negative Scenario
        ////ORNEK
        assertThat("ahmet", equalTo("ahmet"));
        assertThat("ahmet", equalToIgnoringCase("AHMET"));
        ////ORNEK
        List<Integer> list = Arrays.asList(34,45,66,99);
        assertThat(list, hasSize(4));
        assertThat(list, hasItems(34,99));



    }

}