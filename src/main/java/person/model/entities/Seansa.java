package person.model.entities;

import java.time.LocalDate;

public class Seansa {
    private final int seansaId;

    private LocalDate datum;

    private String beleska;

    private int prijavaId;

    private float trajanje;

    public Seansa(int seansaId, LocalDate datum, float trajanje, String beleska, int prijavaId) {
        this.seansaId = seansaId;
        this.datum = datum;
        this.beleska = beleska;
        this.trajanje = trajanje;
        this.prijavaId = prijavaId;
    }

    public Seansa(int seansaId, LocalDate datum, float trajanje, int prijavaId) {
        this.seansaId = seansaId;
        this.datum = datum;
        this.trajanje = trajanje;
        this.prijavaId = prijavaId;
    }

    public int getSeansaId() {
        return seansaId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getBeleska() {
        return beleska;
    }

    public float getTrajanje() {
        return trajanje;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setBeleska(String beleska) {
        this.beleska = beleska;
    }

    public void setTrajanje(float trajanje) {
        this.trajanje = trajanje;
    }

    public int getPrijavaId() {
        return prijavaId;
    }

    public void setPrijavaId(int prijavaId) {
        this.prijavaId = prijavaId;
    }
}
