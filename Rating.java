/**
 * Homework 4 *Oliver Mu, lm2ceh
 */
public class Rating {
    /**
     * score of the Rating
     */
    public int score;
    /**
     * User who made the rating
     */
    public User user;

    /**
     * default constructor that initialize User, score variables
     */
    public Rating() {
        User nUser = null;
        score = 0;
        user = nUser;
    }

    /**
     * constructor that initialize user and score variables
     * 
     * @param user the user who created the rating, score the score that user give
     */
    public Rating(User user, int score) {
        setScore(score);
        this.user = user;
    }

    /**
     * @return return the score of this rating
     */
    public int getScore() {
        return score;

    }

    /**
     * @return return the user of this rating
     */
    public User getUser() {
        return user;
    }

    /**
     * update the score of this rating, can only be -1 1 or 0
     * 
     * @param newScore updated score
     * @return return true if the score is updated, false otherwise
     */
    public boolean setScore(int newScore) {

        if (newScore == -1 || newScore == 1 || newScore == 0) {
            score = newScore;
            return true;
        } else {

            return false;
        }
    }

    /**
     * setter method for user
     * 
     * @param newUser the updated user
     */
    public void setUser(User newUser) {
        user = newUser;
    }

    /**
     * override method of toString
     * 
     * @return return the String representation of Rating object
     */
    @Override
    public String toString() {
        if (score == -1) {
            return user.getUserName() + " rated as a downvote";
        } else if (score == 1) {
            return user.getUserName() + " rated as an upvote";
        } else {
            return user.getUserName() + " rated as a pass";
        }
    }

    /**
     * override method of equals
     * 
     * @param neObject the object that will be compared to the Rating object
     * @return return true if two objects are the same and their instances are the same
     */
    @Override
    public boolean equals(Object newObject) {
        if (newObject == null) {
            return false;
        }
        if (newObject instanceof Rating) {
            Rating temp = (Rating) newObject;
            if (this.score == temp.score & this.user.equals(temp.user)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

}
