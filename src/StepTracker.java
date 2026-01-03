import java.util.Scanner;

public class StepTracker {

    private final Scanner scanner;
    private final MonthData[] monthToData = new MonthData[12];
    private int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        this.scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay(int month, int day, int steps) {
        if(!isMonthValid(month)) {
          System.out.println("Invalid month");
          return;
        }

        if(!isDayValid(day)) {
          System.out.println("Invalid day");
          return;
        }

        if (!isStepsValid(steps)) {
            System.out.println("Invalid steps");
            return;
        }

        MonthData monthData = monthToData[month-1];
        monthData.days[day-1] = steps;
        System.out.println(monthData.days[day-1] + " шагов за " + month + " месяц, " + day + " день - cохранено" );
    }

  public void changeStepGoal(int steps) {
        if (steps <= 0) {
            System.out.println("Нам нужны цели выше!");
            return;
        }
        goalByStepsPerDay = steps;
        System.out.println("Цель успешно изменена на новую: %s шагов".formatted(goalByStepsPerDay));
    }

  public void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        MonthData monthData = monthToData[month-1];
        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Cреднее количество шагов за месяц: " + sumSteps / 30);
        System.out.println("Пройденная дистанция (в км): " + Converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий: " + Converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лушчая серия: " + monthData.bestSeries(goalByStepsPerDay));
    }

    private boolean isMonthValid(int month) {
      return month > 0 && month <= 12;
    }

    private boolean isDayValid(int day) {
      return day > 0 && day <= 30;
    }

    private boolean isStepsValid(int steps) {
      return steps > 0;
    }

}
