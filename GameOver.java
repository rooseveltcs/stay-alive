import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel{
   
   private int score ;
   private Image image = new ImageIcon(this.getClass().getResource("GameOverBackground.png")).getImage();   
   public GameOver(int score){
      setBackground(new Color(98,44,12));
      setFocusable(true);
      setBounds(145,200,400,300);  //size of the GamveOver Panel
      this.score = score;
      setLayout(null);
   }
   
   public void paintComponent(Graphics g){
     super.paintComponent(g);
     g.drawImage(image,0,0,this);
     
     g.setColor(Color.WHITE);
     g.setFont(new Font("Algerian", Font.PLAIN, 50)); 
     int gOW = g.getFontMetrics().stringWidth("GAME OVER!");
     g.drawString("GAME OVER!" ,(400/2)-(gOW/2),95);
     
    
     g.setFont(new Font("Arial", Font.PLAIN, 30));
     String scoreLine = "Your Score: "+score;
     int w = g.getFontMetrics().stringWidth(scoreLine); 
     g.drawString(scoreLine, (400/2)-(w/2),150);
     
     
     g.setFont(new Font("Arial", Font.PLAIN, 20)); 
     int restart = g.getFontMetrics().stringWidth("Click twice to restart!");
     g.drawString("Click twice to restart!" ,(400/2)-(restart/2),230); 
     
   }

  
}      
      