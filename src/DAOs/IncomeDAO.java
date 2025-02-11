package DAOs;

import DTOs.IncomeDTO;
import java.util.List;

public interface IncomeDAO
{
    List<IncomeDTO> getAllIncome();
    void addIncome(IncomeDTO income);
    void deleteIncome(int incomeID);
    double getTotalIncome();
}