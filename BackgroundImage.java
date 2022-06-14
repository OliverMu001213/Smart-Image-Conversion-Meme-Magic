/**
 * Homework 4 *Oliver Mu, lm2ceh
 */
public class BackgroundImage implements Comparable<BackgroundImage>{
    /**
     * the name of the image file
     */
    public String imageFileName;

    /**
     * holds the title of background image
     */
    public String title;

    /**
     * holds the description of background image
     */
    public String description;

    /**
     * set the image file name, title and description
     */
    public BackgroundImage() {
        imageFileName = "";
        title = "";
        description = "";
    }

    /**
     * set the image file name, title and description
     */
    public BackgroundImage(String imageFileName, String title, String description) {
        this.imageFileName = imageFileName;
        this.title = title;
        this.description = description;
    }

    /**
     * the string description of class BackgroundImage, method is override
     */
    @Override
    public String toString() {
        return title + " <" + description + ">";

    }

    /**
     * chekc if the parameter is a BackgroundImage class and the instances are equal
     * 
     * @param newObject an object to check
     * @return return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object newObject) {
        if (newObject == null) {
            return false;
        }
        if (newObject instanceof BackgroundImage) {
            BackgroundImage temp = (BackgroundImage) newObject;
            if (this.title.equals(temp.title) && this.description.equals(temp.description)
                    && this.imageFileName.equals(temp.imageFileName)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * getter method to get String imageFilename
     * @return return the imageFileName
     */
    public String getImageFileName() {
        return imageFileName;

    }

    /**
     * getter method to get String title
     * @return return the title
     */
    public String getTitle() {
        return title;

    }

    /**
     * getter method to get String description
     * @return the description
     */
    public String getDescription() {
        return description;

    }

    /**
     * set the imageFile
     * 
     * @param newFielname the updated title imageFile
     */
    public void setImageFileName(String newFilename) {
        imageFileName = newFilename;

    }

    /**
     * set the title
     * 
     * @param newTitile the updated title
     */
    public void setTitle(String newTitle) {
        title = newTitle;

    }

    /**
     * set the description
     * 
     * @param newDescription the updated description
     */
    public void setDescription(String newDescription) {
        description = newDescription;

    }
    
    /**
     * set the description
     * 
     * @param newMeme a BackgroundImage object that will be compared to
     * 
     * @return return 0, positive, negative
     */
    @Override
    public int compareTo(BackgroundImage newBackgroundImage) {
        int tempValue = this.imageFileName.compareTo(newBackgroundImage.imageFileName);
        if(tempValue!=0) {
            return tempValue;
        }
        tempValue = this.title.compareTo(newBackgroundImage.title);
        if(tempValue!=0) {
            return tempValue;
        }
        tempValue = this.description.compareTo(newBackgroundImage.description);
        if(tempValue!=0) {
            return tempValue;
        }
        else {
            return tempValue;
        }
    }

}