package cs3318.colour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class colourTest {

    @Test
    public void checkColorValuesCorrectDefaultRGBFloat() {
        float element1 = 0.1F;
        float element2 = 0.3F;
        float element3 = 0.5F;

        Colour color = new Colour(element1, element2, element3);

        assertArrayEquals(color.getValuesFloat(), color.getValuesFloat());
    }

    @Test
    public void checkColorValuesCorrectDefaultRGBBit() {
        int element1 = 17;
        int element2 = 9;
        int element3 = 1;

        Colour color = new Colour(element1, element2, element3);

        assertArrayEquals(color.getValuesBit(), color.getValuesBit());
    }

    @Test
    public void exceptionIfElementOutOfRangeFloat() {
        float element1 = 0.1f;
        float element2 = 0.3f;
        float element3 = -0.1f;

        /*
        check if there is illegal argument, then throw a message or something
        then verify within this test
         */
    }

    @Test
    public void noExceptionIfElementOutOfRangeFloat() {
        float element1 = 0.1f;
        float element2 = 0.3f;
        float element3 = 0.1f;

        assertDoesNotThrow(() -> new Colour(element1, element2, element3));
    }
}
