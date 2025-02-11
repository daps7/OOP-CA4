package DAOs;
import DTOs.ExpenseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Exception.DaoException;
public class ImplementExpenseDAO extends ExpenseDAO {
    private Connection conn;

    public ImplementExpenseDAO() throws DaoException {
        conn = BaseDao.getConnection();
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<ExpenseDTO> expenses = new ArrayList<>();
        String query = "SELECT * FROM expenses";

        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ExpenseDTO expense = new ExpenseDTO();
                expense.setExpenseID(rs.getInt("expenseID"));
                expense.setTitle(rs.getString("title"));
                expense.setCategory(rs.getString("category"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setDateIncurred(rs.getDate("dateIncurred"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expenses;
    }

    public void addExpense(ExpenseDTO expense) {
        String query = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, expense.getTitle());
            pstmt.setString(2, expense.getCategory());
            pstmt.setDouble(3, expense.getAmount());
            pstmt.setDate(4, new java.sql.Date(expense.getDateIncurred().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
