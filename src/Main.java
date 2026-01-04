import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Введите порядковый номер месяца");
                int month = scanner.nextInt();
                System.out.println("Введите дату (день)");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                tracker.addNewNumberStepsPerDay(month, day, steps);

            }
            else if (command == 2) {
                int goal = scanner.nextInt();
                tracker.changeStepGoal(goal);
            }
            else if (command == 3) {
                tracker.printStatistic();
            }
            else if (command == 0) {
                break;
            }
        }
    }
    static void printMenu() {
        System.out.println("\nВыберите нужные пункт меню: ");
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("0 - выйти из приложения.");
    }
}
