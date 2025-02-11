package DAOs;

import DAOs.BaseDao;
import DTOs.IncomeDTO;
import Exception.DaoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO extends BaseDao {
    public List<IncomeDTO> getAllIncome() throws DaoException {
        List<IncomeDTO> incomeList = new ArrayList<>();
        String query = "SELECT * FROM income";
        Connection conn = null;

        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                incomeList.add(new IncomeDTO(
                        result.getInt("incomeID"),
                        result.getString("title"),
                        result.getDouble("amount"),
                        result.getString("dateEarned")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeConnection(conn);
        }
        return incomeList;
    }

    public void addIncome(String title, double amount, String dateEarned) throws DaoException {
        String query = "INSERT INTO income (title, amount, dateEarned) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = getConnection();
            PreparedStatement queries = conn.prepareStatement(query);
            queries.setString(1, title);
            queries.setDouble(2, amount);
            queries.setString(3, dateEarned);
            queries.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeConnection(conn);
        }
    }

    public void deleteIncome(int incomeID) throws DaoException{
        String query = "DELETE FROM income WHERE incomeID = ?";
        Connection conn = null;

        try {
            conn = getConnection();
            PreparedStatement queries = conn.prepareStatement(query);
            queries.setInt(1, incomeID);
            queries.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeConnection(conn);
        }
    }
}
