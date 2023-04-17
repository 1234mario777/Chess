package pl.sdk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ExampleTest {

//    @Test
//    void exampleTest(){
//        //given
//        Point point = new Point(1, 5);
//        //when
//        int x = point.getX();
//        //then
//        assertEquals(1, x);
//    }

    @Test
    void distanceShouldBeSaver() {
        Point point = new Point(4,3);

        double result;

        result = point.getDistanceToCenter();
        assertEquals(5, result);
    }
}
