package collab;

import java.awt.*;
import javax.swing.JFrame;
import java.util.*;

class TTT extends Canvas{
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    Canvas canvas = new TTT();
    
    canvas.setSize(600,600);
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);

    ArrayList <String []> coord = new ArrayList <String []> ();
    
    Scanner input = new Scanner(System.in);
    System.out.print("Do you want play first or second?: ");
    if (input.nextLine().equals("first")) {
      System.out.println("You are X");
    }
    else {
    	System.out.println("You are O");
    }

    String place = input.nextLine();
    //coord.add();
    
  }
    
  public void paint(Graphics g) {
    this.setBackground(Color.WHITE);
    g.setColor(Color.BLUE);
    g.drawLine(0, 200, 600, 200); // up horizontal
    g.drawLine(0, 400, 600, 400); // bottom horizontal
    g.drawLine(200, 0, 200, 600); // left vertical
    g.drawLine(400, 0, 400, 600); // right vertical
    //board();
  }
    
}
