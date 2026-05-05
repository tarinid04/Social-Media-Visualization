package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Uses the compare method to determine an influencer's username relative
 *  to another
 *  
 *  @author Sajni
 *  @version 15 Nov 2023
 */
public class ComparatorERReach implements Comparator<Double>
{

    /**
     * Compare 2 Person objects based on reach engagement Rate 
     * @param left lefthandside of comparison
     * @param right righthandside of comaparison
     * @return zero if rates are equal
     *          negative if left rate is less than right rate
     *          positive if left rate is greater than right rate
     * 
     */
    @Override
    public int compare(Double left, Double right)
    {
        return left.compareTo(right);
    }
    
}
