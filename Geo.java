package pa2;

public class Geo {
    private static final double R_NMI = 3440.065;

    private static double toRad(double deg){ return deg * Math.PI / 180.0; }

    public static double distanceNmi(double lat1, double lon1, double lat2, double lon2) {
        double φ1 = toRad(lat1), φ2 = toRad(lat2);
        double dφ = toRad(lat2 - lat1), dλ = toRad(lon2 - lon1);
        double a = Math.sin(dφ/2)*Math.sin(dφ/2)
                 + Math.cos(φ1)*Math.cos(φ2)*Math.sin(dλ/2)*Math.sin(dλ/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R_NMI * c;
    }
}