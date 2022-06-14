
/**
 * Homework 4 *Oliver Mu, lm2ceh
 */
import java.util.Comparator;

public class CompareMemeByRating implements Comparator<Meme>{
    
    /**
     * default constructor of CompareMemeByRating class
     */
    public CompareMemeByRating() {}
    
    /**
     * compare two Meme objects by overall rating first, then caption, background image, creator last.
     * 
     * @param a Meme object, b meme object
     * 
     * @return return 0, positive, negative
     */
    public int compare(Meme a, Meme b) {
        int temp = (int) (b.calculateOverallRating()-a.calculateOverallRating());
        if(temp !=0) {
            return temp;
        }
        temp = a.caption.compareTo(b.caption);
        if(temp !=0) {
            return temp;
        }
        temp = a.backgroundImage.compareTo(b.backgroundImage);
        if(temp !=0) {
            return temp;
        }
        return a.creator.compareTo(b.creator);
    }
    

}
