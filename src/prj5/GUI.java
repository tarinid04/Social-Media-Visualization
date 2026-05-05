package prj5;

import cs2.*;
import java.awt.Color;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * The GUI class represents the graphical user interface for the Social Media
 * Database Visualization
 *
 * @author garim
 * @version Nov 27, 2023
 * @author jackgartman
 * @version Nov 28, 2023
 * @author tarinid
 * @version Nov 30, 2023
 * @author Sajni
 * @version 30 Nov 2023
 */
public class GUI
{
    // ~ Fields ................................................................

    private DoublyLinkedList<Influencer> list;
    private Window window;
    private Button sortByCNButton;
    private Button sortByERButton;
    private Button quitButton;
    private Button tradERButton;
    private Button firstQuarterButton;
    private Button reachERButton;
    private Button januaryButton;
    private Button februaryButton;
    private Button marchButton;
    private MonthEnum currentMonth; // from enum
    private String engagementType; // either traditional or reach
    private String sortType; // either name or eR
    private static final int HEIGHT_MARGIN = 100;
    private static final int WIDTH_OFFSET = 100;
    private static final int MAX_BAR_HEIGHT = 250;
    private static final int BAR_WIDTH = 30;
    private static final int TEXT_GAP = 10;
    private static final int WIDTH_MARGIN = 100;

    // ~ Constructors ..........................................................

    /**
     * The constructor instantiates the GUI Window, sets its title and size, and
     * adds various buttons for sorting, calculating engagement rates, and
     * sorting through different months
     */
    public GUI(DoublyLinkedList<Influencer> list)
    {
        this.list = list;

        // default graph variables
        currentMonth = MonthEnum.JANUARY;
        engagementType = "traditional";
        sortType = "name";
        list.sortByName();

        window = new Window();
        window.setTitle(
            "Social Media Vis (jackgartman04) (sajni) "
                + "(tarinid) (vgarimella)");
        window.setSize(1000, 550);

        sortByCNButton = new Button("Sort By Channel Name");
        sortByCNButton.onClick(this, "clickedSortByCN");
        window.addButton(sortByCNButton, WindowSide.NORTH);

        sortByERButton = new Button("Sort by Engagement Rate");
        sortByERButton.onClick(this, "clickedSortByER");
        window.addButton(sortByERButton, WindowSide.NORTH);

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        tradERButton = new Button("Traditional Engagement Rate");
        tradERButton.onClick(this, "clickedTradER");
        window.addButton(tradERButton, WindowSide.WEST);

        reachERButton = new Button("Reach Engagement Rate");
        reachERButton.onClick(this, "clickedReachER");
        window.addButton(reachERButton, WindowSide.WEST);

        januaryButton = new Button("January");
        januaryButton.onClick(this, "clickedJanuary");
        window.addButton(januaryButton, WindowSide.SOUTH);

        februaryButton = new Button("February");
        februaryButton.onClick(this, "clickedFebruary");
        window.addButton(februaryButton, WindowSide.SOUTH);

        marchButton = new Button("March");
        marchButton.onClick(this, "clickedMarch");
        window.addButton(marchButton, WindowSide.SOUTH);

        firstQuarterButton = new Button("First Quarter (Jan - March)");
        firstQuarterButton.onClick(this, "clickedFirstQuarter");
        window.addButton(firstQuarterButton, WindowSide.SOUTH);

        // display default graph
        displayGraph();
    }

    // ~Public Methods ........................................................


    /**
     * Runs when the Sort By Channel Name button is clicked. Sorts the list by
     * channel name and displays the graph.
     */
    public void clickedSortByCN(Button button)
    {
        sortType = "name";
        sortType();
        displayGraph();
    }


    /**
     * Runs when the Sort By Engagement Rate button is clicked. Sorts the list
     * by engagement rate and displays the graph.
     */
    public void clickedSortByER(Button button)
    {
        sortType = "eR";
        sortType();
        displayGraph();
    }


    /**
     *
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    /**
     * Once clicked, will disable the button and enable the
     */
    public void clickedTradER(Button button)
    {
        engagementType = "traditional";
        sortType();
        displayGraph();
    }


    /**
     *
     */
    public void clickedReachER(Button button)
    {
        engagementType = "reach";
        sortType();
        displayGraph();
    }


    /**
     * Displays the data for just the month of January
     */
    public void clickedJanuary(Button button)
    {
        currentMonth = MonthEnum.JANUARY;
        sortType();
        displayGraph();

    }


    /**
     * Displays the data for just the month of February
     */
    public void clickedFebruary(Button button)
    {
        currentMonth = MonthEnum.FEBRUARY;
        sortType();
        displayGraph();
    }


    /**
     * Displays the data for just the month of march
     */
    public void clickedMarch(Button button)
    {
        currentMonth = MonthEnum.MARCH;
        sortType();
        displayGraph();
    }


