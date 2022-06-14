/**
 * Homework 4 *Oliver Mu, lm2ceh
 */

public class Meme implements Comparable<Meme>{
    /**
     * holds the User object who created the Meme object
     */
    public User creator;
    /**
     * holds the BackgroundImage object of the Meme object
     */
    public BackgroundImage backgroundImage;
    /**
     * holds the ratings object in an array of the Meme object
     */
    public Rating[] ratings;
    /**
     * holds the caption of the Meme
     */
    public String caption;
    /**
     * holds the caption Vertical Align of the Meme
     */
    public String captionVerticalAlign;
    /**
     * holds the shared of Meme
     */
    public boolean shared;

    /**
     * a default constructor that initialize the BackgroundImage,ratings array, User, caption, caption Vertical Align and
     * shared instances.
     */
    public Meme() {

        BackgroundImage bg = new BackgroundImage();
        ratings = new Rating[10];
        creator = new User();
        backgroundImage = bg;
        caption = "";
        captionVerticalAlign = "bottom";
        shared = false;
    }

    /**
     * a constructor that set BackgroundImage, caption, newUser, ratings array and caption vertical align
     * 
     * @param BackgroundImage a BackgroundImage object, caption the caption of Meme object, newUser the User object of the                    
     */
    public Meme(BackgroundImage BackgroundImage, String caption, User newUser) {
        captionVerticalAlign = "bottom";
        this.backgroundImage = BackgroundImage;
        this.caption = caption;
        ratings = new Rating[10];

        creator = newUser;

    }

    /**
     * @return return the User object of this class
     */
    public User getCreator() {
        return creator;

    }

    /**
     * @return the backgroundImage object of this class
     */
    public BackgroundImage getBackgroundImage() {
        return backgroundImage;

    }

    /**
     * @return return the Rating array of Meme class
     */
    public Rating[] getRatings() {
        return ratings;

    }

    /**
     * @return return the caption of this class
     */
    public String getCaption() {
        return caption;

    }

    /**
     * @return return the CaptionVerticalAlign of this class
     */
    public String getCaptionVerticalAlign() {
        return captionVerticalAlign;

    }

    /**
     * @return the shared of Meme
     */
    public boolean getShared() {
        return shared;

    }

    /**
     * set new User object for creator
     * 
     * @param newCreator updated User of Meme
     */
    public void setCreator(User newCreator) {
        creator = newCreator;

    }

    /**
     * set new BackgroundImage
     * 
     * @param newBackgroundImage updated BackgroundImage of Meme
     */
    public void setBackgroundImage(BackgroundImage newBackgroundImage) {
        backgroundImage = newBackgroundImage;

    }

    /**
     * set new ratings array
     * 
     * @param newRatings updated ratings array
     */
    public void setRatings(Rating[] newRatings) {
        ratings = newRatings;

    }

    /**
     * set new caption
     * 
     * @param newCaption updated caption of Meme
     */
    public void setCaption(String newCaption) {
        caption = newCaption;

    }

    /**
     * set new CaptionVerticalAlign, can only be top, middle or bottom, otherwise the method return false
     * 
     * @param newCaptionVerticalAlign updated CaptionVerticalAlign
     * @return return true if the new varaible is updated, false otherwise
     */
    public boolean setCaptionVerticalAlign(String newCaptionVerticalAlign) {
        if (newCaptionVerticalAlign == "top" || newCaptionVerticalAlign == "middle" || newCaptionVerticalAlign == "bottom") {
            captionVerticalAlign = newCaptionVerticalAlign;
            return true;
        } else {
            return false;
        }

    }

    /**
     * set new shared of Meme
     * 
     * @param newShared updated shared variable of Meme
     */
    public void setShared(boolean newShared) {
        shared = newShared;

    }

    /**
     * add a rating object to the rating array and, if array is full, delete the first one to make room for new array
     * object, return true if array is updated
     * 
     * @param newRating, a new Rating object to be added to the array
     * @return return true if the array is updated, false otherwise
     */
    public boolean addRating(Rating newRating) {
        for (int i = 0; i < ratings.length; i++) {
            if (this.ratings[i] == null) {
                this.ratings[i] = newRating;
                return true;
            }

        }
        if (ratings[9] != null) {
            for (int i = 0; i < 9; i++) {
                ratings[i] = ratings[i + 1];
            }
            this.ratings[9] = newRating;
            return true;
        }

        return false;

    }

    /**
     * calculate the overall rating of the meme in the rating array
     * 
     * @return return the overall score of the meme ratings
     */
    public double calculateOverallRating() {
        double sum = 0.0;
        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] == null) {
                count++;
            }
        }

        if (count != 10) {
            for (int i = 0; i < ratings.length; i++) {
                if (ratings[i] == null) {
                    sum += 0;
                } else {
                    sum = sum + (double) ratings[i].getScore();
                }

            }
        }

        return sum;

    }

    /**
     * override toString method
     * 
     * @return return string representation of Meme, include the backgroundImage with caption overall rating and creator of
     *         the meme
     */
    @Override
    public String toString() {
        return backgroundImage.toString() + " '" + caption + "' " + calculateOverallRating() + " " + "[+1: " + positiveRating()
                + ", -1: " + negativeRating() + "] - created by " + creator.getUserName();

    }

    /**
     * calculate how many positive ratings are in the rating array
     * 
     * @return return the number of positive rating of Meme in ratings array
     */
    private int positiveRating() {
        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] == null) {
                count += 0;
            } else if (ratings[i].getScore() == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * calculate how many negative ratings are in the rating array
     * 
     * @return return the number of negative rating of Meme in ratings array
     */
    private int negativeRating() {
        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] == null) {
                count += 0;
            } else if (ratings[i].getScore() == -1) {

                count++;
            }
        }
        return count;
    }
    
    /**
     * override equals method that compare two objects
     * 
     * @param NewObject an object to be compared to the Meme object
     * @return return true if two objects are the same and their instances are the same too, return false otherwise
     */
    @Override
    public boolean equals(Object NewObject) {
        if (NewObject == null) {
            return false;
        }
        if (NewObject instanceof Meme) {
            Meme temp = (Meme) NewObject;

            if (this.caption.equals(temp.caption) && this.backgroundImage.equals(temp.backgroundImage)
                    && this.creator.equals(temp.creator)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
    
    /**
     * set the description
     * 
     * @param newMeme a BackgroundImage object that will be compared to
     * 
     * @return return 0, positive, negative
     */
    @Override
    public int compareTo(Meme newMeme) {
        int tempValue = this.caption.compareTo(newMeme.caption);
        if(tempValue!=0) {
            return tempValue;
        }
        
        tempValue = this.backgroundImage.compareTo(newMeme.backgroundImage);
        if(tempValue!=0) {
            return tempValue;
        }
        
        tempValue = (int) (newMeme.calculateOverallRating()-calculateOverallRating());
        if(tempValue!=0) {
            return tempValue;
        }
        
        if(this.shared==true&&newMeme.shared==false){
            return -1;
        }
        
        else if(this.shared == false && newMeme.shared == true) {
            return 1;
        }
        
        else{
            return tempValue;
        }
    }
        
        
       

}
