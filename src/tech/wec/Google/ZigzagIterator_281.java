package tech.wec.Google;

import java.util.List;

public class ZigzagIterator_281 {
    class ZigzagIterator {

        List<Integer> v1;
        List<Integer> v2;
        int v1Cursor, v2Cursor, ptr;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1 = v1;
            this.v2 = v2;
            v1Cursor = v2Cursor = 0;
            ptr = v1.size() > 0 ? 0 : 1;
        }

        public int next() {
            if (ptr == 0){
                ptr = 1;
                if (v1.size() == v1Cursor)
                    return next();
                return v1.get(v1Cursor++);
            }else{
                ptr = 0;
                if (v2.size() == v2Cursor)
                    return next();
                return v2.get(v2Cursor++);
            }
        }

        public boolean hasNext() {
            return v1.size() > v1Cursor || v2.size() > v2Cursor;
        }
    }
}
