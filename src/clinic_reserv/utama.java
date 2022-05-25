package clinic_reserv;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class utama {

    private JLabel labelsat;
    private JPanel panelKed;
    private JButton kembaliButton;
    private JButton okeButton;
    private JLabel labelut;
    private JComboBox comboBoxTgl;
    private JTextField textFieldTgl;
    private JLabel labelErr;
    private JComboBox comboBoxShi;
    private JTextField textFieldWakt;
    private JTextArea textAreaInfo;

    String Nama ;
    String sap;
    static String dtg;
    static int antrean;
    static int antrean1;
    static int antrean2;


    utama(){

        JFrame fram = new JFrame("lanjotan");
        fram.setVisible(true);
        fram.setContentPane(panelKed);
        fram.setDefaultCloseOperation(3);
        fram.setSize(550,430);
        fram.setLocationRelativeTo(null);
        Nama = depan.nama;
        sap = depan.sapa;

        labelut.setText("Halo "+ sap +" "+ Nama );
        labelut.setVisible(false);

        textAreaInfo.setText(" Jam Pelayanan :\n Shift Pagi = 08.00 s.d. 11.30 WIB\n Shift Sore = 14.00 s.d. 17.30 WIB");

        labelErr.setText("*Data Anda belum lengkap");
        labelErr.setVisible(false);

        LocalDate tgl = LocalDate.now();
        LocalDate bsk = tgl.plusDays(1);
        LocalDate lusa = tgl.plusDays(2);
        DateTimeFormatter ubah = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String tgl2 = tgl.format(ubah);
        String bsk2 = bsk.format(ubah);
        String lusa2 = lusa.format(ubah);

        comboBoxTgl.setSelectedIndex(-1);
        comboBoxTgl.setFocusable(false);
        comboBoxShi.setSelectedIndex(-1);
        comboBoxShi.setFocusable(false);
        Random rand = new Random();

        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fram.dispose();
                depan.frm.setVisible(true);
            }
        });
        comboBoxTgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxTgl.getSelectedIndex() == 0){
                    textFieldTgl.setText(tgl2);
                } else if (comboBoxTgl.getSelectedIndex() == 1){
                    textFieldTgl.setText(bsk2);
                } else if (comboBoxTgl.getSelectedIndex() == 2){
                    textFieldTgl.setText(lusa2);
                }
            }
        });
        okeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxTgl.getSelectedIndex() == -1 || comboBoxShi.getSelectedIndex() == -1){
                    labelErr.setVisible(true);
                } else {
                    new akhir();
                    fram.dispose();
                }
            }
        });
        comboBoxShi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxShi.getSelectedIndex() == 0){
                    textFieldWakt.setText("08.00 s.d. 11.30 WIB");

                    antrean1 = rand.nextInt(40) + 1;
                    antrean = antrean1;
                    if (antrean1 <= 10){dtg = "08.00";
                    } else if (antrean1 <= 20){dtg = "09.00";}
                    else if (antrean1 <= 30){dtg = "10.00";}
                    else if (antrean1 <= 40){dtg = "11.00";}

                } else if (comboBoxShi.getSelectedIndex() == 1){
                    textFieldWakt.setText("14.00 s.d. 17.30 WIB");

                    antrean2 = rand.nextInt(40) + 1;
                    antrean = antrean2;
                    if (antrean2 <= 10){dtg = "14.00"; }
                    else if (antrean2 <= 20){dtg = "15.00";}
                    else if (antrean2 <= 30){dtg = "16.00";}
                    else if (antrean2 <= 40){dtg = "17.00";}
                }
            }
        });
    }

}
