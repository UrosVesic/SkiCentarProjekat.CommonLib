/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.np.sc.commonLib.domen;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Domenska klasa koja predstavlja kupca ski pasa
 *
 * @author UrosVesic
 */
public class Kupac implements Serializable, OpstiDomenskiObjekat {

    /**
     * Jedinstveni identifikator kupca u bazi podataka
     */
    @Expose
    private long idKupca;
    /**
     * Broj licne karte kupca
     */
    @Expose
    private String brojLK;
    /**
     * Ime kupca
     */
    @Expose
    private String ime;
    /**
     * Prezime kupca
     */
    @Expose
    private String prezime;

    public Kupac() {
    }

    public Kupac(long idKupca) {
        this.idKupca = idKupca;
    }

    public Kupac(long idKupca, String brojLK, String ime, String prezime) {
        this.idKupca = idKupca;
        this.brojLK = brojLK;
        this.ime = ime;
        this.prezime = prezime;
    }

    @Override
    public String vratiImenaAtrubita() {
        return "brojLK, Ime, Prezime";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return (brojLK == null ? null : "'" + brojLK + "'") + ", "
                + (ime == null ? null : "'" + ime + "'") + ", "
                + (prezime == null ? null : "'" + prezime + "'");
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "brojLK = "
                + (brojLK == null ? null : "'" + brojLK + "'") + ", " + "ime = "
                + (ime == null ? null : "'" + ime + "'") + ", " + "prezime = "
                + (prezime == null ? null : "'" + prezime + "'");
    }

    @Override
    public String vratiImeTabeleZaKlasu() {
        return "Kupac";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idKupca= " + idKupca;
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
        this.setIdKupca(rs.getLong("idKupca"));
        this.setBrojLK(rs.getString("brojLK"));
        this.setIme(rs.getString("ime"));
        this.setPrezime(rs.getString("prezime"));
    }

    @Override
    public String vratiNazivPK() {
        return "idKupca";
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new Kupac();
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int i) {
        return null;
    }

    @Override
    public void postaviVrednostPK(long id) {
        this.setIdKupca(id);
    }

    /**
     * Vraca vrednost id-a
     *
     * @return id kao long
     */
    public long getIdKupca() {
        return idKupca;
    }

    /**
     * Postavlja vrednost id-a na zadatu vrednost
     *
     * @param idKupca vrednost na koju treba postaviti polje id
     */
    public void setIdKupca(long idKupca) {
        this.idKupca = idKupca;
    }

    public String getBrojLK() {
        return brojLK;
    }

    public void setBrojLK(String brojLK) {
        this.brojLK = brojLK;
    }

    /**
     * Vraca ime korisnika
     *
     * @return Ime kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja vrednost imena na zadatu vrednost
     *
     * @param ime vrednost na koju treba postaviti polje ime
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Vraca prezime korisnika
     *
     * @return Prezime kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja vrednost prezimena na zadatu vrednost
     *
     * @param prezime vrednost na koju treba postaviti polje prezime
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Vraca sve podatke o kupcu u jednom Stringu
     *
     * @return String sa svim podacima o kupcu
     */
    @Override
    public String toString() {
        return ime + " " + prezime + " - " + brojLK;
    }

    /**
     * Poredi kupce po atributu brojLK
     *
     * @param obj objekat sa kojim se poredi this objekat
     * @return
     * <ul>
     * <li>true - ako su brojevi licne karte isti</li>
     * <li>false - ako brojevi licne karte nisu isti</li>
     * </ul>
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kupac other = (Kupac) obj;
        if (!Objects.equals(this.brojLK, other.brojLK)) {
            return false;
        }
        return true;
    }

}
