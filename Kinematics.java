package pa2;

public class Kinematics {
    private static final double R_NMI = 3440.065;   // Earth radius in nautical miles
    private static final double FT_PER_NMI = 6076.12;

    private static double toRad(double deg){ return deg * Math.PI / 180.0; }
    private static double toDeg(double rad){ return rad * 180.0 / Math.PI; }

    public static double feetToNmi(double ft){ return ft / FT_PER_NMI; }
    public static double nmiToFeet(double nmi){ return nmi * FT_PER_NMI; }

    // Horizontal components (East, North) in nmi/s from track (0=N, 90=E) and speed in knots
    public static double[] velocityEN_NmiPerSec(double trackDeg, double hsKnots){
        double sp = hsKnots / 3600.0;            // nmi/s
        double th = toRad(trackDeg);
        double vn = sp * Math.cos(th);
        double ve = sp * Math.sin(th);
        return new double[]{ve, vn};
    }

    // Small-angle plane at lat0: Δnorth ≈ 60 nmi/deg, Δeast ≈ 60*cos(lat0) nmi/deg
    public static double[] deltaEN_Nmi(double lat1, double lon1, double lat2, double lon2){
        double lat0 = Math.toRadians((lat1 + lat2) * 0.5);
        double dN = (lat2 - lat1) * 60.0;
        double dE = (lon2 - lon1) * 60.0 * Math.cos(lat0);
        return new double[]{dE, dN};
    }

    // Move (lat,lon) along track by distance (nmi), great-circle destination formula.
    public static double[] moveAlong(double latDeg, double lonDeg, double trackDeg, double distNmi){
        double phi1 = toRad(latDeg);
        double lam1 = toRad(lonDeg);
        double th = toRad(trackDeg);
        double dR = distNmi / R_NMI;

        double sinPhi1 = Math.sin(phi1), cosPhi1 = Math.cos(phi1);
        double sinDR = Math.sin(dR), cosDR = Math.cos(dR);

        double sinPhi2 = sinPhi1 * cosDR + cosPhi1 * sinDR * Math.cos(th);
        double phi2 = Math.asin(sinPhi2);

        double y = Math.sin(th) * sinDR * cosPhi1;
        double x = cosDR - sinPhi1 * sinPhi2;
        double lam2 = lam1 + Math.atan2(y, x);

        // Normalize lon to [-180, 180]
        double lon2 = (toDeg(lam2) + 540.0) % 360.0 - 180.0;
        return new double[]{toDeg(phi2), lon2};
    }
}