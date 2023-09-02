import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FinanceCalculator {
    public static void main() throws SQLException {
        conn f = new conn();
        db f1 = new db();
        double com = 0;
        try {
            f.Conn();
            com = f1.mainfr();
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Установка соединения с базой данных
            connection = DriverManager.getConnection("jdbc:sqlite:DataBase.s3db");
            statement = connection.createStatement();

            // Выполнение запроса SQL для выборки данных из таблицы
            String query = "SELECT Pritok, Dis FROM Doxod";
            resultSet = statement.executeQuery(query);

            List<String> pritokList = new ArrayList<>();
            List<String> disList = new ArrayList<>();

            // Итерация по результатам запроса и добавление значений в списки
            while (resultSet.next()) {
                String pritok = resultSet.getString("Pritok");
                String dis = resultSet.getString("Dis");

                pritokList.add(pritok);
                disList.add(dis);
            }
            double equityCapital = com;
            double financingVolumeDCF = calculateFinancingVolumeDCF(pritokList, disList, equityCapital);
            double financingVolumeWACC = calculateFinancingVolumeWACC(pritokList, disList);
            db f3 = new db();
            try {
                f3.maivndox(financingVolumeDCF, financingVolumeWACC);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            // Закрытие ресурсов
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }


    public static double calculateFinancingVolumeDCF(List<String> cashFlows, List<String> discountRates, double equityCapital) {
        // Расчет объема финансирования инвестиционной программы по методу DCF
        double discountedCashFlows = 0;

        for (int i = 0; i < cashFlows.size(); i++) {
            double cashFlow = Double.parseDouble(cashFlows.get(i));
            double discountRate = Double.parseDouble(discountRates.get(i));
            double discountFactor = 1 / Math.pow(1 + discountRate, i + 1);
            discountedCashFlows += cashFlow * discountFactor;
        }

        return discountedCashFlows - equityCapital;
    }

    public static double calculateFinancingVolumeWACC(List<String> cashFlows, List<String> discountRates) {
        // Расчет объема финансирования инвестиционной программы по методу WACC
        double discountedCashFlows = 0;

        for (int i = 0; i < cashFlows.size(); i++) {
            double cashFlow = Double.parseDouble(cashFlows.get(i));
            double discountRate = Double.parseDouble(discountRates.get(i));
            double discountFactor = 1 / Math.pow(1 + discountRate, i + 1);
            discountedCashFlows += cashFlow * discountFactor;
        }

        return discountedCashFlows;
    }
}
