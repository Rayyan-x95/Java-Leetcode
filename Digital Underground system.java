import java.util.HashMap;

class UndergroundSystem {

    class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class RouteData {
        int totalTime;
        int trips;

        RouteData(int totalTime, int trips) {
            this.totalTime = totalTime;
            this.trips = trips;
        }
    }

    private HashMap<Integer, CheckInData> checkIns;
    private HashMap<String, RouteData> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckInData checkIn = checkIns.get(id);

        String route = checkIn.station + "->" + stationName;

        int travelTime = t - checkIn.time;

        RouteData data = routes.getOrDefault(route, new RouteData(0, 0));

        data.totalTime += travelTime;
        data.trips++;

        routes.put(route, data);

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        RouteData data = routes.get(route);

        return (double) data.totalTime / data.trips;
    }
}