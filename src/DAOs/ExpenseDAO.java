package DAOs;

import DTOs.ExpenseDTO;
import java.util.List;

public interface ExpenseDAO {
    List<ExpenseDTO> getAllExpenses();
    void addExpense(ExpenseDTO expense);
    void deleteExpense(int expenseID);
    double getTotalSpend();
}
