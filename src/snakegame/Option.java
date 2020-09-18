
package snakegame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Option extends JFrame{
    JLabel gm,nwgm,quit,sc;
    String gov="Game Over",newg="New Game",quitg="Quit Game";
    Option(int score){
        Container c=getContentPane();
        c.setBackground(Color.BLACK);
        Font fb=new Font("Arial",Font.BOLD,25);
        Font fss=new Font("Arial",Font.ITALIC,15);
        Font fs=new Font("SANS-SERIF",Font.PLAIN,15);
        Font fl=new Font("SANS-SERIF",Font.BOLD,25);
        //game over
        gm=new JLabel(gov);
        gm.setFont(fb);
        gm.setForeground(Color.RED);
        gm.setBounds(90,60,getFontMetrics(fb).stringWidth(gov),40);
        add(gm);
        //Your score
        sc=new JLabel();
        sc.setFont(fss);
        sc.setForeground(Color.GREEN);
        sc.setText("Your Score is : "+score);
        sc.setBounds(100,100,150,20);
        add(sc);
        //new Game
        nwgm=new JLabel(newg);
        nwgm.setFont(fs);
        nwgm.setForeground(Color.WHITE);
        nwgm.setBounds(120,150,getFontMetrics(fs).stringWidth(newg),25);
        nwgm.addMouseListener(new  MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e){
            Level lv=new Level();
            dispose();
        }

        @Override
        public void mousePressed(MouseEvent e){}

        @Override
        public void mouseReleased(MouseEvent e){}

        @Override
        public void mouseEntered(MouseEvent e){
            nwgm.setBounds(90,150,getFontMetrics(fl).stringWidth(newg),25);
            nwgm.setFont(fl);
        }

        @Override
        public void mouseExited(MouseEvent e){
            nwgm.setBounds(120,150,getFontMetrics(fs).stringWidth(newg),25);
            nwgm.setFont(fs);
        }
        });
        add(nwgm);
        //Quit Game
        quit=new JLabel(quitg);
        quit.setFont(fs);
        quit.setForeground(Color.WHITE);
        quit.setBounds(120,225,getFontMetrics(fs).stringWidth(newg),25);
        quit.addMouseListener(new MouseListener(){
            @Override
            public void mousePressed(MouseEvent e){}
            @Override

            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }
            @Override
            public void mouseReleased(MouseEvent e){
            }
            @Override
            public void mouseEntered(MouseEvent e){
                quit.setBounds(90,225,getFontMetrics(fl).stringWidth(newg),25);
                quit.setFont(fl);
            }
            @Override
            public void mouseExited(MouseEvent e){
                quit.setBounds(120,225,getFontMetrics(fs).stringWidth(newg),25);
                quit.setFont(fs);
            }
        });
        add(quit);
        
        setUndecorated(true);
        setResizable(false);
        setBounds(528,215,310,336);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        Option opt=new Option(50);
    }
    

}
