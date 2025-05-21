package person.model.entities;

import java.time.LocalDate;

public class Klijent {
    private int klijentId;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private String pol;
    private String email;
    private String telefon;
    private String JMBG;

    public Klijent(int klijentId, String ime, String prezime, LocalDate datumRodjenja, String pol, String email, String telefon, String JMBG) {
        this.klijentId = klijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.email = email;
        this.telefon = telefon;
        this.JMBG = JMBG;
    }

    public void setKlijentId(int klijentId) {
        this.klijentId = klijentId;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public int getKlijentId() {
        return klijentId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getPol() {
        return pol;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getJMBG() {
        return JMBG;
    }
}
