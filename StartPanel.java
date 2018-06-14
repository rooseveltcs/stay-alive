import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel{
   
   private int score ;
   private Image fireImageS = new ImageIcon(this.getClass().getResource("fire.png")).getImage();
   private int w = fireImageS.getWidth(null);
   private int h = fireImageS.getHeight(null);
   private Image fireImageM = fireImageS.getScaledInstance(w*2, h*2, Image.SCALE_DEFAULT);
   private Image fireImageL = fireImageS.getScaledInstance(w*3, h*3, Image.SCALE_DEFAULT);
     
   public StartPanel(){
      setBackground(Color.BLACK);
      setFocusable(true);
      setBounds(0,30,690,670);  //size of the GamveOver Panel
      setLayout(null);
   }
   
   public void paintComponent(Graphics g){
     super.paintComponent(g);
     
     g.setColor(Color.WHITE);
     g.setFont(new Font("Algerian", Font.PLAIN, 90));
     String title = "Stay Alive!";
     int titleLength = g.getFontMetrics().stringWidth(title); 
     g.drawString(title, (690/2)-(titleLength/2),150);
     
     g.drawImage(fireImageS,(690/2)-(w*4)+10,260,this);
     g.drawImage(fireImageS,(690/2)+(w*3-10),260,this);
     
     g.drawImage(fireImageM,(690/2)-(w*3),230,this);
     g.drawImage(fireImageM,(690/2)+(w),230,this);
     
     g.drawImage(fireImageL,(690/2)-(w*3/2),210,this);
     
     g.setColor(Color.WHITE);
     g.setFont(new Font("Arial", Font.BOLD, 30)); 
     int startLine = g.getFontMetrics().stringWidth("Click to Start!");
     g.drawString("Click to Start!" ,(690/2)-(startLine/2),500);    
   }

  
}      
  