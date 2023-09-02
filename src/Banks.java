import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Banks {

    static double calculateMonthlyPayment(double principal, double interestRate, int term) {
        double monthlyInterestRate = interestRate / 100 / 12;
        int numberOfPayments = term * 12;
        double monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        return monthlyPayment;
    }

    public static void main() throws SQLException, ClassNotFoundException {
        List <String> name = new ArrayList<>();
        List <String> links = new ArrayList<>();
        List <Double> perc = new ArrayList<>();
        int srok = 0;
        double summ = 0;
        double summ1 = 0;
        conn BD = new conn();
        srok = BD.ReadDBT();
        summ = BD.ReadSumm2();
        summ1 = BD.ReadSumm1();
        name.add("Сбербанк");
        name.add("Тинькофф");
        name.add("Газпромбанк");
        name.add("Альфабанк");
        links.add("https://www.sberbank.com/ru/person/credits/money/consumer_unsecured");
        links.add("https://www.tinkoff.ru/loans/cash-loan/?dco_ic=88642dca-14e5-11ee-8000-00008c405b3f");
        links.add("https://www.gazprombank.ru/personal/take_credit/consumer_credit/5004451");
        links.add("https://alfabank.ru/get-money/credit/credit-cash/");
        double monthlyPayment = 0;
        if (summ <= 350000.0 ){
            perc.add(15.9);
            perc.add(14.6);
            perc.add(17.5);
            perc.add(7.8);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(0), srok);
            BD.WriteBank(name.get(0), perc.get(0), summ1, (int)summ, srok, links.get(0));
            BD.WriteInv(name.get(0),perc.get(0), (int)monthlyPayment);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(1), srok);
            BD.WriteBank(name.get(1), perc.get(1), summ1, (int)summ, srok, links.get(1));
            BD.WriteInv(name.get(1),perc.get(1), (int)monthlyPayment);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(2), srok);
            BD.WriteBank(name.get(2), perc.get(2), summ1, (int)summ, srok, links.get(2));
            BD.WriteInv(name.get(2),perc.get(2), (int)monthlyPayment);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(3), srok);
            BD.WriteBank(name.get(3), perc.get(3), summ1, (int)summ, srok, links.get(3));
            BD.WriteInv(name.get(3),perc.get(3), (int)monthlyPayment);
        }
        else if (summ > 350000 && summ < 1000000){
            perc.add(13.5);
            perc.add(13.7);
            perc.add(16.8);
            perc.add(5.3);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(0), srok);
            BD.WriteBank(name.get(0), perc.get(0), summ1, (int)summ, srok, links.get(0));
            BD.WriteInv(name.get(0),perc.get(0), (int)monthlyPayment);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(1), srok);
            BD.WriteBank(name.get(1), perc.get(1), summ1, (int)summ, srok, links.get(1));
            BD.WriteInv(name.get(1),perc.get(1), (int)monthlyPayment);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(2), srok);
            BD.WriteBank(name.get(2), perc.get(2), summ1, (int)summ, srok, links.get(2));
            BD.WriteInv(name.get(2),perc.get(2), (int)monthlyPayment);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(3), srok);
            BD.WriteBank(name.get(3), perc.get(3), summ1, (int)summ, srok, links.get(3));
            BD.WriteInv(name.get(3),perc.get(3), (int)monthlyPayment);
        }
        else if (summ >= 1000000) {
            perc.add(12.5);
            perc.add(12.4);
            perc.add(15.3);
            perc.add(4.0);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(0), srok);
            BD.WriteBank(name.get(0), perc.get(0), summ1, (int)summ, srok, links.get(0));
            BD.WriteInv(name.get(0),perc.get(0), (int)monthlyPayment);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(1), srok);
            BD.WriteBank(name.get(1), perc.get(1), summ1, (int)summ, srok, links.get(1));
            BD.WriteInv(name.get(1),perc.get(1), (int)monthlyPayment);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(2), srok);
            BD.WriteBank(name.get(2), perc.get(2), summ1, (int)summ, srok, links.get(2));
            BD.WriteInv(name.get(2),perc.get(2), (int)monthlyPayment);
            monthlyPayment = calculateMonthlyPayment(summ, perc.get(3), srok);
            BD.WriteBank(name.get(3), perc.get(3), summ1, (int)summ, srok, links.get(3));
            BD.WriteInv(name.get(3),perc.get(3), (int)monthlyPayment);
        }

    }

}







