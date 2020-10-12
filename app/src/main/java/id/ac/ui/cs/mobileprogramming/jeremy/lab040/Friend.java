package id.ac.ui.cs.mobileprogramming.jeremy.lab040;

public class Friend {

    private String name;
    private String desc;
    private int image;

    public Friend(String name, String desc, int image) {
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return image;
    }

    public void setName(int image) {
        this.image = image;
    }
}