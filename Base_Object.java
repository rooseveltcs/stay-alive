import java.awt.*;

//Base_object class standard information for all objects
public class Base_Object{
   
   int x, y, h,w;
   Image image;
   
   public Base_Object(){
      //Randomize the coordinates
      this.x = (int)(Math.random()*600)+1;
      this. y= (int)(Math.random()*470)+50;
      if(y+h >700){
         y-=(h+50);;
      }
      else if(x+w>700){
         x-=(w+50);
      }
   }
   
   public int getX(){
      return this.x;
   }
   
   public int getY(){
      return this.y;
   }
   
   public int getH(){
      return this.h;
   }
   
   public Image getImage(){
      return this.image;
   }

//Take in coordinates and size of the player iamge, test weather or noth this corssed over with it
//Return trueif touched   
   public boolean test(int pX , int pY, int pW , int pH, int adj){  //+ = top and left
                                                                    //- = right and bot
   
      if((pX == x+w-adj || pX+pW == x+adj) && ((pY+pH>=y+adj && pY+pH<=y+h-adj) || (pY>=y+5 &&pY<=y+h-adj))){
         return true;
      
      }
      else if((pY == y+h-adj || pY+pH == y+adj) && ((pX+pW>=x+adj && pX+pW<=x+w-adj)  || (pX>=x+5 &&pX<=x+w-adj))){
         return true;
      }
      else{
         return false;
      }
   }            
}