/*
* Basic example of an event listener
* we are going to have a simple GUI with four buttons that
* allow the user to change the position of a oval that is drawn on the screen
*
* so we will need a JPanel that we overide the paintComponent on and have some
* action listners for repaints that we apply so it will need to implement the ActionListener interface
 */

import javax.swing.*;
import java.awt.*;

public class BasicEventListener extends JFrame {

   private BasicEventListener(){

       setSize(600,600);
       setLocationRelativeTo(null);
       setTitle("basic events");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       LayoutManager splitHorizontal = new BorderLayout();
       setLayout(splitHorizontal);
       ArtPanel myPanel = new ArtPanel();
       myPanel.setPreferredSize(new Dimension(600,300));
       add(myPanel, BorderLayout.NORTH);


       JButton increaseX = new JButton("X+");
       JButton increaseY = new JButton("Y+");
       JButton decreaseX = new JButton("X-");
       JButton decreaseY = new JButton("Y-");

       increaseX.addActionListener(myPanel.new EnlargeXListener());
       increaseY.addActionListener(myPanel.new EnlargeYListener());
       decreaseY.addActionListener(myPanel.new DecreaseYListener());
       decreaseX.addActionListener(myPanel.new DecreaseXListener());


       JPanel buttonPanel = new JPanel();
       add(buttonPanel, BorderLayout.SOUTH);
       LayoutManager buttonLayout = new FlowLayout();
       buttonPanel.setLayout(buttonLayout);


      buttonPanel.add(increaseX);
      buttonPanel.add(increaseY);
      buttonPanel.add(decreaseX);
      buttonPanel.add(decreaseY);


       pack();
   }



    public static void main(String args[]){

       BasicEventListener screen = new BasicEventListener();

       screen.setVisible(true);



    }
}
