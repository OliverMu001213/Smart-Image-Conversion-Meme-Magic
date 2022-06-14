
/**
 * Homework 4 *Oliver Mu, lm2ceh
 */
import java.util.ArrayList;
import java.util.TreeSet;

public class User implements Comparable<User>{
    /**
     * name of the User
     */
    public String userName;
    /**
     * memes that User made
     */
    public ArrayList<Meme> memesCreated;
    /**
     * memes that User viewed
     */
    public TreeSet<Meme> memesViewed;

    /**
     * default constructor of User that initialize all the instances
     */
    public User() {
        this.userName = " ";
        memesCreated = new ArrayList<Meme>();
        memesViewed = new TreeSet<Meme>();
    }

    /**
     * constructor that initialize all instances
     * 
     * @param userName updated name for userName variable
     */
    public User(String userName) {
        this.userName = userName;
        memesCreated = new ArrayList<Meme>();
        memesViewed = new TreeSet<Meme>();
    }

    /**
     * rate the meme and add the rating to the meme, the viewed meme will be added to memesViewed ArrayList
     * 
     * @param newMeme a new Meme object to be viewed by user, rating user's rating of the viewed meme
     */
    public void rateMeme(Meme newMeme, int rating) {
        Rating newRating = new Rating(this, rating);
        newMeme.addRating(newRating);
        memesViewed.add(newMeme);
    }

    /**
     * create a new meme with BackgroundImage and caption and then added to memesCreated ArrayList
     * 
     * @param newBackgroundImage BackgroundImage object of the new Meme, caption, the caption of the new created meme
     * @return return the new meme created
     */
    public Meme createMeme(BackgroundImage newBackgroundImage, String caption) {
        Meme NewMeme = new Meme(newBackgroundImage, caption, this);
        memesCreated.add(NewMeme);
        return NewMeme;
    }

    /**
     * delete the meme in the parameter, cannot be deleted if memes is not in created list or shared online
     * 
     * @param newMeme meme to be deleted
     * @return return true if the meme is deleted, false otherwise
     */
    public boolean deleteMeme(Meme newMeme) {
        boolean result = false;
        for (Meme i : memesCreated) {
            if (i == newMeme) {
                if (newMeme.getShared() == false) {

                    result = true;
                }
            }
        }
        if (result == true) {
            memesCreated.remove(newMeme);
        }
        return result;

    }

    /**
     * share the meme to a feed object
     * 
     * @param newMeme meme to be shared online, newFeed a Feed object and the selected meme will be added to its memes list
     */
    public void shareMeme(Meme newMeme, Feed newFeed) {
        newMeme.setShared(true);
        newFeed.memes.add(newMeme);
    }

    /**
     * rate the meme from the Feed and give a score
     * 
     * @param newFeed User get new meme from this Object, ratingScore user's rating for the meme
     * @return return true if meme is rated, false if null
     */
    public boolean rateNextMemeFromFeed(Feed newFeed, int ratingScore) {

        Meme temp = newFeed.getNewMeme(this);
        if (temp == null) {
            return false;
        } else {
            Rating newRating = new Rating(this, ratingScore);
            temp.addRating(newRating);
            memesViewed.add(temp);
            return true;
        }

    }

    /**
     * Calculate the reputation of User's rating
     * 
     * @return return the User created memes'rating as double
     */
    public double calculateReputation() {
        double reputation = 0.0;
        if (memesCreated.size() != 0) {

            for (Meme i : memesCreated) {
                reputation += i.calculateOverallRating();
            }
            reputation = reputation / memesCreated.size();
        }
        return reputation;
    }

    /**
     * override method of toString
     * 
     * @return return the string representation of User object
     */
    @Override
    public String toString() {

        return userName + " has rated (" + memesViewed.size() + ") memes, (" + calculateReputation() + ")";
    }

    /**
     * override equals method
     * 
     * @param NewObject object that will be compared to the User object
     * @return true if the two objects and their instances are the same, false otherwise
     */
    @Override
    public boolean equals(Object NewObject) {
        if (NewObject == null) {
            return false;
        }
        if (NewObject instanceof User) {
            User temp = (User) NewObject;

            if (this.userName.equals(temp.userName)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
     * @return the name of the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the memes User created
     */
    public ArrayList<Meme> getMemesCreated() {
        return memesCreated;
    }
    
    /**
     * @return return the memes User viewed
     */
    public TreeSet<Meme> getMemesViewed() {
        return memesViewed;
    }
    
    /**
     * setter method of userName
     * 
     * @param NewUserName updated userName
     */
    public void setUserName(String NewUserName) {
        userName = NewUserName;
    }
    
    /**
     * setter method for memesCreated ArrayList
     * 
     * @param newArray updated memesCreated ArrayList
     */
    public void setMemesCreated(ArrayList<Meme> NewArray) {
        memesCreated = NewArray;
    }
    
    /**
     * setter method for memesViewed ArrayList
     * 
     * @param NewArray updated memesViewed list
     */
    public void setMemesViewed(TreeSet<Meme> NewArray) {
        memesViewed = NewArray;
    }
    
    /**
     * set the description
     * 
     * @param newMeme a BackgroundImage object that will be compared to
     * 
     * @return return 0, positive, negative
     */
    @Override
    public int compareTo(User newUser) {
        int tempValue = this.userName.compareTo(newUser.userName);
        if(tempValue!=0) {
            return tempValue;
        }
        tempValue = newUser.memesCreated.size()-this.memesCreated.size();
        if(tempValue!=0) {
            return tempValue;
        }
        else {
            return tempValue;
        }
    }
}
