public class Converter {
    int convertToKm(int steps) {
        int km = (steps * 75) / 100_000;
        return km;
    }
    int convertStepsToKilocalories(int steps) {
        int kilocalories = (steps * 50) / 1000;
        return kilocalories;
    }
}
