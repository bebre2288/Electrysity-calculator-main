import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    JPanel win_content;
    JLabel volts;
    JLabel ampers;
    JLabel power;
    JLabel ohms;
    DoubleSpinner volts_val;
    DoubleSpinner ampers_val;
    DoubleSpinner power_val;
    DoubleSpinner ohms_val;
    JButton ok;
    public Main(){
        win_content=new JPanel();
        volts=new JLabel("Volts:(U)");
        ampers=new JLabel("Amperes:(A)");
        power=new JLabel("Power:(Wt)");
        ohms=new JLabel("Ohms:(Om)");
        volts_val=new DoubleSpinner();
        ampers_val=new DoubleSpinner();
        power_val=new DoubleSpinner();
        ohms_val=new DoubleSpinner();
        ok=new JButton("OK");
        setContentPane(win_content);
        setLayout(new GridLayout(5,2,3,3));
        win_content.add(volts);
        win_content.add(volts_val);
        win_content.add(ampers);
        win_content.add(ampers_val);
        win_content.add(power);
        win_content.add(power_val);
        win_content.add(ohms);
        win_content.add(ohms_val);
        win_content.add(ok);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Count(volts_val.getDouble(),ampers_val.getDouble(),power_val.getDouble(),ohms_val.getDouble());
            }
        });
    }
    public static void main(String[] args) {
        new Main();
    }
}
