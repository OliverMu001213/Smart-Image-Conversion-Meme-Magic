/**
 * Homework 4 *Oliver Mu, lm2ceh
 */
import java.util.Comparator;

public class CompareMemeByCreator implements Comparator<Meme>{
    
    /**
     * default constructor of CompareMemeByCreator class
     */
    public CompareMemeByCreator() {
        
    }
    /**
     * compare two Meme objects by creator first, then overal rating, caption, background image and shared lastly
     * 
     * @param a Meme object, b meme object
     * 
     * @return return 0, positive, negative
     */
    public int compare(Meme a, Meme b) {
        int temp = a.creator.compareTo(b.creator);
        if(temp !=0) {
            return temp;
        }
        temp = (int) (b.calculateOverallRating()-a.calculateOverallRating());
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
        if(a.shared==true&&b.shared==false){
            return -1;
        }
        
        else if(a.shared == false && b.shared == true) {
            return 1;
        }
        
        else{
            return temp;
        }
        
    }
    
    
}
