import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class conn {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:DataBase.s3db");

    }
    // --------Работа с таблицами--------
    public static void WriteDB(double summ1, double summ2) throws SQLException
    {
        statmt.execute("UPDATE project set summ1 = '" +summ1+"'");
        statmt.execute("UPDATE project set summ2 = '" +summ2+"'");
    }
    public static void WriteBank(String name, double stav, double summ1, double summ2, int srok, String link) throws SQLException {
        String sql = "INSERT INTO bank (name, stav, summ1, summ2, srok, link) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);
        statement.setDouble(2, stav);
        statement.setDouble(3, summ1);
        statement.setDouble(4, summ2);
        statement.setInt(5, srok);
        statement.setString(6, link);
        statement.executeUpdate();
        //statmt.execute("INSERT INTO bank VALUES (?,?,?,?,?,?);,'"+name+"','"+stav+"','" +summ1+"','" +summ2+"','" +srok+"','" +link+"'");
    }

    public static void WriteInv(String name, double stav, double plata) throws SQLException {
        String sql = "INSERT INTO invest (name, stav, plata) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);
        statement.setDouble(2, stav);
        statement.setDouble(3, plata);
        statement.executeUpdate();
    }
    public static void DeleteBD() throws SQLException
    {
        statmt.execute("TRUNCATE TABLE bank");
        statmt.execute("TRUNCATE TABLE invest");
    }
    public static List<String> getBDDoxodValues(List<String> values) throws SQLException {

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT Pritok FROM Doxod");

        while (resultSet.next()) {
            String value = resultSet.getString("Pritok");
            values.add(value);
        }

        resultSet.close();
        statement.close();

        return values;
    }
    public List<String> getBDDisValues(List<String> values) throws SQLException {

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT Dis FROM Doxod");

        while (resultSet.next()) {
            String value = resultSet.getString("Dis");
            values.add(value);
        }

        resultSet.close();
        statement.close();

        return values;
    }
    public List<String> getnamebankValues(List<String> values) throws SQLException {

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM invest");

        while (resultSet.next()) {
            String value = resultSet.getString("name");
            values.add(value);
        }

        resultSet.close();
        statement.close();

        return values;
    }
    public List<String> getperValues(List<String> values) throws SQLException {

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT stav FROM invest");

        while (resultSet.next()) {
            String value = resultSet.getString("stav");
            values.add(value);
        }

        resultSet.close();
        statement.close();

        return values;
    }
    public List<String> getvznosValues(List<String> values) throws SQLException {

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT plata FROM invest");

        while (resultSet.next()) {
            String value = resultSet.getString("plata");
            values.add(value);
        }

        resultSet.close();
        statement.close();

        return values;
    }
    public static int ReadDBT() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM project");
        int release = 0;
        while (resSet.next()) {
            release = resSet.getInt("srok");
            //System.out.println(release);
        }
        return release;
    }

    public static int summa() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM project");
        int summa = 0;
        while (resSet.next()) {
            summa = resSet.getInt("summ2");
            //System.out.println(release);
        }
        return summa;
    }


    public static int ReadDBFr() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM project");
        int company = 0;
        while (resSet.next()) {
            company = resSet.getInt("comp");
            //System.out.println(company);
        }
        return company;
    }

    public static PreparedStatement prepareStatement(String query) throws ClassNotFoundException, SQLException {
        PreparedStatement statement = conn.prepareStatement(query);

        return statement;
    }
    public static int ReadSumm1() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM project");
        int summ1 = 0;
        while (resSet.next()) {
            summ1 = resSet.getInt("summ1");
        }
        return summ1;
    }

    public static int ReadSumm2() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM project");
        int summ2 = 0;
        while (resSet.next()) {
            summ2 = resSet.getInt("summ2");
        }
        return summ2;
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }

    public static Object createStatement() {

        return null;
    }
}