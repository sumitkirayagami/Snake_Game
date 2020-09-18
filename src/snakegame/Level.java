
package snakegame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Level extends JFrame {
    JLabel easy,med,hard;
    Level(){
        Container c=getContentPane();
        c.setBackground(Color.BLACK);
        Font fs=new Font("SANS-SERIF",Font.PLAIN,15);
        Font fl=new Font("SANS-SERIF",Font.BOLD,25);
        //Easy
        easy=new JLabel("Easy");
        easy.setFont(fs);
        easy.setBounds(135,60,100,40);
        easy.setForeground(Color.PINK);
        easy.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                SnakeGame sg=new SnakeGame(0);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) {
                easy.setFont(fl);
                easy.setBounds(125,60,150,40);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easy.setFont(fs);
                easy.setBounds(135,60,100,40);
            }

        });
        add(easy);
        //Medium
        med=new JLabel("Medium");
        med.setFont(fs);
        med.setBounds(135,160,100,40);
        med.setForeground(Color.ORANGE);
        med.addMouseListener(new MouseListener(){
           @Override
           public void mouseClicked(MouseEvent e){
               SnakeGame sg=new SnakeGame(1);
               dispose();
           }
           @Override
           public void mousePressed(MouseEvent e){}
           @Override
           public void mouseReleased(MouseEvent e){}
           @Override
           public void mouseEntered(MouseEvent e){
               med.setFont(fl);
                med.setBounds(120,160,150,40);
           }
           @Override
           public void mouseExited(MouseEvent e){
               med.setFont(fs);
                med.setBounds(135,160,100,40);
           }
        });
        add(med);
        //Hard
        hard=new JLabel("Hard");
        hard.setFont(fs);
        hard.setBounds(135,260,100,40);
        hard.setForeground(Color.RED);
        hard.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                SnakeGame sg=new SnakeGame(2);
                dispose();
            }
            @Override
            public void mouseReleased(MouseEvent e){  }
            @Override
            public void mousePressed(MouseEvent e){ }
            @Override
            public void mouseEntered(MouseEvent e){
                hard.setFont(fl);
                hard.setBounds(125,260,100,40);
            }
            @Override
            public void mouseExited(MouseEvent e){
                hard.setFont(fs);
                hard.setBounds(135,260,150,40);
            }
        });
        add(hard);

        setUndecorated(true);
        setResizable(false);
        setBounds(528,215,310,336);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        Level lv=new Level();
    }
}
