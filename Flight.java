package pa2;

public class Flight {
    public final String id;
    public final double latDeg;
    public final double lonDeg;
    public final double trackDeg;   // 0°=North, 90°=East
    public final double hsKnots;    // horizontal speed (knots)
    public final double altFt;      // altitude (feet)
    public final double vsFpm;      // vertical speed (ft/min)

    public Flight(String id,
                  double latDeg, double lonDeg,
                  double trackDeg, double hsKnots,
                  double altFt, double vsFpm) {
        this.id = id;
        this.latDeg = latDeg;
        this.lonDeg = lonDeg;
        this.trackDeg = trackDeg;
        this.hsKnots = hsKnots;
        this.altFt = altFt;
        this.vsFpm = vsFpm;
    }

    @Override public String toString() {
        return "Flight{" +
               "id='" + id + '\'' +
               ", lat=" + latDeg +
               ", lon=" + lonDeg +
               ", trak=" + trackDeg +
               ", hs=" + hsKnots +
               ", alt=" + altFt +
               ", vs=" + vsFpm +
               '}';
    }

    // (Optional) equality by id is often convenient, but we won’t rely on it yet.
    @Override public int hashCode() { return id == null ? 0 : id.hashCode(); }
    @Override public boolean equals(Object o) {
        if (!(o instanceof Flight)) return false;
        return id != null && id.equals(((Flight) o).id);
    }
}