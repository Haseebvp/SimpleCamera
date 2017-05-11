package database;

/**
 * Created by haseeb on 11/5/17.
 */

public class ImageModel {
    String name;
    byte [] image;

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
