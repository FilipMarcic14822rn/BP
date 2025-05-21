package person.model.entities;

public class Test {
    private final int idTest;
    private String naziv;
    private int cena;

    public Test(int idTest, String naziv, int cena) {
        this.idTest = idTest;
        this.naziv = naziv;
        this.cena = cena;
    }
    public int getIdTest() {
        return idTest;
    }
    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public int getCena() {
        return cena;
    }
    public void setCena(int cena) {
        this.cena = cena;
    }
}
