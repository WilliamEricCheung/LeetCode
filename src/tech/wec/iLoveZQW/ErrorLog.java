package tech.wec.iLoveZQW;

import java.util.*;

public class ErrorLog {

    static class Pair{
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        private String key;
        private Integer value;

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private static Map<String, Integer> logs;

    public static void main(String[] args) {
        logs = new LinkedHashMap<>(); // to keep sequence ordering by adding time
        Scanner input = new Scanner(System.in);
        while(!input.hasNext("EOF")){
            String[] path = input.next().split("\\\\");
            String info = path[path.length - 1] + " " + input.next();
            logs.put(info, logs.getOrDefault(info, 0) + 1);
        }
        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: logs.entrySet()){
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }
        pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.value - p1.value;
            }
        });
        for (int i = 0; i < Math.min(8, pairs.size()); i++){
            String info = pairs.get(i).getKey();
            int len = info.split(" ")[0].length();
            if (len > 16)
                System.out.println(info.split(" ")[0].substring(len - 16) + " "+ info.split(" ")[1] + " " + pairs.get(i).getValue());
            else
                System.out.println(info + " " + pairs.get(i).getValue());
        }
    }
}
