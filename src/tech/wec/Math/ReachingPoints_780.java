package tech.wec.Math;

public class ReachingPoints_780 {

    // tle
    public boolean reachingPoints_1(int sx, int sy, int tx, int ty) {
        while(tx >= sx && ty >= sy){
            if (tx == sx && ty == sy) return true;
            if (tx > ty) tx -= ty;
            else ty -= tx;
        }
        return false;
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty){
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);
    }
}
