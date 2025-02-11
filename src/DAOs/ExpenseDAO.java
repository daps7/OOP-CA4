package DAOs;
import Exception.DaoException;
import DAOs.BaseDao;
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
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                expenseList.add(new ExpenseDTO(
                        rs.getInt("expenseID"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getDouble("amount"),
                        rs.getDate("dateIncurred")
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
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, title);
            pstmt.setString(2, category);
            pstmt.setDouble(3, amount);
            pstmt.setString(4, dateIncurred);
            pstmt.executeUpdate();
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
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, expenseID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeConnection(conn);
        }
    }
}
