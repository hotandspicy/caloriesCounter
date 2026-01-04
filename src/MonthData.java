import java.util.Arrays;

public class MonthData {

  int[] days = new int[30];

  public void printDaysAndStepsFromMonth() {
    for (int i = 0; i < days.length; i++) {
      System.out.println((i + 1) + " день: " + days[i]);
    }
  }

  public int sumStepsFromMonth() {
    return Arrays.stream(days)
        .sum();
  }

  public int maxSteps() {
    return Arrays.stream(days)
        .max()
        .orElse(0);
  }

  public int bestSeries(int goalByStepsPerDay) {
    int bestSeries = 0;
    int currentSeries = 0;

    for (int day : days) {
      if (day >= goalByStepsPerDay) {
        currentSeries++;
        if (currentSeries > bestSeries) {
          bestSeries = currentSeries;
        }
      } else {
        currentSeries = 0;
      }
    }

    return bestSeries;
  }
}
