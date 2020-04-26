import java.awt.*;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class RandomStringsPanel extends JPanel {
    private String name;
    private int randnum;
    private String backgroudImage;
    int[][] di;
    private int count;
    public RandomStringsPanel(int count) {
        this.randnum = getRandomNumberInRange(10,20);
        this.count=count;
        System.out.println("count from r => "+this.count);
        this.di = new int[this.randnum][2];
        for(int i=0;i<this.randnum;i++)
        {
          this.di[i][0] = 0;
          this.di[i][1] = 0;
        }
        setDi();
    }

    public int getrandnum()
    {
      return randnum;
    }


    private int getRandomNumberInRange(int min, int max) {

		  if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
    randnum = r.nextInt((max - min) + 1) + min;
		return randnum;
	}

    public void setDi()
    {
      int width = 560;
      int height = 250;
      for (int i = 0; i < this.randnum ; i++) {
          int x,y;
          x = -50 + (int)(Math.random()*(width+40));
          y = (int)(Math.random()*(height+20));
          this.di[i][0] = x;
          this.di[i][1] = y;
      }
          // Draw the message.

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon backgroundImage = new ImageIcon(new ImageIcon("pok.png").getImage().getScaledInstance(600, 330, Image.SCALE_DEFAULT));
        backgroundImage.paintIcon(this,g,0,0);

        if(this.count==1)
        {
          this.name="gob.png";
        }
        else if (this.count==2)
        {
            this.name="gob5.png";
        }
        else if (this.count==3)
        {
            this.name="gob6.png";
        }
        else if (this.count==4)
        {
            this.name="gob3.png";
        }
        else if (this.count==5)
        {
            this.name="gob4.png";
        }

        for (int i = 0; i < this.randnum ; i++) {
            ImageIcon ic = new ImageIcon(new ImageIcon(this.name).getImage().getScaledInstance(90, 100, Image.SCALE_DEFAULT));
            ic.paintIcon(this,g,di[i][0]+2,di[i][1]+2);

        } // end for
    } // end paintComponent()


}
