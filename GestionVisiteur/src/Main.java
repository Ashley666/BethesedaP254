import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
//w  ww .  ja v  a  2  s . c o m
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

public class Main {
 
	public static void main(String[] args) {
	    
		SplashScreen splashScreen = new SplashScreen();
	    splashScreen.setLocationRelativeTo(null);
	        
    }
}

class SplashScreen extends JWindow {
	
	static JProgressBar progressBar = new JProgressBar();
	static int count = 1, TIMER_PAUSE = 25, PROGBAR_MAX = 100;
  	static Timer progressBarTimer;
  
  ActionListener al = new ActionListener() {
	    
	  public void actionPerformed(java.awt.event.ActionEvent evt) {
	      progressBar.setValue(count);
	      if (PROGBAR_MAX == count) {
	        progressBarTimer.stop();
	        SplashScreen.this.setVisible(false);
	        createAndShowFrame();
	      }
	      count++;
	    }
	  
  };

  public SplashScreen() {
	    
	    Container container = getContentPane();
	
	    JPanel panel = new JPanel();
	    panel.setBorder(new EtchedBorder());
	    container.add(panel, BorderLayout.CENTER);
	
	    JLabel label = new JLabel(new ImageIcon("photo/logo/test.jpg"));
	    panel.setBackground(Color.white);
	    panel.add(label);
	
	    progressBar.setMaximum(PROGBAR_MAX);
	    container.add(progressBar, BorderLayout.SOUTH);
	    pack();
	    setVisible(true);
	    startProgressBar();
  }
  
  private void startProgressBar() {
  
	  progressBarTimer = new Timer(TIMER_PAUSE, al);
	  progressBarTimer.start();
	  
  }
  
  private void createAndShowFrame() {
	   
	  //appelation de notre fenere apres le splachscreen
	  Fenetre fen = new Fenetre();
	  
  }
}