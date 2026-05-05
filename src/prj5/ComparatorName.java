package prj5;

import java.util.Comparator;
// -------------------------------------------------------------------------
/**
 * Uses the compare method to determine an influencer's username relative
 *  to another
 * 
 *  @author Sajni
 *  @version 13 Nov 2023
 */
public class ComparatorName implements Comparator<Influencer>
{

    /**
     * Compare two Influencer Objects based on their username
     * @param left lefthandside of comparison
     * @param right righthandside of comparison
     * @return zero if the usernames are the same
     *          negative if the left name comes before the right name
     *          positve if the left name comes after the right name
     * 
     */
    public int compare(Influencer left, Influencer right)
    {
        String copyLeft = left.getChannelName();
        String copyRight = right.getChannelName();
        return copyLeft.toLowerCase().compareTo(copyRight.toLowerCase());
    }


   
 

}