    /**
     * Displays the data for the first three months
     */
    public void clickedFirstQuarter(Button button)
    {
        currentMonth = MonthEnum.DEFAULT;
        sortType();
        displayGraph();

    }


    /**
     * Displays the list in bar graph form, iterating through the list and
     * generating bars with text
     */
    public void displayGraph()
    {
        window.removeAllShapes(); // Clear the window before drawing new shapes

        int textY = TEXT_GAP;
        TextShape monthMessage =
            new TextShape(TEXT_GAP, textY, getMonthString());
        window.addShape(monthMessage);

        textY += monthMessage.getHeight() + TEXT_GAP;
        TextShape engagementMessage =
            new TextShape(TEXT_GAP, textY, getERString());
        window.addShape(engagementMessage);

        textY += engagementMessage.getHeight() + TEXT_GAP;
        TextShape sortTypeMessage =
            new TextShape(TEXT_GAP, textY, getSortString());
        window.addShape(sortTypeMessage);

        double maxHeight = 0;
        for (int i = 0; i < list.getCurrentSize(); i++)
        {
            if (engagementType.equals("traditional") && list.getData(i)
                .getTradEngRateByMonth(currentMonth) > maxHeight)
            {
                maxHeight = list.getData(i).getTradEngRateByMonth(currentMonth);
            }
            else if (engagementType.equals("reach") && list.getData(i)
                .getReachEngRateByMonth(currentMonth) > maxHeight)
            {
                maxHeight =
                    list.getData(i).getReachEngRateByMonth(currentMonth);
            }
        } // ^^^^ Searches the list for the max ER so it can set the upper bound

        double heightFactor = MAX_BAR_HEIGHT / maxHeight;
        int x = WIDTH_MARGIN;
        for (int i = 0; i < list.getCurrentSize(); i++)
        {
            String chanName = list.getData(i).getChannelName();

            double chanER = 0;

            if (currentMonth != MonthEnum.DEFAULT)
            {
                if (engagementType.equals("traditional"))
                {
                    chanER =
                        list.getData(i).getTradEngRateByMonth(currentMonth);
                }
                else if (engagementType.equals("reach"))
                {
                    chanER =
                        list.getData(i).getReachEngRateByMonth(currentMonth);
                }
            }
            else
            {

                if (engagementType.equals("traditional"))
                {
                    chanER = list.getData(i).tradEngRateQuarterly();
                }
                else if (engagementType.equals("reach"))
                {
                    chanER = list.getData(i).reachEngRateQuarterly();
                }
            }

            int colHeight = (int)(chanER * heightFactor);
            int y = HEIGHT_MARGIN + (MAX_BAR_HEIGHT - colHeight);
            Shape shape = new Shape(x, y, BAR_WIDTH, colHeight);
            TestableRandom random = new TestableRandom();
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            shape.setBackgroundColor(new Color(red, green, blue));
            window.addShape(shape);

            y += colHeight + TEXT_GAP;
            TextShape nameText = new TextShape(x, y, chanName);
            window.addShape(nameText);

            // change ER to String and format to #.# or N/A if div 0
            String strER = "";
            if (chanER == Double.NEGATIVE_INFINITY)
            {
                strER = "N/A";
            }
            else
            {
                strER = String.format("%.1f", chanER);
            }

            y += nameText.getHeight() + TEXT_GAP;
            TextShape engagementText = new TextShape(x, y, strER);
            window.addShape(engagementText);

            // The x value updates with every iteration
            x += BAR_WIDTH + WIDTH_OFFSET;
        } // Iterates through the list, making new bars and text for each
    }


    /**
     * Display sorted data based on current sort type
     */
    public void sortType()
    {

        if (sortType.equals("eR"))
        {
            list.sortByEng(currentMonth, engagementType);
        }
        else
        {
            list.sortByName();
        }
    }


    /**
     * Displays either the current month or first quarter being sorted
     *
     * @return month or quarter
     */
    private String getMonthString()
    {
        if (currentMonth == MonthEnum.JANUARY)
        {
            return "January";
        }
        if (currentMonth == MonthEnum.FEBRUARY)
        {
            return "February";
        }
        if (currentMonth == MonthEnum.MARCH)
        {
            return "March";
        }
        else
        {
            return "First Quarter (Jan-March)";
        }
    }


    /**
     * Displays which Engagement rate is being shown
     *
     * @return engagement rate
     */
    private String getERString()
    {
        if (engagementType.equals("traditional"))
        {
            return "Traditional Engagement Rate";
        }
        else
        {
            return "Reach Engagement Rate";
        }
    }


    /**
     * Displays which Sorting method is being used
     *
     * @return sort method
     */
    private String getSortString()
    {
        if (sortType.equals("eR"))
        {
            return "Sorting By Engagement Rate";
        }
        else
        {
            return "Sorting By Channel Name";
        }
    }
}
