class Box {
    int volume(int height , int width , int length){
        return height * width * length;
    }

    int volume(int side){
        return side*side*side;
    }



}

public class BoxVolume{
    public static void main(String[] args) {
        Box cube = new Box();
        Box cuboid = new Box();

        System.out.println("Volume is : "+cube.volume(5));
        System.out.println("Volume is : "+cuboid.volume(4 , 3 ,2));

    }
}
