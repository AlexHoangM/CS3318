package cs3318.colour;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
        int colorInBit = 1791;

        Colour color = new Colour(colorInBit);

        assertEquals(color.getValuesBit(), color.getValuesBit());
    }

    @Test
    public void exceptionIfElementOutOfRangeFloat() {
        float element1 = 0.1f;
        float element2 = 0.3f;
        float element3 = -0.1f;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Colour(element1, element2, element3));

        assertEquals("Color element should be in range of float 0.0 and 1.0", exception.getMessage());
    }

    @Test
    public void noExceptionIfElementOutOfRangeFloat() {
        float element1 = 0.1f;
        float element2 = 0.3f;
        float element3 = 0.1f;

        assertDoesNotThrow(() -> new Colour(element1, element2, element3));
    }

    @Test
    public void exceptionIfElementOutOfRangeBit() {
        int element = 17915;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Colour(element));

        assertEquals("Color element should be in range 16-23 for red; 8-15 for green; 0-7 for blue", exception.getMessage());
    }

    @Test
    public void noExceptionIfElementOutOfRangeBit() {
        int element = 1791;

        assertDoesNotThrow(() -> new Colour(element));
    }

    static Stream<Arguments> testCasesFloat() {
        return Stream.of(
                Arguments.of(0.1f, 0.2f, 0.3f),
                Arguments.of(-0.1f, 0.2f, 0.3f),
                Arguments.of(0.3f, 0.4f, 1.9f)
        );
    }

    @ParameterizedTest
    @MethodSource("testCasesFloat")
    public void exceptionIfElementOutOfRange(float element1, float element2, float element3) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Colour(element1, element2, element3));

        assertEquals("Color element should be in range of float 0.0 and 1.0", exception.getMessage());
    }


    static Stream<Arguments> testCasesBit() {
        return Stream.of(
                Arguments.of(23157),
                Arguments.of(-1157),
                Arguments.of(23167)
        );
    }
    @ParameterizedTest
    @MethodSource("testCasesBit")
    public void exceptionIfElementOutOfRange(int element) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Colour(element));

        assertEquals("Color element should be in range 16-23 for red; 8-15 for green; 0-7 for blue", exception.getMessage());
    }
}
