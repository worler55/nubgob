import java.io.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;

public class longnubgobtest
{

  public static void playsound()
  {
    try {
         // Open an audio input stream.
         File soundFile = new File("sound.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         Clip clip = AudioSystem.getClip();
         clip.open(audioIn);
         clip.start();
         //clip.loop(clip.LOOP_CONTINUOUSLY);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
  }


  public static void main(String[] args){
    int count = 1;
    int t = 45;
    JFrame window = new JFrame("nubgob");
    int x = 0;
    int y = 0;
    playsound();
    nubgobpanel ng = new nubgobpanel(t,count);
    count++;
    window.setContentPane(ng);
    window.pack();
    window.setResizable(false);
    window.setLocation(100, 100);
    window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    window.setVisible( true );
    while(true)
    {
      System.out.println(ng.getrandnum());
      x = ng.getwin();
      if(x == 1 && count <= 6)
      {
        window.dispose();
        t = ng.getinterval();
        ng = new nubgobpanel(t,count);
        System.out.print(ng.getrandnum());
        window.setContentPane(ng);
        window.setResizable(false);
        window.setLocation(100, 100);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setVisible( true );
        count++;
      }
      if(count == 7)
      {
        int tt = ng.getinterval();
        t = -1;
        ng = new nubgobpanel(t,count);
        window.dispose();
        JOptionPane.showMessageDialog(null,"You are the winner \nYou can play on time "+Integer.toString(45-tt)+" s ","status.",JOptionPane.WARNING_MESSAGE);
        int n = JOptionPane.showConfirmDialog(null,"Do you want to play again ?","Ask",JOptionPane.YES_NO_OPTION);
        if(n == 1)
        {
          t = -1;
          ng = new nubgobpanel(t,count);
          System.exit(0);
          break;
        }
        else
        {
          t = 45;
          count = 1;
          ng = new nubgobpanel(t,count);
          System.out.print(ng.getrandnum());
          window.setContentPane(ng);
          window.setResizable(false);
          window.setLocation(100, 100);
          window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
          window.setVisible( true );
          count++;
        }

      }

    }




  }

}
