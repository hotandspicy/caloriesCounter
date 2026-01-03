import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();


    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void addNewNumberStepsPerDay(int month, int day, int steps) {
        if (month < 1) {
            System.out.println("Invalid month");
            return;
        } else if (month > 12) {
            System.out.println("Invalid month");
            return;
        }
        if (day < 1) {
            System.out.println("Invalid day");
            return;
        } else if (day > 30) {
            System.out.println("Invalid day");
            return;
        }
        if (steps < 1) {
            System.out.println("Invalid steps");
            return;
        }

        MonthData monthData = monthToData[month-1];
        monthData.days[day-1] = steps;
        System.out.println(monthData.days[day-1] + " шагов за " + month + " месяц, " + day + " день - cохранено" );

    }

    void changeStepGoal(int steps) {
        if (steps <= 0) {
            System.out.println("Нам нужны цели выше!");
            return;
        }
        goalByStepsPerDay = steps;
        System.out.println("Цель успешно изменена на новую: " + goalByStepsPerDay + " шагов");
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        MonthData monthData = monthToData[month-1];
        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Cреднее количество шагов за месяц: " + sumSteps / 30);
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лушчая серия: " + monthData.bestSeries(goalByStepsPerDay));
    }

}
