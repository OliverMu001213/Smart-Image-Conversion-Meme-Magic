/**
 * Homework 4 *Oliver Mu, lm2ceh
 */

import java.util.Collections;


public class OrderableFeed extends Feed{
    
    /**
     * default constructor of OrderableFeed class
     */
    public OrderableFeed() {};
    
    /**
     * sort the viewed memes arraylist by caption, which is the memes natural order
     *
     */
    public void sortByCaption() {
        Collections.sort(this.memes, null);
    }
    
    /**
     * sort the viewed memes arraylist by overall rating
     *
     */
    public void sortByRating() {
        Collections.sort(this.memes, new CompareMemeByRating());
    }
    
    /**
     * sort the viewed memes arraylist by creator
     *
     */
    public void sortByCreator() {
        Collections.sort(this.memes, new CompareMemeByCreator());
    }
}
