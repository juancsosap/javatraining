package Fundaments;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsClasses {

	public static void main(String[] args) {
		
		CustomFrame myFrame = new CustomFrame();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
							.getAvailableFontFamilyNames();
		
		for(String f: fonts) {
			if(f.equals("Arial Black")) {
				System.out.println(f + " available");
				break;
			}
		}

	}

}

@SuppressWarnings("serial")
class CustomFrame extends JFrame {
	public CustomFrame() {
		setTitle("Drawing");
		setSize(400,400);
		setLocation(200,200);
		// setBounds(x, y, width, height);
		CustomPanel mypanel = new CustomPanel();
		add(mypanel);
		mypanel.setBackground(SystemColor.window);
		mypanel.setForeground(Color.DARK_GRAY);
	}
}

@SuppressWarnings("serial")
class CustomPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString("Texto", 150, 25);
		g.drawRect(50, 50, 200, 200);
		g.drawLine(55, 55, 245, 245);
		g.drawRoundRect(100, 100, 100, 100, 100, 100);
		g.drawRoundRect(125, 125, 50, 50, 25, 25);
		
		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D r2d = new Rectangle2D.Double(100, 100, 200, 100); 
		g2d.draw(r2d);
		g2d.setPaint(Color.BLUE);
		g2d.fill(r2d);
		
		Ellipse2D e2d = new Ellipse2D.Double();
		e2d.setFrame(r2d);
		g2d.setPaint(Color.YELLOW.darker());
		g2d.draw(e2d);
		g2d.setPaint(new Color(100,100,100).brighter());
		g2d.fill(e2d);
		g2d.draw(new Line2D.Double(100, 100, 300, 200));
		double centerX = r2d.getCenterX();
		double centerY = r2d.getCenterY();
		double radio = 100;
		Ellipse2D c2d = new Ellipse2D.Double();
		c2d.setFrameFromCenter(centerX, centerY, centerX+radio, centerY+radio);
		g2d.draw(c2d);
		
		g2d.setFont(new Font("Arial Black", Font.BOLD, 26));
		g2d.setPaint(Color.WHITE);
		g2d.drawString("Hola", 150, 150);
		
		try {
			Image myImage1 = ImageIO.read(new URL("https://www.smashingmagazine.com/wp-content/uploads/2015/06/10-dithering-opt.jpg"));
			System.out.println("W1:" + myImage1.getWidth(null));
			System.out.println("H1:" + myImage1.getHeight(null));
			Image myImage2 = ImageIO.read(new File("src\\Fundaments\\icon.png"));
			System.out.println("W2:" + myImage2.getWidth(this));
			System.out.println("H2:" + myImage2.getHeight(this));
			g.drawImage(myImage1, 100, 200, 100, 100, null);
			g.drawImage(myImage2, 200, 200, 50, 50, null);
			g.copyArea(200, 200, 50, 50, 50, 0);
			g.copyArea(200, 200, 50, 50, 50, 50);
			g.copyArea(200, 200, 50, 50, 0, 50);
		} catch(Exception e){
			System.out.println("Error loading Image");
		}
		
	}
}
