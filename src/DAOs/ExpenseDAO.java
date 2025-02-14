package DAOs;
import Exception.DaoException;
import DTOs.ExpenseDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO extends BaseDao {
    public List<ExpenseDTO> getAllExpenses() throws DaoException {
        List<ExpenseDTO> expenseList = new ArrayList<>();
        String query = "SELECT * FROM expenses";
        Connection conn = null;

        try {
            conn = getConnection();
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(query);

            while (result.next()) {
                expenseList.add(new ExpenseDTO(
                        result.getInt("expenseID"),
                        result.getString("title"),
                        result.getString("category"),
                        result.getDouble("amount"),
                        result.getDate("dateIncurred")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        } finally {
            freeConnection(conn);
        }
        return expenseList;
    }

    public void addExpense(String title, String category, double amount, String dateIncurred) throws DaoException {
        String query = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = getConnection();
            PreparedStatement prepare = conn.prepareStatement(query);
            prepare.setString(1, title);
            prepare.setString(2, category);
            prepare.setDouble(3, amount);
            prepare.setString(4, dateIncurred);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeConnection(conn);
        }
    }

    public void deleteExpense(int expenseID) throws DaoException {
        String query = "DELETE FROM expenses WHERE expenseID = ?";
        Connection conn = null;

        try {
            conn = getConnection();
            PreparedStatement prepare = conn.prepareStatement(query);
            prepare.setInt(1, expenseID);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeConnection(conn);
        }
    }
}
