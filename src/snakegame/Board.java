
package snakegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private int app_x,app_y,dots,dot_size;
    private boolean inGame=true;
    //private int DOT_SIZE=10;
    //private int ALL_DOTS=900;
    private Image dot,head,apple;
    private final int x[]=new int[900];
    private final int y[]=new int[900];
    private boolean up,left,right=true,down;
    private int speed ;
    private Timer timer;
    Board(int sp){
        speed=sp*30;
        setPreferredSize(new Dimension(300,300));
        setBackground(Color.BLACK);
        addKeyListener(new Tadapter()); 
        setFocusable(true);
        loadImages();
        init();
        
    } 
    public void loadImages(){
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/apple.png"));
        apple = ic.getImage();
        ic=new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/head.png"));
        head=ic.getImage();
        ic=new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/dot.png"));
        dot=ic.getImage();
    }
    public void move(){
        for(int i=dots;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        // 10 because of DOT_SIZE
        if(up)
            y[0]-=10;
        if(left) 
            x[0]-=10;
        if(down)
            y[0]+=10;
        if(right)
            x[0]+=10;
        
    }
    public void checkApple() {
        if( (app_x==x[0]) && (app_y==y[0])){
            dots++;
            locateApple();
        }
    }
    public void checkCollision(){
        if(y[0]>=300 || y[0]<0 || x[0]>=300 || x[0]<0)
            inGame=false;
        
        for(int i=dots-1 ; i>0 ; i--){
            if( (i>4) && (x[0]==x[i]) && (y[0]==y[i])){
                inGame=false;
            }
        }
        if(!inGame){
            timer.stop();
        }
    }
    public void locateApple(){
        app_x=((int)(Math.random()*29)*10);
        app_y=((int)(Math.random()*29)*10);
    }
    public void init(){
        dots=3;
        for(int i=0;i<dots;i++){
            x[i]=50-i*10;       //10 becuase of DOT_SIZE
            y[i]=50;
        }
        locateApple();
        timer=new Timer(100-speed,this);
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        if(inGame){
             g.drawImage(apple,app_x,app_y,this);
            for(int i=0;i<dots;i++){
                if(i==0){
                    g.drawImage(head,x[i],y[i],this);
                }else{
                    g.drawImage(dot,x[i],y[i],this);
                }
            }
            Toolkit.getDefaultToolkit().sync();
        }else{
            gameOver(g);
        }
    }
    public void gameOver(Graphics g){
       Option opt=new Option((dots-3)*10);
    }
    public static void main(String[] args) {
        Board brd=new Board(1);
    }

    
    class Tadapter extends KeyAdapter{
     @Override
     public void keyTyped(KeyEvent e) {
         
     }
     @Override
    public void keyPressed(KeyEvent e) {
        int key= e.getKeyCode();
         if(key==KeyEvent.VK_LEFT && (!right)){
             left=true; up=false; down=false;
         }
         if(key==KeyEvent.VK_RIGHT && !left){
             right=true; up=false; down=false;
         }
         if(key==KeyEvent.VK_UP && !down){
             right=false; left=false; up=true;
         }
         if(key==KeyEvent.VK_DOWN && !up){
             right=false; left=false; down=true;
         }
         
    }
     @Override
    public void keyReleased(KeyEvent e) {
        
    }
}

}
