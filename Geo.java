package pa2;

/*
 The class provides methods for computing distances between two points.
 It uses the haversine formula to calculate the distance in nautical miles (nmi).
 */
public class Geo {
    private static final double R_NMI = 3440.065; // radius of earth

    private static double toRad(double deg){ return deg * Math.PI / 180.0; } // degrees to rad

    public static double distanceNmi(double lat1, double lon1, double lat2, double lon2) {
        double latitude = toRad(lat1); // convert to rad
        double longitude = toRad(lat2); // difference in latitude
        double latDiff = toRad(lat2 - lat1); // difference in longitude
        double longDiff = toRad(lon2 - lon1);

        // aversine formula
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2)
                 + Math.cos(latitude) * Math.cos(longitude)
                 * Math.sin(longDiff / 2) * Math.sin(longDiff / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R_NMI * c;
    }
}