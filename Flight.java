package pa2;

import java.io.Serializable;

public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;

    public final String id;
    public final double latDeg, lonDeg;
    public final double trackDeg, hsKnots;
    public final double altFt, vsFpm;

    public Flight(String id, double latDeg, double lonDeg, double trackDeg,
                  double hsKnots, double altFt, double vsFpm) {
        this.id = id;
        this.latDeg = latDeg;
        this.lonDeg = lonDeg;
        this.trackDeg = trackDeg;
        this.hsKnots = hsKnots;
        this.altFt = altFt;
        this.vsFpm = vsFpm;
    }
}