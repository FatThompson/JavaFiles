/**
 * This program runs threads that deposit and withdraw money from the same bank
 * account.
 */
public class TreeThreadRunner
{
    public static void main(String[] args)
    {
        BST<Double> theTree = new BST<Double>();

        final int REPETITIONS = 10;
        final int THREADS = 10;

        for (int i = 1; i <= THREADS; i++)
        {
            AddToTreeRunnable d = new AddToTreeRunnable(theTree, REPETITIONS);
            RemoveFromTree w = new RemoveFromTree(theTree, REPETITIONS-1);

            Thread dt = new Thread(d);
            Thread wt = new Thread(w);

            dt.start();
            wt.start();
            if (i == THREADS)
            {
                PrintTree print = new PrintTree(wt, theTree);
                Thread pt = new Thread(print);
                pt.start();
            }

        }
    }

}
