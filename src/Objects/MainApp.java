package Objects;
import Exception.DaoException;
import DAOs.ExpenseDAO;
import DAOs.IncomeDAO;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws DaoException {
        Scanner scanner = new Scanner(System.in);
        IncomeDAO incomeDAO = new IncomeDAO();
        ExpenseDAO expenseDAO = new ExpenseDAO();

        while (true) {
            System.out.println("\nExpense Record Menu:");
            System.out.println("1. List Income");
            System.out.println("2. Add Income");
            System.out.println("3. Delete Income");
            System.out.println("4. List Expenses");
            System.out.println("5. Add Expense");
            System.out.println("6. Delete Expense");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    incomeDAO.getAllIncome().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = scanner.next();
                    incomeDAO.addIncome(title, amount, date);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
