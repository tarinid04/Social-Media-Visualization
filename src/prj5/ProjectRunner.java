package prj5;

import java.io.IOException;

// -------------------------------------------------------------------------
/**
 * Project Runner class for project 5 passes argument main method to read and
 * process file and displays it to the console or shows in the GUI
 *
 * @author Sajni Potter (sajni)
 * @version 15 Nov 2023
 * @author Tarini Duvvuri (tarinid)
 * @version 18 Nov 2023
 */
public class ProjectRunner
{

    public static void main(String[] args)
        throws IOException
    {

        boolean showConsole = true;
        boolean showGUI = true;

        InputFileReader filer;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }

        // Prints to console when true
        if (showConsole)
        {
            filer.printInfluencerSummaries();
        }

        // displays GUI when true
        if (showGUI)
        {

            new GUI(filer.getInfluencers());
        }

    }

}
