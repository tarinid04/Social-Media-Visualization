
package prj5;

import java.util.ArrayList;
import java.util.List;

/**
 * The Influencer class represents an influencer entity with associated data.
 * this is the influencer class
 *
 * @author Tarini Duvvuri (tarinid)
 * @version 14 Nov 2023
 */
public class Influencer
    implements Comparable<Influencer>
{

    /**
     * Name of the user
     */
    private String username;
    /**
     * Name of channel
     */
    private String channelNm;
    /**
     * List storing all the post of this channelName
     */
    private List<MonthlyStatistics> monthlyStats;

    /**
     * constructor for class
     *
     * @param username
     *            for user name
     * @param channelNm
     *            for channel name
     */
    public Influencer(String username, String channelNm)
    {
        this.username = username;
        this.channelNm = channelNm;
        monthlyStats = new ArrayList<>();
    }


    /**
     * add a Data of posts
     *
     * @param monthlyStat
     *            to add the post to the list
     */
    public void addData(MonthlyStatistics monthlyStat)
    {
        monthlyStats.add(monthlyStat);
    }


    /**
     * getter method for linked list.
     *
     * @return LinkedList<MediaPost> for use
     */
    public List<MonthlyStatistics> getPosts()
    {
        return this.monthlyStats;

    }


    /**
     * getter method for user name
     *
     * @return String of user name
     */
    public String getUserName()
    {
        return this.username;
    }


    /**
     * getter method for user name
     *
     * @return String of user name
     */
    public String getChannelName()
    {
        return this.channelNm;
    }


    /**
     * Compares this influencer to another influencer based on channel names.
     *
     * @param otherInfluencer
     *            the other influencer object to compare
     * @return a positive integer if this influencer's channel name is greater,
     *             a negative integer if the other influencer's channel name is
     *             greater, or 0 if both channel names are the same.
     */
    @Override
    public int compareTo(Influencer otherInfluencer)
    {
        return this.channelNm.toLowerCase()
            .compareTo(otherInfluencer.channelNm.toLowerCase());
    }


    /**
     * get traditional engagement rate by month of quarter
     *
     * @param month
     *            to get which month
     * @return double for traditional engagement rate
     */
    public double getTradEngRateByMonth(MonthEnum month)
    {
        if (month == MonthEnum.DEFAULT)
        {
            return tradEngRateQuarterly();
        }

        for (MonthlyStatistics monthlyStat : monthlyStats)
        {
            if (monthlyStat.getMonth().equals(month))
            {
                return monthlyStat.getTraditionalEngagementRate();
            }
        }
        return Double.NEGATIVE_INFINITY;

    }


    /**
     * get reach engagement rate by month of quarter
     *
     * @param month
     *            to get which month
     * @return double for reach engagement rate
     */
    public double getReachEngRateByMonth(MonthEnum month)
    {
        if (month == MonthEnum.DEFAULT)
        {
            return reachEngRateQuarterly();
        }
        for (MonthlyStatistics monthlyStat : monthlyStats)
        {
            if (monthlyStat.getMonth().equals(month))
            {
                return monthlyStat.getReachEngagementRate();
            }
        }
        return Double.NEGATIVE_INFINITY;

    }


    /**
     * get traditional engagement rate by quarter
     *
     * @return double for reach engagement rate
     */
    double tradEngRateQuarterly()
    {
        int totalComment = 0;
        int totalLikes = 0;
        int followers = 0;
        for (MonthlyStatistics post : monthlyStats)
        {
            if (post.getMonth() != MonthEnum.DEFAULT)
            {
                totalComment += post.getComments();
                totalLikes += post.getLikes();
            }
            if (post.getMonth() == MonthEnum.MARCH)
            {
                followers = post.getFollowers();
            }
        }
        if (followers == 0)
        {
            return Double.NEGATIVE_INFINITY;
        }
        return ((double)(totalComment + totalLikes) / followers) * 100;
    }


    /**
     * get reach engagement rate by quarter
     *
     * @return double for reach engagement rate
     */
    double reachEngRateQuarterly()
    {
        int totalComment = 0;
        int totalLikes = 0;
        int totalViews = 0;
        for (MonthlyStatistics post : monthlyStats)
        {
            if (post.getMonth() != MonthEnum.DEFAULT)
            {
                totalComment += post.getComments();
                totalLikes += post.getLikes();
                totalViews += post.getViews();
            }
        }
        if (totalViews == 0)
        {
            return Double.NEGATIVE_INFINITY;
        }
        return ((double)(totalComment + totalLikes) / totalViews) * 100;
    }


    /**
     * Checks if this influencer is equal to another object.
     *
     * @param obj
     *            the object to compare
     * @return true if the objects have the same channel name, user name, and
     *             posts in the same order; false otherwise.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        if (this.getClass() == obj.getClass())
        {
            Influencer other = (Influencer)obj;
            if (!this.getChannelName().equals(other.getChannelName())
                || !this.getUserName().equals(other.getUserName()))
            {
                return false;
            }

            return this.getPosts().equals(other.getPosts());

        }
        return false;
    }
}
