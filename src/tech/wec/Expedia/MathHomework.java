package tech.wec.Expedia;

import java.util.List;

public class MathHomework {
    class Result {

        /*
         * Complete the 'minNum' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER threshold
         *  2. INTEGER_ARRAY points
         */

        public int minNum(int threshold, List<Integer> points) {
            // Write your code here
            int max = threshold + points.get(0);
            int idx = points.size() - 1;
            while(idx > 0){
                if(points.get(idx) >= max) return (int)Math.ceil((double)idx/2.0);
                else idx--;
            }
            return points.size();
        }

    }
}
