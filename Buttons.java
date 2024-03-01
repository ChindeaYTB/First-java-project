import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Buttons {
    public static void main(String[] args) {
        
        // JButton = GUI that works like a button

        new MyFrame();

    }
}

class MyFrame extends JFrame implements ActionListener
{   
    JButton button_break;
    JButton button_place;
    JButton button_inventory;
    static int blocks = 0;
    boolean en = false;
    MyFrame()
    {
        ImageIcon image1 = new ImageIcon("F:\\Visual Studio\\Java\\Button\\mining.png");
        ImageIcon image2= new ImageIcon("F:\\Visual Studio\\Java\\Button\\placing.png");

        button_break = new JButton();
        button_break.setBounds(0,0,100,150);
        button_break.addActionListener(this);
        //button.addActionListener(e -> System.out.println("STOP PRESSING ME!"));
        //instead of this + method
        button_break.setFocusable(false);
        button_break.setText("Break blocks");
        button_break.setIcon(image1);
        button_break.setHorizontalTextPosition(JButton.CENTER);
        button_break.setVerticalTextPosition(JButton.BOTTOM);
        button_break.setFont(new Font("Comic Sans",Font.BOLD,10));
        button_break.setBorder(BorderFactory.createEtchedBorder());

        button_place = new JButton();
        button_place.setBounds(400,0,100,150);
        button_place.addActionListener(this);
        button_place.setFocusable(false);
        button_place.setText("Place blocks");
        button_place.setIcon(image2);
        button_place.setHorizontalTextPosition(JButton.CENTER);
        button_place.setVerticalTextPosition(JButton.BOTTOM);
        button_place.setFont(new Font("Comic Sans",Font.BOLD,10));
        button_place.setBorder(BorderFactory.createEtchedBorder());

        button_inventory = new JButton();
        button_inventory.setBounds(200,415,100,50);
        button_inventory.addActionListener(this);
        button_inventory.setFocusable(false);
        button_inventory.setText("Inventory");
        button_inventory.setHorizontalTextPosition(JButton.CENTER);
        button_inventory.setVerticalTextPosition(JButton.TOP);
        button_inventory.setFont(new Font("Comic Sans",Font.BOLD,10));
        button_inventory.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(515,500);
        this.setVisible(true);
        this.add(button_break);
        this.add(button_place);
        this.add(button_inventory);
        this.setTitle("Minecraft at home");
        this.getContentPane().setBackground(new Color(0x0fa812));

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button_break)
        {
            System.out.println("You mined a block! +1 Block");
            blocks++;
            if(en==false)   
            {button_place.setEnabled(true);
            en=true;
            }
        }
        if(e.getSource()==button_place)
        {
            if(blocks==0)
            {System.out.println("You don't have any blocks left!");
            button_place.setEnabled(false);
            en=false;
            }
            else
            {System.out.println("You placed a block! -1 Block");
            blocks--;
            }
        }
        if(e.getSource()==button_inventory)
        {
            new Inventory();
        }
    }
}

class Inventory extends JFrame implements ActionListener
{   static boolean inv = false;
    JButton exit_inv;
    Inventory()
    {
        JLabel block = new JLabel();

        block.setText("You have "+ MyFrame.blocks+ " blocks in your inventory.");
        block.setBounds(150,300,215,20);
        block.setVisible(true);
        block.setForeground(Color.green);
        block.setLayout(new BorderLayout());

        exit_inv = new JButton();
        exit_inv.setBounds(385,430,120,40);
        exit_inv.addActionListener(this);
        exit_inv.setFocusable(false);
        exit_inv.setText("Close inventory!");
        exit_inv.setHorizontalTextPosition(JButton.CENTER);
        exit_inv.setVerticalTextPosition(JButton.CENTER);
        exit_inv.setVerticalAlignment(JButton.TOP);
        exit_inv.setFont(new Font("Comic Sans",Font.BOLD,10));
        exit_inv.setBorder(BorderFactory.createEtchedBorder());
        exit_inv.setLayout(new BorderLayout());

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setSize(515,500);
        this.setVisible(true);
        this.setTitle("Inventory");
        this.getContentPane().setBackground(new Color(0x454b52));
        this.add(block);
        this.add(exit_inv);
        
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==exit_inv)
        {
            this.dispose();
        }
    }

}