package tech.wec.Brainteaser;

public class ConstructTheRectangle_492 {

    public int[] constructRectangle(int area) {
        int L = (int)Math.ceil(Math.sqrt(area));
        while(area % L != 0){
            L++;
        }
        return new int[]{L, area / L};
    }
}
