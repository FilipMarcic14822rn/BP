package person.model.utility;

import person.model.base.Server;
import person.model.entities.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    public static Connection connection = null;

    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "1234");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BP_Projekat", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Terapeuti
    public static List<Terapeut> selectAllFromTerapeut() {
        List<Terapeut> terapeuti = new ArrayList<>();
        String query = "select * from Terapeut";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int terapeutId = resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                String JMBG = resultSet.getString(4);
                LocalDate datumRodjenja = resultSet.getDate(5).toLocalDate();
                String telefon = resultSet.getString(6);
                String stepen = resultSet.getString(7);
                int id_kandidat = resultSet.getInt(8);
                int id_psihoterapeut = resultSet.getInt(9);
                int id_fakultet = resultSet.getInt(10);
                String email = resultSet.getString(11);
                String password = resultSet.getString(12);
                Terapeut terapeut = new Terapeut(terapeutId, ime, prezime, JMBG,
                        datumRodjenja, telefon, stepen, id_kandidat, id_psihoterapeut, id_fakultet, email, password);
                terapeuti.add(terapeut);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return terapeuti;
    }

    //Testovi
    public static List<Test> selectAllFromTest() {
        List<Test> testovi = new ArrayList<>();
        String query = "select * from Test";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int testId = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                int cena = resultSet.getInt(3);
                Test test = new Test(testId, naziv, cena);
                testovi.add(test);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return testovi;
    }

    //Seasne
    public static List<Seansa> selectAllFromSeanse() {
        List<Seansa> seanse = new ArrayList<>();
        String query = "select * from Seansa";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int seansaId = resultSet.getInt(1);
                LocalDate datum = resultSet.getDate(2).toLocalDate();
                float trajanje = resultSet.getFloat(3);
                int prijavaId = resultSet.getInt(4);
                String beleska = resultSet.getString(5);
                Seansa seansa = new Seansa(seansaId, datum, trajanje, beleska, prijavaId);
                seanse.add(seansa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return seanse;
    }

    //Prijave
    public static List<Prijava> selectAllFromPrijave() {
        List<Prijava> prijave = new ArrayList<>();
        String query = "select * from Prijava";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int prijavaId = resultSet.getInt(1);
                int terapeutId = resultSet.getInt(2);
                int klijentId = resultSet.getInt(3);
                LocalDate datum = resultSet.getDate(4).toLocalDate();
                boolean prihvacena = resultSet.getBoolean(5);
                Prijava prijava = new Prijava(prijavaId, datum, prihvacena, terapeutId, klijentId);
                prijave.add(prijava);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prijave;
    }

    public static List<Klijent> selectAllFromKlijent() {
        List<Klijent> klijenti = new ArrayList<>();
        String query = "select * from Klijent";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int klijentId = resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                LocalDate datumRodjenja = resultSet.getDate(4).toLocalDate();
                String pol = resultSet.getString(5);
                String email = resultSet.getString(6);
                String telefon = resultSet.getString(7);
                String JMBG = resultSet.getString(8);
                Klijent klijent = new Klijent(klijentId, ime, prezime,
                        datumRodjenja, pol, email, telefon, JMBG);
                klijenti.add(klijent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return klijenti;
    }


    public static List<Terapeut> selectFromTerapeut(String ime, String prezime, String jmbg,
                                                    LocalDate datumRodjenja, String telefon,
                                                    String stepen, String email, String password) {
        List<Terapeut> oldTerapeuti = selectAllFromTerapeut();
        Server.SERVER.setTerapeuti(oldTerapeuti);
        List<Terapeut> terapeuti = new ArrayList<>();

        for (Terapeut t : oldTerapeuti) {
            boolean matches = true;
            if (ime != null && !ime.isEmpty() &&
                    (t.getIme() == null || !t.getIme().toLowerCase().contains(ime.toLowerCase())))matches = false;
            if (prezime != null && !prezime.isEmpty() &&
                    (t.getPrezime() == null || !t.getPrezime().toLowerCase().contains(prezime.toLowerCase())))matches = false;
            if (jmbg != null && !jmbg.isEmpty() &&
                    (t.getJmbg() == null || !t.getJmbg().contains(jmbg)))matches = false;
            if (datumRodjenja != null &&
                    (t.getDatumRodjenja() == null || !t.getDatumRodjenja().equals(datumRodjenja)))matches = false;
            if (telefon != null && !telefon.isEmpty() &&
                    (t.getTelefon() == null || !t.getTelefon().contains(telefon)))matches = false;
            if (stepen != null && !stepen.isEmpty() &&
                    (t.getStepen() == null || !t.getStepen().toLowerCase().contains(stepen.toLowerCase())))matches = false;
            if (stepen != null && !stepen.isEmpty() &&
                    (t.getStepen() == null || !t.getStepen().toLowerCase().contains(stepen.toLowerCase())))matches = false;
            if (stepen != null && !stepen.isEmpty() &&
                    (t.getStepen() == null || !t.getStepen().toLowerCase().contains(stepen.toLowerCase())))matches = false;
            if (email != null && !email.isEmpty() &&
                    (t.getEmail() == null || !t.getEmail().contains(email)))matches = false;
            if (password != null && !password.isEmpty() &&
                    (t.getPassword() == null || !t.getPassword().contains(password))) matches = false;
            if (matches)terapeuti.add(t);
        }

        return terapeuti;
    }

    public static List<Seansa> selectFromSeanse(List<Seansa> sveSeanse, LocalDate datum, Float trajanje, String beleska) {
        List<Seansa> rezultat = new ArrayList<>();
        for (Seansa seansa : sveSeanse) {
            boolean matches = true;
            if (datum != null && !seansa.getDatum().equals(datum)) matches = false;
            if (trajanje != null && seansa.getTrajanje() != trajanje) matches = false;
            if (beleska != null && (seansa.getBeleska() == null || !seansa.getBeleska().toLowerCase().contains(beleska.toLowerCase()))) matches = false;
            if (matches) rezultat.add(seansa);
        }
        return rezultat;
    }

    public static List<Prijava> selectFromPrijave(List<Prijava> svePrijave, LocalDate datum, Boolean prihvacena) {
        List<Prijava> rezultat = new ArrayList<>();
        for (Prijava prijava : svePrijave) {
            boolean matches = true;
            if (datum != null && !prijava.getDatum().equals(datum)) matches = false;
            if (prihvacena != null && prijava.isPrihvacena() != prihvacena) matches = false;
            if (matches) rezultat.add(prijava);
        }
        return rezultat;
    }

    public static List<Test> selectFromTestovi(List<Test> sviTestovi, String naziv, Integer cena) {
        List<Test> rezultat = new ArrayList<>();
        for (Test test : sviTestovi) {
            boolean matches = true;
            if (naziv != null && !test.getNaziv().toLowerCase().contains(naziv.toLowerCase())) matches = false;
            if (cena != null && test.getCena() != cena) matches = false;
            if (matches) rezultat.add(test);
        }
        return rezultat;
    }

    public static List<Klijent> selectFromKlijent(String ime, String prezime, String jmbg,
                                                  LocalDate datumRodjenja, String telefon, String pol, String email) {
        List<Klijent> oldKlijenti = selectAllFromKlijent();
        Server.SERVER.setKlijenti(oldKlijenti);
        List<Klijent> klijenti = new ArrayList<>();

        for (Klijent k : oldKlijenti) {
            boolean matches = true;
            if (ime != null && !ime.isEmpty() &&
                    (k.getIme() == null || !k.getIme().toLowerCase().contains(ime.toLowerCase()))) matches = false;
            if (prezime != null && !prezime.isEmpty() &&
                    (k.getPrezime() == null || !k.getPrezime().toLowerCase().contains(prezime.toLowerCase()))) matches = false;
            if (jmbg != null && !jmbg.isEmpty() &&
                    (k.getJMBG() == null || !k.getJMBG().contains(jmbg))) matches = false;
            if (datumRodjenja != null &&
                    (k.getDatumRodjenja() == null || !k.getDatumRodjenja().equals(datumRodjenja))) matches = false;
            if (telefon != null && !telefon.isEmpty() &&
                    (k.getTelefon() == null || !k.getTelefon().contains(telefon))) matches = false;
            if (pol != null && !pol.isEmpty() &&
                    (k.getPol() == null || !k.getPol().toLowerCase().contains(pol.toLowerCase()))) matches = false;
            if (email != null && !email.isEmpty() &&
                    (k.getEmail() == null || !k.getEmail().toLowerCase().contains(email.toLowerCase()))) matches = false;

            if (matches) klijenti.add(k);
        }

        return klijenti;
    }

    public static void insertIntoKlijent(String ime, String prezime, LocalDate datumRodjenja,
                                         String pol, String email, String telefon, String jmbg) {
        String query = "INSERT INTO Klijent (ime, prezime, datum_rodjenja, pol, email, telefon, jmbg) " +
                "VALUES (?, ?, str_to_date(?, '%m/%d/%Y'), ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, ime);
            statement.setString(2, prezime);
            statement.setString(3, datumRodjenja.getMonthValue() + "/" +
                    datumRodjenja.getDayOfMonth() + "/" + datumRodjenja.getYear());
            statement.setString(4, pol);
            statement.setString(5, email);
            statement.setString(6, telefon);
            statement.setString(7, jmbg);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoPrijava(LocalDate datumPrijave, int klijentId, int terapeutId) {
        String query = "INSERT INTO Prijava (datum_prijave, klijent_id, terapeut_id) " +
                "VALUES (str_to_date(?, '%m/%d/%Y'), ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, datumPrijave.getMonthValue() + "/" +
                    datumPrijave.getDayOfMonth() + "/" + datumPrijave.getYear());
            statement.setInt(2, klijentId);
            statement.setInt(3, terapeutId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoSeansa(LocalDate datum, int trajanje, int prijavaId) {
        String query = "INSERT INTO Seansa (datum, trajanje, prijava_id) " +
                "VALUES (str_to_date(?, '%m/%d/%Y'), ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, datum.getMonthValue() + "/" +
                    datum.getDayOfMonth() + "/" + datum.getYear());
            statement.setInt(2, trajanje);
            statement.setInt(3, prijavaId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoSertifikovaniPsihoterapeut(String ime, String prezime, LocalDate datumRodjenja,
    String telefon, String stepen, String jmbg,int id_fakultet, String email, String password, int Oblast){
        String query = "INSERT INTO Sertifikovani_Psihoterapeut (Oblast)" +
                "VALUES (?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Oblast);
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int id_psihoterapeut = -1;
            if (generatedKeys.next()) {
                id_psihoterapeut = generatedKeys.getInt(1); // usually the primary key
            }
            insertIntoTerapeut(ime, prezime, datumRodjenja, telefon, stepen, jmbg, null, id_psihoterapeut, id_fakultet, password, email);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoKandidat(String ime, String prezime, LocalDate datumRodjenja,
                                          String telefon, String stepen, String jmbg,int id_fakultet, String email, String password, int Centar){
        String query = "INSERT INTO Kandidat (id_centar)" +
                "VALUES (?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, terapeut.getIdTerapeut());
            statement.setInt(1, Centar);
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int id_kandidat = -1;
            if (generatedKeys.next()) {
                id_kandidat = generatedKeys.getInt(1); // usually the primary key
            }
            insertIntoTerapeut(ime, prezime, datumRodjenja, telefon, stepen, jmbg, id_kandidat, null, id_fakultet, password, email);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void insertIntoTerapeut(String ime, String prezime, LocalDate datumRodjenja,
                                           String telefon, String stepen, String jmbg,Integer id_kandidat,
                                           Integer id_psihoterapeut, int id_fakultet, String password, String email) {
        String query = "INSERT INTO Terapeut (ime, prezime, datum_rodjenja, telefon, stepen, jmbg, email, password) " +
                "VALUES (?, ?, str_to_date(?, '%m/%d/%Y'), ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, ime);
            statement.setString(2, prezime);
            statement.setString(3, datumRodjenja.getMonthValue() + "/" +
                    datumRodjenja.getDayOfMonth() + "/" + datumRodjenja.getYear());
            statement.setString(4, telefon);
            statement.setString(5, stepen);
            statement.setString(6, jmbg);
            statement.setString(7, password);
            statement.setString(8, email);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoTest(String naziv, String opis, int seansaId) {
        String query = "INSERT INTO Test (naziv, opis, seansa_id) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, naziv);
            statement.setString(2, opis);
            statement.setInt(3, seansaId);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Oblast> selectAllFromOblasti(){
        List<Oblast> oblasti = new ArrayList<>();
        String query = "select * from Oblast";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String naziv = resultSet.getString(2);

                Oblast oblast = new Oblast(id, naziv);
                oblasti.add(oblast);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return oblasti;
    }

    public static List<Fakultet> selectAllFromFakulteti(){
        List<Fakultet> fakulteti = new ArrayList<>();
        String query = "select * from Fakultet";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                int idUniverziteta = resultSet.getInt(3);

                Fakultet fakultet = new Fakultet(id, naziv, idUniverziteta);
                fakulteti.add(fakultet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fakulteti;
    }

//    public static void insertIntoPerson(String firstName, String lastName, LocalDate dateOfBirth) {
//        String query = "insert into person (first_name, last_name, date_of_birth)" +
//                "values (?, ?, str_to_date(?, '%m/%d/%Y'))";
//        try {
//            PreparedStatement statement = connection.prepareStatement(query);
//            connection.setAutoCommit(false);
//            statement.setString(1, firstName);
//            statement.setString(2, lastName);
//            statement.setString(3,
//                    dateOfBirth.getMonthValue() + "/" +
//                    dateOfBirth.getDayOfMonth() + "/" + dateOfBirth.getYear());
//            statement.executeUpdate();
//            connection.commit();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private JDBCUtils() {

    }

}
