package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FileReader class reads input data from a file and initializes Influencers and
 * their posts.
 *
 * @author Tarini Duvvuri(tarinid)
 * @version 18 Nov 2023
 * @author Sajni Potter (sajni)
 * @version 30 Nov 2023
 */
public class InputFileReader
{

    private DoublyLinkedList<Influencer> influencers;
    private int size;

    /**
     * Creates a new FileReader.
     *
     * @param fileName
     *            the file path
     * @throws FileNotFoundException
     *             if the file path is incorrect
     */
    public InputFileReader(String fileName)
        throws FileNotFoundException
    {
        influencers = new DoublyLinkedList<>();
        size = 0;
        readInputFile(fileName);
    }


    /**
     * Reads data from an input file, parses it, and populates the Influencers
     * with MonthlyStatistics. This method reads data from the specified file,
     * skips the header line, and then processes each subsequent line to create
     * MonthlyStatistics objects and associate them with Influencers. It ensures
     * that each Influencer is created or retrieved and updated based on the
     * input data.
     *
     * @param fileName
     *            the file path to read data from
     * @throws FileNotFoundException
     *             if the specified file is not found
     */
    private void readInputFile(String fileName)
        throws FileNotFoundException
    {
        Scanner file = new Scanner(new File(fileName));
        // skip header
        file.nextLine();

        while (file.hasNextLine())
        {

            String line = file.nextLine().replaceAll(" ", "");
            String[] tokens = line.split(",\\s*");

            String channelName = tokens[2];
            Influencer searchedInfluencer =
                searchIndexByChannelName(channelName);

            // check if influencer is in list
            if (searchedInfluencer == null)
            {
                // create new influencer
                searchedInfluencer = new Influencer(tokens[1], channelName);
                // add to list
                getInfluencers().add(searchedInfluencer);
                size++;
            }

            String country = "";
            if (tokens.length == 10)
            {
                country = tokens[3];
            }

            // add stats to influencer object
            if (searchedInfluencer != null)
            {
                MonthlyStatistics newPost = new MonthlyStatistics(
                    getMonthEnum(tokens[0]),
                    country,
                    tokens[tokens.length - 6],
                    toInt(tokens[tokens.length - 5]),
                    toInt(tokens[tokens.length - 3]),
                    toInt(tokens[tokens.length - 2]),
                    toInt(tokens[tokens.length - 1]));

                searchedInfluencer.addData(newPost);
            }

        }
        file.close();

    }


    // Helper method to convert string to integer with error handling
    private int toInt(String str)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }


    /**
     * Searches for an influencer by their channel name.
     *
     * @param name
     *            the channel name to search for
     * @return the influencer if found, otherwise null
     */
    public Influencer searchIndexByChannelName(String name)
    {
        for (int i = 0; i < size; i++)
        {
            if (getInfluencers().getData(i).getChannelName().equals(name))
            {
                return getInfluencers().getData(i);
            }
        }
        return null;
    }


    /**
     * Maps a string representation of a month to the corresponding MonthEnum
     * constant. This method takes a string value representing a month and
     * returns the corresponding MonthEnum constant. It is used to convert month
     * names from input data to their respective enum values.
     *
     * @param value
     *            the string representation of a month
     * @return the corresponding MonthEnum constant, or DEFAULT if the input is
     *             not recognized
     */
    private MonthEnum getMonthEnum(String value)
    {
        switch (value)
        {
            case "January":
                return MonthEnum.JANUARY;
            case "February":
                return MonthEnum.FEBRUARY;
            case "March":
                return MonthEnum.MARCH;
            default:
                return MonthEnum.DEFAULT;
        }
    }


    /**
     * Gets the list of influencers.
     *
     * @return the list of influencers
     */
    public DoublyLinkedList<Influencer> getInfluencers()
    {
        return influencers;
    }


    /**
     * Prints the list of influencers read from file to the console
     */
    public void printInfluencerSummaries()
    {

        // sort by name and traditional engR : ascending
        DoublyLinkedList<Influencer> listTrad = getInfluencers();
        listTrad.sortByName();

        for (Influencer influencer : listTrad)
        {
            System.out.println(influencer.getChannelName());

            // Check if ER is valid
            String tradER = "";
            if (isValid(influencer.tradEngRateQuarterly()))
            {
                tradER =
                    String.format("%.1f", influencer.tradEngRateQuarterly());

            }
            else
            {
                tradER = "na";
            }

            System.out.println("traditional: " + tradER);
            System.out.println("==========");
        }
        System.out.println("**********");
        System.out.println("**********");

        // Add logic for printing reach engagement rates if needed

        // sort by reach engR descending
        DoublyLinkedList<Influencer> listReach = getInfluencers();
        listReach.sortByEng(MonthEnum.DEFAULT, "reach");

        for (Influencer influencer : listReach)
        {
            System.out.println(influencer.getChannelName());

            // check if ER is valid
            String reachER = "";
            if (isValid(influencer.reachEngRateQuarterly()))
            {
                reachER =
                    String.format("%.1f", influencer.reachEngRateQuarterly());

            }
            else
            {
                reachER = "na";

            }
            System.out.println("reach: " + String.format(reachER));
            System.out.println("==========");
        }
    }


    /*
     * // ---------------------------------------------------------- /** Checks
     * whether Engagement rate is valid if followers or views is zero for
     * corresponding influencer F
     * @param engRate engagement rate
     * @return true or false
     */
    private boolean isValid(double engRate)
    {
        return engRate != Double.NEGATIVE_INFINITY;

    }

}
