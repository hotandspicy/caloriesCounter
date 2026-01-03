public class Converter {

  private Converter() {

  }

  public static int convertToKm(int steps) {
    return (steps * 75) / 100_000;
  }

  public static int convertStepsToKilocalories(int steps) {
    return (steps * 50) / 1000;
  }
}
