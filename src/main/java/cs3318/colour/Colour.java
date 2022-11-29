package cs3318.colour;

public class Colour {

    private float[] valuesFloat;
    private int valuesBit;

    private final static float minRangeFloat = 0.0F;
    private final static float maxRangeFloat = 1.0F;

    private final static int minRangeRed = 16;
    private final static int maxRangeRed = 23;
    private final static int minRangeGreen = 8;
    private final static int maxRangeGreen = 15;
    private final static int minRangeBlue = 0;
    private final static int maxRangeBlue = 7;

    public Colour(float element1, float element2, float element3) {
        valuesFloat = new float[] {element1, element2, element3};

        exceptionIfColorElementsFloatOutOfRange(valuesFloat);

    }

    public Colour(int colorInBit) {
        valuesBit = colorInBit;

        exceptionIfColorElementsBitOutOfRange(valuesBit);
    }


    public float[] getValuesFloat() {
        return valuesFloat;
    }

    public int getValuesBit() {
        return valuesBit;
    }


    private static void exceptionIfColorElementsFloatOutOfRange(float[] colorValues) {
        for (int i = 0; i < colorValues.length; i++) {
            if (colorValues[i] < minRangeFloat || colorValues[i] > maxRangeFloat) {
                throw new IllegalArgumentException("Color element should be in range of float 0.0 and 1.0");
            }
        }
    }

    private static void exceptionIfColorElementsBitOutOfRange(int colourValues) {

        int redElement;
        int greenElement;
        int blueElement;

        String colorValuesString = String.valueOf(colourValues);

        if (colorValuesString.length() < 4 || colorValuesString.length() > 5) {
            throw new IllegalArgumentException("Color element should be in range 16-23 for red; 8-15 for green; 0-7 for blue");
        } else {
            redElement = Integer.parseInt(colorValuesString.substring(0, 2));
            blueElement = Integer.parseInt(colorValuesString.substring(colorValuesString.length() - 1));
            greenElement = Integer.parseInt(colorValuesString.substring(2, colorValuesString.length() - 1));

            if (minRangeRed <= redElement && redElement <= maxRangeRed) {
                if (minRangeGreen <= greenElement && greenElement <= maxRangeGreen) {
                    if (minRangeBlue <= blueElement && blueElement <= maxRangeBlue) {
                    } else {
                        throw new IllegalArgumentException("Color element should be in range 16-23 for red; 8-15 for green; 0-7 for blue");
                    }
                } else {
                    throw new IllegalArgumentException("Color element should be in range 16-23 for red; 8-15 for green; 0-7 for blue");
                }
            } else {
                throw new IllegalArgumentException("Color element should be in range 16-23 for red; 8-15 for green; 0-7 for blue");
            }
        }
    }
}
