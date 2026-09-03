public class Lasagna {

    private final int cookingTime;
    private final int preparationTimeForOneLayer;

    public Lasagna() {
        this.cookingTime = 40;
        this.preparationTimeForOneLayer = 2;
    }

    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven() {
        return this.cookingTime;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public int remainingMinutesInOven(int numberOfMinutesElapsed) {
        if (numberOfMinutesElapsed <= this.cookingTime) {
            return this.cookingTime - numberOfMinutesElapsed;
        } else {
            return 0;
        }
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    public int preparationTimeInMinutes(int numberOfLayers) {
        return this.preparationTimeForOneLayer * numberOfLayers;
    }

    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int numberOfLayers, int numberOfMinutesInOven) {
        return this.preparationTimeInMinutes(numberOfLayers) + numberOfMinutesInOven;
    }
}
