
/**
 * Homework 4 *Oliver Mu, lm2ceh
 */
import java.util.ArrayList;

public class Feed {

    /**
     * an ArrayList that can store Meme object in the feed
     */
    public ArrayList<Meme> memes;

    /**
     * default constructor of Feed class, initialize the memes ArrayList
     */
    public Feed() {
        memes = new ArrayList<Meme>();
    }

    /**
     * @return return the memes ArrayList
     */
    public ArrayList<Meme> getMemes() {
        return memes;

    }

    /**
     * set ArrayList memes to an updated one
     * 
     * @param newArray updated ArrayList emes
     */
    public void setMemes(ArrayList<Meme> newArray) {
        memes = newArray;
    }

    /**
     * check if User object has seen the meme from the Feed's memes list, if the Meme has not been seen or created by the
     * User, return the Meme Otherwise return null;
     * 
     * @param newUser a User object
     * @return return Meme if the User has not seen or created the Meme in the ArrayList, return null otherwise
     */
    public Meme getNewMeme(User newUser) {
        Meme temp = null;

        ArrayList<Meme> t1 = new ArrayList<Meme>();
        ArrayList<Meme> t2 = new ArrayList<Meme>();
        for (Meme i : memes) {
            t2.add(i);
        }

        for (Meme i : memes) {
            for (Meme a : newUser.memesViewed) {
                if (i.equals(a)) {
                    t1.add(i);
                }
            }
        }

        for (Meme o : t1) {
            t2.remove(o);
        }

        for (Meme q : t2) {
            for (Meme a : newUser.memesCreated) {
                if (q.equals(a)) {
                    t1.add(q);
                }
            }
        }
        for (Meme u : t1) {
            t2.remove(u);
        }

        if (t2.isEmpty()) {
            temp = null;
        } else {
            temp = t2.get(0);
        }
        return temp;
    }

    /**
     * override method of toString
     * @return return the String description of Feed object
     */
    @Override
    public String toString() {
        String temp = "";
        for (Meme i : memes) {
            temp += i.toString() + '\n';
        }
        return temp;
    }
    
    

}
