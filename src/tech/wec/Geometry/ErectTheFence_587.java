package tech.wec.Geometry;

import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;

public class ErectTheFence_587 {
    // 求凸包Jarvis
    class solution {

        private int orientation(Point p, Point q, Point r){
            return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        }

        private boolean inBetween(Point p, Point i, Point q){
            boolean a = i.x >= p.x && i.x <= q.x || i.x <= p.x && i.x >= q.x;
            boolean b = i.y >= p.y && i.y <= q.y || i.y <= p.y && i.y >= q.y;
            return a && b;
        }

        public int[][] outerTrees(int[][] points) {
            if(points.length < 4) return points;
            HashSet<Point> hull = new HashSet<>();
            int leftMost = 0;
            for (int i = 0; i < points.length; i++){
                if (points[i][0] < points[leftMost][0])
                    leftMost = i;
            }
            int p = leftMost;
            do {
                int q = (p + 1) % points.length;
                for (int i = 0; i < points.length; i++){
                    if (orientation(new Point(points[p][0], points[p][1]),
                            new Point(points[i][0], points[i][1]),
                            new Point(points[q][0], points[q][1])) < 0)
                        q = i;
                }
                for (int i = 0; i < points.length; i++){
                    if (i != p && i != q && orientation(new Point(points[p][0], points[p][1]),
                            new Point(points[i][0], points[i][1]),
                            new Point(points[q][0], points[q][1])) == 0 &&
                    inBetween(new Point(points[p][0], points[p][1]),
                            new Point(points[i][0], points[i][1]),
                            new Point(points[q][0], points[q][1])))
                        hull.add(new Point(points[i][0], points[i][1]));
                }
                hull.add(new Point(points[q][0], points[q][1]));
                p = q;
            }while (p != leftMost);
            int[][] result = new int[hull.size()][2];
            int i = 0;
            for (Iterator it = hull.iterator(); it.hasNext();){
                Point point = (Point)(it.next());
                result[i][0] = point.x;
                result[i][1] = point.y;
                i++;
            }
            return result;
        }
    }
}
