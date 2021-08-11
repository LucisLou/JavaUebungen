package OOP2Photography;

public class Camera {

    public static int CAMERA_COUNT = 0;
    private String brand;
    private int megaPixels;
    private int displaySize;
    private boolean colored;
    private Lens lens;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMegaPixels() {
        return megaPixels;
    }

    public void setMegaPixels(int megaPixels) {
        this.megaPixels = megaPixels;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public Lens getLens(Lens lens) {
        return lens;
    }

    public void setLens(Lens lens) {
        this.lens = lens;
    }

    @Override
    public String toString() {
        return
                "brand = " + brand + '\n' +
                "megaPixels = " + megaPixels + '\n' +
                "displaySize = " + displaySize + '\n' +
                "colored = " + colored + '\n' +
                "lens: " + '\n' + lens
                ;
    }

    public Camera(String brand, int megaPixels, int displaySize, boolean colored, Lens lens) {

        this.brand = brand;
        this.megaPixels = megaPixels;
        this.displaySize = displaySize;
        this.colored = colored;
        this.lens = lens;
        CAMERA_COUNT++;

        //a constructor of Camera with all the non-static variables and lens from the class Lens, every created instance increases CAMERA_COUNT by 1

    }

}
