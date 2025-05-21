package person.model.entities;

import java.time.LocalDate;

public class Terapeut {
    private final int idTerapeut;
    private String ime;
    private String prezime;
    private String jmbg;
    private LocalDate datumRodjenja;
    private String telefon;
    private String stepen;
    private Integer idKandidat;       // Nullable
    private Integer idPsihoterapeut;  // Nullable
    private int idFakultet;
    private String email;
    private String password;

    public Terapeut(int idTerapeut, String ime, String prezime, String jmbg,
                    LocalDate datumRodjenja, String telefon, String stepen,
                    Integer idKandidat, Integer idPsihoterapeut, int idFakultet,
                    String email, String password) {
        this.idTerapeut = idTerapeut;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumRodjenja = datumRodjenja;
        this.telefon = telefon;
        this.stepen = stepen;
        this.idKandidat = idKandidat;
        this.idPsihoterapeut = idPsihoterapeut;
        this.idFakultet = idFakultet;
        this.email = email;
        this.password = password;
    }

    public int getIdTerapeut() {
        return idTerapeut;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getStepen() {
        return stepen;
    }

    public void setStepen(String stepen) {
        this.stepen = stepen;
    }

    public Integer getIdKandidat() {
        return idKandidat;
    }

    public void setIdKandidat(Integer idKandidat) {
        this.idKandidat = idKandidat;
    }

    public Integer getIdPsihoterapeut() {
        return idPsihoterapeut;
    }

    public void setIdPsihoterapeut(Integer idPsihoterapeut) {
        this.idPsihoterapeut = idPsihoterapeut;
    }

    public int getIdFakultet() {
        return idFakultet;
    }

    public void setIdFakultet(int idFakultet) {
        this.idFakultet = idFakultet;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
