package OOP2Photography;

public class Main {

    public static void main(String[] args) {
        Lens lens1 = new Lens(10, 20);
        Lens lens2 = new Lens(5, 50);
        Lens lens3 = new Lens(0, 40);

        Camera camera1 = new Camera("Canon", 48, 8, true, lens1);
        Camera camera2 = new Camera("Nikon", 100, 7, true, lens2);


        System.out.println("Camera 1:" + '\n' + camera1);
        System.out.println("Camera 2:" + '\n' + camera2);
        System.out.println("Amount of cameras: " + Camera.CAMERA_COUNT);

        camera1.setLens(lens3);
        //change the lens of camera1 with lens3
        System.out.println("Camera 1:" + '\n' + camera1);

        Lens lensFail = new Lens(50,0);
        //making a lens with a bigger minimum focal length on purpose to see the check
    }

}
