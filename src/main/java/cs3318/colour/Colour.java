package cs3318.colour;

public class Colour {

    private float[] valuesFloat;
    private int[] valuesBit;

    private final static float minRange = 0.0F;
    private final static float maxRange = 1.0F;

    public Colour(float element1, float element2, float element3) {
        valuesFloat = new float[] {element1, element2, element3};

    }

    public Colour(int element1, int element2, int element3) {
        valuesBit = new int[] {element1, element2, element3};

    }


    public float[] getValuesFloat() {
        return valuesFloat;
    }

    public int[] getValuesBit() {
        return valuesBit;
    }
}
