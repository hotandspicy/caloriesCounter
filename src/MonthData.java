public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println( (i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int totalStepsPerMonth = 0;
        for (int i = 0; i < days.length; i++) {
            totalStepsPerMonth += days[i];
        }
    return totalStepsPerMonth;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
    return maxSteps;
    }

    int  bestSeries(int goalByStepsPerDay) {
        int bestSeries = 0;
        int currentSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > bestSeries) {
                    bestSeries = currentSeries;
                }
            } else {
                currentSeries    = 0;
            }
        }
    return bestSeries;
    }
}
