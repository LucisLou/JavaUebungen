package OOP2Photography;

public class Lens {

    private int minFocal;
    private int maxFocal;

    public int getMinFocal() {
        return minFocal;
    }

    public void setMinFocal(int minFocal) {
        this.minFocal = minFocal;
    }

    public int getMaxFocal() {
        return maxFocal;
    }

    public void setMaxFocal(int maxFocal) {
        this.maxFocal = maxFocal;
    }

    @Override
    public String toString() {
        return "minimum focal length = " + minFocal + '\n' +
                "max focal length = " + maxFocal
                ;
    }

    public Lens(int minFocal, int maxFocal) {


        if (minFocal  > maxFocal) {
            System.out.println("!!!! Minimum focal length cannot be greater than maximum focal length or vice versa." + '\n' + "Please insert new values. !!!!");
        }
        else{
            this.minFocal = minFocal;
            this.maxFocal = maxFocal;
        }
        //a constructor of Lens with all the non-static variables
        //if minFocal is bigger than maxFocal, then the check prevents the variables to
    }
}
