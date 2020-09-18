/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class SnakeGame extends JFrame{

    SnakeGame(int sp){
        Board br=new Board(sp);
        add(br);
        pack();
        setLocationRelativeTo(null);                                     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/snake.PNG"));
        Image img=ic.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        setIconImage(img);
        setTitle("Snake Game");
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        SnakeGame sg=new SnakeGame(1);
    }
    
}
