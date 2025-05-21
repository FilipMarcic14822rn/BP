package person.model.entities;

public class Fakultet {
    private int id;
    private String naziv;
    private int idUniverziteta;

    public Fakultet(int id, String naziv, int idUniverziteta) {
        this.id = id;
        this.naziv = naziv;
        this.idUniverziteta = idUniverziteta;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getIdUniverziteta() {
        return idUniverziteta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setIdUniverziteta(int idUniverziteta) {
        this.idUniverziteta = idUniverziteta;
    }
}
