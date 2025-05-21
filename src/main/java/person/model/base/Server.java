package person.model.base;

import person.model.Person;
import person.model.entities.*;
import person.model.utility.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private static int idUlogovanog;

    private final List<Test> testovi = new ArrayList<>();
    private final List<Terapeut> terapeuti = new ArrayList<>();
    private final List<Seansa> seanse = new ArrayList<>();
    private final List<Prijava> prijave = new ArrayList<>();
    private final List<Klijent> klijenti = new ArrayList<>();

//    private Server() {
//        this.setPeople(JDBCUtils.selectAllFromPerson());
//    }


    public List<Test> getTestovi() {
        return testovi;
    }

    public List<Terapeut> getTerapeuti() {
        return terapeuti;
    }

    public List<Seansa> getSeanse() {
        return seanse;
    }

    public List<Prijava> getPrijave() {
        return prijave;
    }

    public List<Klijent> getKlijenti() {
        return klijenti;
    }

    public void setTerapeuti(Collection<Terapeut> terapeuti) {
        this.terapeuti.clear();
        this.terapeuti.addAll(terapeuti);
    }

    public void setTestovi(Collection<Test> testovi) {
        this.testovi.clear();
        this.testovi.addAll(testovi);
    }

    public void setSeansa(Collection<Seansa> seanse) {
        this.seanse.clear();
        this.seanse.addAll(seanse);
    }

    public void setPrijave(Collection<Prijava> prijave) {
        this.prijave.clear();
        this.prijave.addAll(prijave);
    }

    public void setKlijenti(Collection<Klijent> klijenti) {
        this.klijenti.clear();
        this.klijenti.addAll(klijenti);
    }

    public int getIdUlogovanog() {
        return idUlogovanog;
    }

    public void setIdUlogovanog(int idUlogovanog) {
        idUlogovanog=idUlogovanog;
    }

}
