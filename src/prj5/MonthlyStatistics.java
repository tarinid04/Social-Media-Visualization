package prj5;

/**
 * The MonthlyStatistics class represents statistics for an influencer for a
 * specific month.
 *
 * @author Tarini Duvvuri (tarinid)
 * @version 14 Nov 2023
 */
public class MonthlyStatistics
{
    private MonthEnum month;
    private String country;
    private String mainTopic;
    private int likes;
    private int followers;
    private int comments;
    private int views;

    /**
     * Constructor for MonthlyStatistics.
     *
     * @param month
     *            The month of the media post.
     * @param country
     *            The country of the media post.
     * @param mainTopic
     *            The main topic of the media post.
     * @param likes
     *            The number of likes on the media post.
     * @param followers
     *            The number of followers of the media post influencer.
     * @param comments
     *            The number of comments on the media post.
     * @param views
     *            The number of views on the media post.
     */
    public MonthlyStatistics(
        MonthEnum month,
        String country,
        String mainTopic,
        int likes,
        int followers,
        int comments,
        int views)
    {
        this.month = month;
        this.country = country;
        this.mainTopic = mainTopic;
        this.likes = likes;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }


    /**
     * Getter method to retrieve the month of the MonthlyStatistics object.
     *
     * @return the month of the MonthlyStatistics
     */
    public MonthEnum getMonth()
    {
        return this.month;
    }


    /**
     * Getter method to retrieve the country of the MonthlyStatistics object.
     *
     * @return the country of the MonthlyStatistics
     */
    public String getCountry()
    {
        return this.country;
    }


    /**
     * Getter method to retrieve the main topic of the MonthlyStatistics object.
     *
     * @return the main topic of the MonthlyStatistics
     */
    public String getMainTopic()
    {
        return this.mainTopic;
    }


    /**
     * Getter method to retrieve the number of likes of the MonthlyStatistics
     * object.
     *
     * @return the number of likes of the MonthlyStatistics
     */
    public int getLikes()
    {
        return this.likes;
    }


    /**
     * Getter method to retrieve the number of followers of the
     * MonthlyStatistics object.
     *
     * @return the number of followers of the MonthlyStatistics
     */
    public int getFollowers()
    {
        return this.followers;
    }


    /**
     * Getter method to retrieve the number of comments of the MonthlyStatistics
     * object.
     *
     * @return the number of comments of the MonthlyStatistics
     */
    public int getComments()
    {
        return this.comments;
    }


    /**
     * Getter method to retrieve the number of views of the MonthlyStatistics
     * object.
     *
     * @return the number of views of the MonthlyStatistics
     */
    public int getViews()
    {
        return this.views;
    }


    /**
     * Setter method to update the month of the MonthlyStatistics object.
     *
     * @param newMonth
     *            the new month to be set
     */
    public void setMonth(MonthEnum newMonth)
    {
        this.month = newMonth;
    }


    /**
     * Setter method to update the main topic of the MonthlyStatistics object.
     *
     * @param newMainTopic
     *            the new main topic to be set
     */
    public void setMainTopic(String newMainTopic)
    {
        this.mainTopic = newMainTopic;
    }


    /**
     * Setter method to update the number of likes of the MonthlyStatistics
     * object.
     *
     * @param newLikes
     *            the new number of likes to be set
     */
    public void setLikes(int newLikes)
    {
        this.likes = newLikes;
    }


    /**
     * Setter method to update the number of followers of the MonthlyStatistics
     * object.
     *
     * @param newFollowers
     *            the new number of followers to be set
     */
    public void setFollowers(int newFollowers)
    {
        this.followers = newFollowers;
    }


    /**
     * Setter method to update the number of comments of the MonthlyStatistics
     * object.
     *
     * @param newComments
     *            the new number of comments to be set
     */
    public void setComments(int newComments)
    {
        this.comments = newComments;
    }


    /**
     * Setter method to update the number of views of the MonthlyStatistics
     * object.
     *
     * @param newViews
     *            the new number of views to be set
     */
    public void setViews(int newViews)
    {
        this.views = newViews;
    }


    /**
     * toString override.
     *
     * @return A string representation of the MonthlyStatistics object.
     */
    @Override
    public String toString()
    {
        return "Social Media Post: " + mainTopic + ", Country: " + country
            + ", Month: " + month + ", Followers: " + followers + ", Views: "
            + views + ", Likes: " + likes + ", Comments: " + comments;
    }


    /**
     * get traditional engagement rate
     *
     * @return int of traditional rate
     */
    public double getTraditionalEngagementRate()
    {
        if (followers == 0)
        {
            return Double.NEGATIVE_INFINITY;
        }
        return ((double)(comments + likes) / followers) * 100;

    }


    /**
     * get reach engagement rate
     *
     * @return int of traditional rate
     */
    public double getReachEngagementRate()
    {
        if (views == 0)
        {
            return Double.NEGATIVE_INFINITY;
        }
        return ((double)(comments + likes) / views) * 100;
    }


    /**
     * Equals method for comparing two MonthlyStatistics objects.
     *
     * @param obj
     *            The object to compare with.
     * @return True if equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        MonthlyStatistics other = (MonthlyStatistics)obj;
        return month == other.month && country.equals(other.country)
            && mainTopic.equals(other.mainTopic) && likes == other.likes
            && followers == other.followers && comments == other.comments
            && views == other.views;
    }
}
