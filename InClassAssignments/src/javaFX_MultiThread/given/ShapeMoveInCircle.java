package javaFX_MultiThread.given;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

public class ShapeMoveInCircle implements Runnable
{
    private double x;
    private double y;
    private double radius;
    private ImageView shape;
    private int timeBetweenMoves;

    public ShapeMoveInCircle(ImageView s, double r, int time)
    {
        shape = s;
        radius = r;
        timeBetweenMoves = time;

    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {

                // move one degree around the radius
                for (int f = 0; f < 360; f++)
                {
                    Thread.sleep(timeBetweenMoves);
                    x = Math.sin(Math.toRadians((double) f)) * radius;
                    y = Math.cos(Math.toRadians((double) f)) * radius;
//System.out.println("X = " + x + " Y = " + y);
                    // schedule shape at new position
                    // launch a Java FX update thread
                    Platform.runLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            shape.setX(x + 250);
                            shape.setY(y + 250);
                        }
                    });

                }
            }
        } catch (InterruptedException ex)
        {
            // do nothing just stop moving the shape
        }

    }

}
