package person.model.entities;

import java.time.LocalDate;

public class Prijava {
    private final int prijavaId;

    private LocalDate datum;

    private boolean prihvacena;

    private int terapeutId;
    private int klijentId;

    public Prijava(int prijavaId, LocalDate datum, boolean prihvacena, int terapeutId, int klijentId) {
        this.prijavaId = prijavaId;
        this.datum = datum;
        this.prihvacena = prihvacena;
        this.terapeutId = terapeutId;
        this.klijentId = klijentId;
    }

    public int getPrijavaId() {
        return prijavaId;
    }
    public LocalDate getDatum() {
        return datum;
    }
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
    public boolean isPrihvacena() {
        return prihvacena;
    }
    public void setPrihvacena(boolean prihvacena) {
        this.prihvacena = prihvacena;
    }
}
