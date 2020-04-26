
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.io.File;

public class nubgobpanel extends JPanel {

  int E;
  int win = 0;
  int play = 0;
  JTextField txt;
  static int interval;
  static Timer timer;
  JLabel tim ;
  private int count;
  RandomStringsPanel board;
  public nubgobpanel(int t,int count) {
        setBackground( new Color(0,200,245) );
        setLayout( new BorderLayout(3, 3) );
        this.count=count;
        board = new RandomStringsPanel(this.count);
        //System.out.print(board.getrandnum());
        board.setForeground( Color.RED );
        board.setPreferredSize( new Dimension(600,330) );
        add(board, BorderLayout.CENTER);
        int w=0;
        interval = t;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground( new Color(220, 200, 180) );
        buttonPanel.setPreferredSize( new Dimension(600,50) );
        tim = new JLabel("Countdown time = "+Integer.toString(interval));
        buttonPanel.add(tim);
        txt = new JTextField();
        txt.setPreferredSize( new Dimension(100,40) );
        txt.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                    try{
                      E=Integer.parseInt(txt.getText());
                      if(E==board.getrandnum())
                      {
                        // yes = o and no = 1
                          txt.setText("");
                          timer.cancel();
                          JOptionPane.showMessageDialog(null,"It's correct.","Win.",JOptionPane.WARNING_MESSAGE);
                          win = 1;

                      }
                      else
                      {
                        txt.setText("");
                        JOptionPane.showMessageDialog(null,"It's not correct.","Try again.",JOptionPane.WARNING_MESSAGE);
                      }
                    }
                    catch (Exception ex) {
                      JOptionPane.showMessageDialog(null,"Enter only number.","Trick.",JOptionPane.WARNING_MESSAGE);
                    }
                }});
        buttonPanel.add(txt);
        add(buttonPanel, BorderLayout.SOUTH);
        setBorder(BorderFactory.createLineBorder( new Color( 0,200,245), 3) );
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                //System.out.println(setInterval());
                setInterval();
                tim.setText("Countdown time = "+Integer.toString(interval));
                if(interval == 0)
                {
                  System.exit(0);
                }
            }
        },delay, period);
    }

    public int getinterval()
    {
      return this.interval;
    }

    private static final int setInterval() {
        if (interval == 1)
        {

          timer.cancel();
          JOptionPane.showMessageDialog(null,"You lose,Time out","status.",JOptionPane.WARNING_MESSAGE);
        }


        return --interval;
    }

    public int getrandnum()
    {
      return board.getrandnum();
    }
    public int getwin()
    {
      
      return this.win;
    }
    public int getplay()
    {
      return this.play;
    }

  }
