import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class db {


    public static void maivndox(double summ1, double summ2) throws ClassNotFoundException, SQLException {
        conn.Conn();
        conn.WriteDB(summ1, summ2);
    }
    public static double maivndox1() throws ClassNotFoundException, SQLException {
        conn.Conn();
        double summ1 = 0;
        summ1 = conn.ReadSumm1();
        return summ1;
    }
    public static double maivndox2() throws ClassNotFoundException, SQLException {
        conn.Conn();
        double summ2 = 0;
        summ2 = conn.ReadSumm2();
        return summ2;
    }
    public static int maint() throws ClassNotFoundException, SQLException {
        conn.Conn();
        int release = 0;
        release = conn.ReadDBT();
        return release;
    }
    public ResultSet getDis() throws SQLException, ClassNotFoundException {
        String query = "SELECT Dis FROM Doxod";
        PreparedStatement statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }

    public ResultSet getPritok() throws SQLException, ClassNotFoundException {
        String query = "SELECT Pritok FROM Doxod";
        PreparedStatement statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }
    public static double mainfr() throws ClassNotFoundException, SQLException {
        conn.Conn();
        double company = 0;
        company = conn.ReadDBFr();
        return company;
    }


}

