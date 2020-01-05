package tech.wec.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class OnlineElection_911 {

    // 我觉得用TreeMap更直观，二分查找是一个方式罢了
    class TopVotedCandidate {

        class Vote{
            int person;
            int time;

            public Vote(int person, int time){
                this.person = person;
                this.time = time;
            }
        }

        List<Vote> voteArray;

        public TopVotedCandidate(int[] persons, int[] times) {
            voteArray = new ArrayList<>();
            // key -> leader, value -> votes
            TreeMap<Integer, Integer> leaderMap = new TreeMap<>();
            int leader = -1; // current leader
            int votes = 0; // votes for current leader
             for (int i = 0; i < persons.length; i++){
                 int p = persons[i], t = times[i];
                 int cnt = leaderMap.getOrDefault(p, 0) + 1;
                 leaderMap.put(p, cnt);
                 if (cnt >= votes){
                    if (p != leader){
                        leader = p;
                        voteArray.add(new Vote(leader, t));
                    }
                    if (cnt > votes) votes = cnt;
                 }
             }
        }

        public int q(int t) {
            int low = 0, high = voteArray.size();
            while(low < high){
                int mid = low + (high - low) / 2;
                if (voteArray.get(mid).time <= t)
                    low = mid + 1;
                else
                    high = mid;
            }
            return voteArray.get(low - 1).person;
        }
    }
}
