package Test1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class courseTest extends course {

    @Test
    void testEquals() {
    }
    @Test
    void test1(){
        course c1 = new course("Java", "CSD214", null, 10);
        course c2 = new course("Java", "CSD214", null, 10);
        assertEquals(c1, c2);
    }
    @Test
    void test2(){
        course c1 = new course("Pythom", "CSD213", null, 10);
        course c2 = new course("Java", "CSD214", null, 10);
        assertEquals(c1, c2);
    }
}