package pa2;

import java.io.Serializable;

/*
The class represents a single aircraft's state at a given moment.
It stores position, altitude, speed, and climb/descent rate.
*/
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;

    public final String id; // flight id
    public final double latDeg, lonDeg; // lat and long
    public final double trackDeg, hsKnots; // heading direction and horizontal speed
    public final double altFt, vsFpm; // altitude and vertical speed

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