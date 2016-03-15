package MultiThreading;
public class PrintTree implements Runnable
{
    // last thread
    Thread wt;
    BST<Double> aTree;

    public PrintTree(Thread lastThread, BST<Double> theTree)
    {
        wt = lastThread;
        aTree = theTree;
    }

    @Override
    // this thread waits for last withdrawal thread to die and then prints tree contents.
    public void run()
    {
        try
        {
            // wait for last withdrawal thread to die
            while (wt.isAlive())
            {
                Thread.sleep(1000);
            }
            System.out.println("The tree contains");
            aTree.inorder();

        } catch (InterruptedException exception)
        {
        }
    }

}