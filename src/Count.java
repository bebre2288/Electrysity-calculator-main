import javax.swing.*;
import java.awt.*;

public class Count extends JDialog {
    JPanel win_content;
    JLabel volts;
    JLabel ampers;
    JLabel power;
    JLabel ohms;
    boolean error=false;
    public Count(double volts_val,double ampers_val,double power_val, double ohms_val){
        try{
            if(volts_val==0){
                volts_val=(power_val==0) ? ampers_val/ohms_val : power_val/ampers_val;
            } if(ampers_val==0){
                ampers_val=(power_val==0) ? volts_val/ohms_val : power_val/volts_val;
            }
            if(power_val==0){
                power_val=(ohms_val==0) ? ampers_val*volts_val : ampers_val*ampers_val*ohms_val;
            } if(ohms_val==0){
                ohms_val = volts_val / ampers_val;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "You missed something!");
            error=true;
        }
        if(!error){
            win_content=new JPanel();
            volts=new JLabel("Volts:(U) "+volts_val);
            ampers=new JLabel("Amperes:(A) "+ampers_val);
            power=new JLabel("Power:(Wt) "+power_val);
            ohms=new JLabel("Ohms:(Om) "+ohms_val);
            setContentPane(win_content);
            setLayout(new GridLayout(4,1,3,3));
            win_content.add(volts);
            win_content.add(ampers);
            win_content.add(power);
            win_content.add(ohms);
            //win_content.add();
            pack();
            setVisible(true);
        }
    }
}
