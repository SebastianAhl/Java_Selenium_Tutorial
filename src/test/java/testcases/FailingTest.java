package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class FailingTest {
    @Test
    @Tag("Test")
    public void failingTest1(){
        assertEquals(1, 2);

    }

    @Test
    @Tag("Test")
    public void failingTest2(){
        assertEquals(1, 2);
    }
}