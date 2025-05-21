package person.model.entities;

public class Oblast {
    private int id;
    private String naziv;

    public Oblast(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }
}
