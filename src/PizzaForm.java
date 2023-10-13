import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class PizzaForm extends JFrame {
    JPanel mainPnl;

    JPanel crustPnl;
        JRadioButton thinRdo;
        JRadioButton RegularRdo;
        JRadioButton DeepRdo;
        ButtonGroup crustGrp;


    JPanel sizePnl;
        JComboBox sizeBox;

    JPanel recieptPnl;
        JTextArea recieptTA;


    JPanel toppingPnl;
        JCheckBox cheeseChk;
        JCheckBox pepChk;
        JCheckBox sausageChk;
        JCheckBox BBQChk;
        JCheckBox mushroomChk;
        JCheckBox spinachChk;


    JPanel controlPnl;
        JButton orderBtn;
        JButton clearBtn;
        JButton quitBtn;


    public PizzaForm(){

        mainPnl = new JPanel();
        mainPnl.setLayout(new BoxLayout(mainPnl,BoxLayout.Y_AXIS));
        addCrustPnl();
        addSizePnl();
        addToppingsPnl();
        addRecieptPnl();
        addControlPnl();

        mainPnl.setVisible(true);
        this.add(mainPnl);


    }

   private void addCrustPnl(){
        crustPnl = new JPanel();
        crustPnl.setBorder(BorderFactory.createTitledBorder("Choose Your Crust"));
        thinRdo = new JRadioButton("Thin");
        RegularRdo = new JRadioButton("Regular");
        DeepRdo = new JRadioButton("Deep-Dish");
        crustGrp = new ButtonGroup();
        crustGrp.add(thinRdo);
        crustGrp.add(RegularRdo);
        crustGrp.add(DeepRdo);
        crustPnl.add(thinRdo);
        crustPnl.add(RegularRdo);
        crustPnl.add(DeepRdo);
        mainPnl.add(crustPnl);
        crustPnl.setVisible(true);


    }

    private void addSizePnl(){
        String sizes[] = {"Small","Medium","Large","Super"};
        sizeBox = new JComboBox(sizes);
        sizePnl = new JPanel();
        sizePnl.setBorder(BorderFactory.createTitledBorder("Choose Size of Pizza"));
        sizePnl.add(sizeBox);
        mainPnl.add(sizePnl);
        sizePnl.setVisible(true);

    }

    private void addRecieptPnl(){

        recieptPnl = new JPanel();
        recieptPnl.setBorder(BorderFactory.createTitledBorder("Receipt"));
        recieptTA = new JTextArea(20,30);
        recieptPnl.add(recieptTA);
        mainPnl.add(recieptPnl);
        recieptPnl.setVisible(true);


    }

    private void addControlPnl(){
        clearBtn = new JButton("Clear");
        orderBtn = new JButton("Order");
        quitBtn = new JButton("Quit");
        controlPnl = new JPanel();
        controlPnl.setBorder(BorderFactory.createTitledBorder("Options"));
        //controlPnl.setLayout(new BoxLayout(controlPnl,BoxLayout.X_AXIS));
        controlPnl.add(clearBtn);
        controlPnl.add(orderBtn);
        controlPnl.add(quitBtn);
        mainPnl.add(controlPnl);
        controlPnl.setVisible(true);


        orderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numToppings = 0;
                double total = 0;
                DecimalFormat myFormat = new DecimalFormat("00.00");

                //one line = 42
                //crust type = 15
                //size = 8

                recieptTA.append("==========================================\n");
                if(thinRdo.isSelected()){recieptTA.append(
                                 "Thin Crust------");}
                else if(RegularRdo.isSelected()){recieptTA.append(
                                 "Regular Crust-"
                );}
               else if(DeepRdo.isSelected()){recieptTA.append(
                                 "Deep-Dish-----");}

               if(sizeBox.getSelectedItem().equals("Small")){total+=8;
                   recieptTA.append("Small                                                  $8.00\n\n");}
               else if (sizeBox.getSelectedItem().equals("Medium")) {total+=12;
                   recieptTA.append("Medium                                              $12.00\n\n");}
               else if (sizeBox.getSelectedItem().equals("Large")) {total+=16;
                   recieptTA.append("Large                                                $16.00\n\n");}
               else if (sizeBox.getSelectedItem().equals("Super")) {total+=20;
                   recieptTA.append("Super                                                $20.00\n\n");}

                if(pepChk.isSelected()){total++;
                recieptTA.append("Pepperoni                                                                   $1.00\n");}
                if(sausageChk.isSelected()){total++;
                recieptTA.append("Sausage                                                                     $1.00\n");}
                if(spinachChk.isSelected()){total++;
                recieptTA.append("Spinach                                                                      $1.00\n");}
                if(BBQChk.isSelected()){total++;
                recieptTA.append("BBQ Sauce                                                                $1.00\n");}
                if(cheeseChk.isSelected()){total++;
                recieptTA.append("Extra Cheese                                                             $1.00\n");}
                if(mushroomChk.isSelected()){total++;
                recieptTA.append("Mushrooms                                                                $1.00\n");}

                recieptTA.append("\nSubtotal                                                                       $"+myFormat.format(total)+"\n");
                recieptTA.append("Tax                                                                              $"+ myFormat.format(total*.07)+"\n");
                recieptTA.append("==========================================\n");
                recieptTA.append("Total                                                                            $"+myFormat.format(total*1.07));
            }
        });

        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice =JOptionPane.showConfirmDialog(null,"Do you want to quit?");
                if (choice == 0){
                    System.exit(0);
                }
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BBQChk.setSelected(false);
                pepChk.setSelected(false);
                cheeseChk.setSelected(false);
                spinachChk.setSelected(false);
                sausageChk.setSelected(false);
                mushroomChk.setSelected(false);

                sizeBox.setSelectedItem("Small");

                crustGrp.clearSelection();

                recieptTA.setText("");
            }
        });

    }

    private void addToppingsPnl(){

        BBQChk = new JCheckBox("BBQ Sauce");
        pepChk = new JCheckBox("Pepperoni");
        cheeseChk = new JCheckBox("Extra Cheese");
        spinachChk = new JCheckBox("Spinach");
        mushroomChk = new JCheckBox("Mushrooms");
        sausageChk = new JCheckBox("Sausage");

        toppingPnl = new JPanel();

        toppingPnl.setBorder(BorderFactory.createTitledBorder("Choose Additional Toppings"));
        toppingPnl.setLayout(new GridLayout(2,3));
        toppingPnl.add(pepChk);
        toppingPnl.add(cheeseChk);
        toppingPnl.add(mushroomChk);
        toppingPnl.add(BBQChk);
        toppingPnl.add(spinachChk);
        toppingPnl.add(sausageChk);

        mainPnl.add(toppingPnl);
        toppingPnl.setVisible(true);



    }

}
