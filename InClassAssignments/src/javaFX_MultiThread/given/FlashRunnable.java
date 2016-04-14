package javaFX_MultiThread.given;
import javafx.scene.Node;
import javafx.application.Platform;

/**
 * This Runnable class accepts a Java Node component and flashes it.
 * @author cjohns25
 *
 */
public class FlashRunnable implements Runnable
{
    private Node component;
    private int timeToSleep;
    private boolean visible;
    public FlashRunnable(Node flasher, int milliseconds)
    {
      component = flasher;
      timeToSleep = milliseconds;
      visible = true;
    }
    
    
    @Override
    public void run()
    {
          try
          {
              while (true)
              {
                  Thread.sleep(timeToSleep);
                  if (visible)
                  {
                      visible = false;
                      // make node invisible
                    
                  }
                  else
                  {
                      visible = true;
                  
                  }
                  Platform.runLater(new Runnable() {
                      @Override 
                      public void run() {
                        component.setVisible(visible);
                      }
                    });
          
              }
          }
          catch (InterruptedException ex)
          {
              // do nothing and exit gracefully
          }
    }
}
