import java.applet.Applet;  
import java.awt.Graphics;  
import java.awt.*;
public class First extends Applet{  
  
	public void paint(Graphics g){  
		g.setColor(Color.red);  
		g.drawString("Welcome",50, 50);  
		g.drawLine(20,30,20,300);  
		g.drawRect(70,100,30,30);  
		g.fillRect(170,100,30,30);  
		g.drawOval(70,200,30,30);  
		  
		g.setColor(Color.pink);  
		g.fillOval(170,200,30,30);  
		g.drawArc(90,150,30,30,30,270);  
		g.fillArc(270,150,30,30,0,180);  
  
	}
}

public class DisplayImage extends Applet {  
  
	  Image picture;  
	  
	  public void init() {  
	    picture = getImage(getDocumentBase(),"sonoo.jpg");  
	  }  
	    
	  public void paint(Graphics g) {  
	    g.drawImage(picture, 30,30, this);  
	  }  
      
}  

public class AnimationExample extends Applet {  

		Image picture;  

		public void init() {  
			picture =getImage(getDocumentBase(),"bike_1.gif");  
		}  

		public void paint(Graphics g) {  
		for(int i=0;i<500;i++){  
			  g.drawImage(picture, i,30, this);  

			  try{Thread.sleep(100);}catch(Exception e){}  
			}  
		}  
}  