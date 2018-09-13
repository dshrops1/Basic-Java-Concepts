import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArtPanel extends JPanel{

    private final int ovalWidth = 100;
    private final int ovalHeight = 100;
    private int xPoint = 0;
    private int yPoint = 0;



    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);


        g.setColor(Color.BLACK);
        g.fillOval(xPoint, yPoint, ovalWidth, ovalHeight);
    }

    class EnlargeYListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            yPoint += 10;
            repaint();


        }
    }

    class EnlargeXListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

          xPoint += 10;
          repaint();


        }
    }

    class DecreaseYListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

           yPoint -= 10;
           repaint();

        }
    }


    class DecreaseXListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

           xPoint -= 10;
           repaint();

        }
    }

}

