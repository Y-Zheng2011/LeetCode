import java.util.*;

public class GameEvents {

    static class event {
        String team;
        String player;
        int time;
        String timeString;
        char eventType;
        String subPlayer;

        event(String team, String player, int time, String timeString, char eventType, String subPlayer) {
            this.team = team;
            this.player = player;
            this.time = time;
            this.timeString = timeString;
            this.eventType = eventType;
            this.subPlayer = subPlayer;
        }
    }

    Map<Character, Integer> eventOrder = new HashMap<>();
    public List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
        eventOrder.put('G', 1);
        eventOrder.put('Y', 2);
        eventOrder.put('R', 3);
        eventOrder.put('S', 4);
        List<event> events = new ArrayList<>();

        process(team1, events1, events);
        process(team2, events2, events);

        Collections.sort(events, (o1, o2) -> {
            if (o1.time != o2.time) return o1.time - o2.time;
            if (!eventOrder.get(o1.eventType).equals(eventOrder.get(o2.eventType)))
                return eventOrder.get(o1.eventType) - eventOrder.get(o2.eventType);
            if (!o1.team.equals(o2.team)) return o1.team.compareTo(o2.team);
            return o1.player.compareTo(o2.player);
        });
        List<String> ret = new LinkedList<>();
        return ret;
    }

    void process(String team, List<String> e, List<event> events) {
        for (String s : e) {
            String[] parts = s.split(" ");
            String pn = "";

        }
    }
}
