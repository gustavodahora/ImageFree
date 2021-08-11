package dev.gustavodahora.imagefree;

public class MainItem {
    public int id;
    public int image;

    public MainItem(int i, int image) {
        this.id = i;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
