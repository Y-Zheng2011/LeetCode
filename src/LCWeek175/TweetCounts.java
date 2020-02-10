import java.util.*;

public class TweetCounts {
    private Map<String, List<Integer>> record;
    private Map<String, Integer> del;
    private int maxTime;

    public TweetCounts() {
        maxTime = 0;
        record = new HashMap<>();
        del = new HashMap<>();
        del.put("minute", 60);
        del.put("hour", 3600);
        del.put("day", 24 * 3600);
    }

    public void recordTweet(String tweetName, int time) {
        maxTime = Math.max(time, maxTime);
        if (record.containsKey(tweetName)) {
            record.get(tweetName).add(time);
        } else {
            List<Integer> t = new ArrayList<>();
            t.add(time);
            record.put(tweetName, t);
        }
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int delta = del.get(freq);
        List<Integer> ret = new LinkedList<>();
        if (endTime < startTime) return ret;
        int[] count = new int[(endTime- startTime) / delta + 1];
        for (int time : record.get(tweetName)) {
            if (time > endTime || time < startTime) continue;
            int inteval = (time - startTime) / delta;
            count[inteval]++;
        }
        for (int c : count) {
            ret.add(c);
        }
        return ret;
    }

}
