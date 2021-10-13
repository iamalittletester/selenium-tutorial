package taudemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithAssertionsTest {

    @Test
    public void firstAssertion() {
        assertEquals(2, 2);
    }

    @Test
    public void secondAssertion() {
        assertEquals(45, 45);
    }

}
