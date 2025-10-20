package pond.goose;
import pond.shore.Bird;
public class Goose extends Bird {
    public void helpGooseSwim() {
        Goose other = new Goose();
        other.floatInWater();
        System.out.print(other.text);
    }
//    public void helpOtherGooseSwim() {
//        Bird other = new Goose();
//        other.floatInWater();
//        System.out.print(other.text);
//    }
}