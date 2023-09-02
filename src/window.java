import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;



public class window extends JFrame implements WindowListener, ActionListener {

    private JButton ButtonFinance = new JButton("Рассчитать объём финансирования.");
    private JButton ButtonInvest = new JButton("Подобрать.");
    private JButton ButtonPaste = new JButton("Внести исходные данные");
    private JLabel labeldoxod = new JLabel("Прогнозируемые денежные потоки: ");
    private JLabel labeldis = new JLabel("Ставки дисконтирования: ");
    private JLabel labesrok = new JLabel("Срок реализации (лет): ");
    private JLabel labecompany = new JLabel("Объём свободного капитала: ");
    private JLabel labefinance1 = new JLabel("Объём финансирования DCF: ");
    private JLabel labefinance2 = new JLabel("Объём финансирования WACC: ");
    private JLabel labeinv = new JLabel("Список доступных инвесторов: ");
    private TextField textsrok = new TextField();
    private TextField textkap = new TextField();
    private TextField textob1 = new TextField();
    private TextField textob2 = new TextField();
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModel2;
    private DefaultTableModel tableModel3;


    public window() throws SQLException {
        setLayout(null);
        setSize(800, 620);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(700, 250);
        addWindowListener(this);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Доход: ");
        JTable tabledeneg = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabledeneg);
        add(scrollPane);

        tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("Ставки дисконтирования: ");
        JTable tableperc = new JTable(tableModel2);
        JScrollPane scrollPanesecond = new JScrollPane(tableperc);
        add(scrollPanesecond);

        tableModel3 = new DefaultTableModel();
        tableModel3.addColumn("Наименование банка: ");
        tableModel3.addColumn("Процентная ставка: ");
        tableModel3.addColumn("Ежемесячный платёж: ");
        JTable tableinv = new JTable(tableModel3);
        JScrollPane scrollPanethree = new JScrollPane(tableinv);
        add(scrollPanethree);

        ButtonPaste.setSize(450,50);
        ButtonPaste.setLocation(0,0);
        ButtonPaste.setVisible(true);
        ButtonPaste.addActionListener(this);
        add(ButtonPaste);

        labeinv.setSize(450,50);
        labeinv.setLocation(530,0);
        labeinv.setVisible(true);
        add(labeinv);

        labeldoxod.setSize(225, 50);
        labeldoxod.setLocation(0,50);
        labeldoxod.setVisible(true);
        add(labeldoxod);

        labeldis.setSize(225,50);
        labeldis.setLocation(300,50);
        labeldis.setVisible(true);
        add(labeldis);

        tabledeneg.setSize(225,150);
        tabledeneg.setLocation(0,100);
        tabledeneg.setVisible(true);
        add(tabledeneg);

        tableperc.setSize(225,150);
        tableperc.setLocation(260,100);
        tableperc.setVisible(true);
        add(tableperc);

        tableinv.setSize(270, 420);
        tableinv.setLocation(500,100);
        tableinv.setVisible(true);
        add(tableinv);

        labesrok.setSize(225,50);
        labesrok.setLocation(0,300);
        labesrok.setVisible(true);
        add(labesrok);

        textsrok.setSize(200,30);
        textsrok.setLocation(250,310);
        textsrok.setVisible(true);
        add(textsrok);

        labecompany.setSize(225,50);
        labecompany.setLocation(0,350);
        labecompany.setVisible(true);
        add(labecompany);

        textkap.setSize(200,30);
        textkap.setLocation(250,360);
        textkap.setVisible(true);
        add(textkap);

        labefinance1.setSize(220,50);
        labefinance1.setLocation(0,400);
        labefinance1.setVisible(true);
        add(labefinance1);

        textob1.setSize(200,30);
        textob1.setLocation(250,410);
        textob1.setVisible(true);
        add(textob1);

        labefinance2.setSize(200,50);
        labefinance2.setLocation(0,450);
        labefinance2.setVisible(true);
        add(labefinance2);

        textob2.setSize(200,30);
        textob2.setLocation(250,460);
        textob2.setVisible(true);
        add(textob2);

        ButtonFinance.setSize(450,50);
        ButtonFinance.setLocation(0,530);
        ButtonFinance.setVisible(true);
        ButtonFinance.addActionListener(this);
        add(ButtonFinance);

        ButtonInvest.setSize(330,50);
        ButtonInvest.setLocation(460,530);
        ButtonInvest.setVisible(true);
        ButtonInvest.addActionListener(this);
        add(ButtonInvest);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> values = new ArrayList<>();
        List<String> values2 = new ArrayList<>();
        List<String> values3 = new ArrayList<>();
        conn f = new conn();
        db f1 = new db();
        FinanceCalculator F = new FinanceCalculator();
        Banks F1;
        F1 = null;
        db F2 = new db();
        if (e.getSource()==ButtonPaste){
            int srk = 0;
            double com = 0;
            try {
                f.Conn();
                srk = f1.maint();
                com = f1.mainfr();
                f.getBDDoxodValues(values);
                for (String data : values) {
                    tableModel.addRow(new Object[]{data});
                }
                f.getBDDisValues(values2);
                for (String data : values2) {
                    tableModel2.addRow(new Object[]{data});
                }

            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            textsrok.setText(String.valueOf(srk));
            textkap.setText(String.valueOf(com));
        }
        if (e.getSource()==ButtonFinance){
            double summ1 = 0;
            double summ2 = 0;
            try {
                f.Conn();
                F.main();
                summ1 = F2.maivndox1();
                summ2 = F2.maivndox2();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            textob1.setText(String.valueOf(summ1));
            textob2.setText(String.valueOf(summ2));

        }
        if (e.getSource()==ButtonInvest){
            try {
                Banks.main();
                f.Conn();
                values.clear();
                values2.clear();
                values3.clear();
                f.getnamebankValues(values);
                f.getperValues(values2);
                f.getvznosValues(values3);
                tableModel3.addRow(new Object[]{"Банк", "Ставка", "Платёж"});
                int size = Math.min(Math.min(values.size(), values2.size()), values3.size());
                for (int i = 0; i < size; i++) {
                    String data1 = values.get(i);
                    String data2 = values2.get(i);
                    String data3 = values3.get(i);
                    tableModel3.addRow(new Object[]{data1, data2, data3});
                }
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {


    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}






