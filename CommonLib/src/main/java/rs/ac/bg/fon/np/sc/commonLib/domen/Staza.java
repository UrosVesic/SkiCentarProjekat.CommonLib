package rs.ac.bg.fon.np.sc.commonLib.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Domenska klasa koja predstavlja stazu u ski centru
 *
 * @author UrosVesic
 */
public class Staza implements OpstiDomenskiObjekat, Serializable {

    /**
     * Jedinstveni identifikator staze u bazi
     */
    private long idStaze;
    /**
     * Oznaka staze
     */
    private String brojStaze;
    /**
     * Naziv staze
     */
    private String nazivStaze;
    /**
     * Tip staze(laka,srednja,teska)
     */
    private String tipStaze;
    /**
     * Ski centar u kome se nalazi staza
     */
    private SkiCentar skiCentar;

    public Staza() {

    }

    public Staza(long idStaze) {
        this.idStaze = idStaze;
    }

    public Staza(long id, String brojStaze, String nazivStaze, String tipStaze, SkiCentar skiCentar) {
        this.idStaze = id;
        this.brojStaze = brojStaze;
        this.nazivStaze = nazivStaze;
        this.tipStaze = tipStaze;
        this.skiCentar = skiCentar;
    }

    /**
     * Vraca jedinstveni identifikator staze u bazi
     *
     * @return idStaze kao long
     */
    public long getIdStaze() {
        return idStaze;
    }

    /**
     * Postavlja vrednost idStaze na zadatu vrednost
     *
     * @param idStaze Vrednost na koju treba postaviti polje idStaze
     */
    public void setIdStaze(long idStaze) {
        this.idStaze = idStaze;
    }

    /**
     * Vraca oznaku staze
     *
     * @return brojStaze kao String
     */
    public String getBrojStaze() {
        return brojStaze;
    }

    /**
     * Postavlja vrednost brojStaze na zadatu vrednost
     *
     * @param brojStaze Vrednost na koju treba postaviti polje brojStaze
     */
    public void setBrojStaze(String brojStaze) {
        this.brojStaze = brojStaze;
    }

    public String getNazivStaze() {
        return nazivStaze;
    }

    public void setNazivStaze(String nazivStaze) {
        this.nazivStaze = nazivStaze;
    }

    public String getTipStaze() {
        return tipStaze;
    }

    public void setTipStaze(String tipStaze) {
        this.tipStaze = tipStaze;
    }

    public SkiCentar getSkiCentar() {
        return skiCentar;
    }

    public void setSkiCentar(SkiCentar skiCentar) {
        this.skiCentar = skiCentar;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return (brojStaze == null ? null : "'" + brojStaze + "'") + ", " + (nazivStaze == null ? null : "'" + nazivStaze + "'") + ", "
                + (tipStaze == null ? null : "'" + tipStaze + "'") + ", "
                + (skiCentar == null ? null : skiCentar.getSifraSkiCentra());
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "brojStaze = "
                + (brojStaze == null ? null : "'" + brojStaze + "'") + ", " + "nazivStaze = "
                + (nazivStaze == null ? null : "'" + nazivStaze + "'") + ", " + "tipStaze = "
                + (tipStaze == null ? null : "'" + tipStaze + "'") + ", " + "sifraSkiCentra = "
                + (skiCentar == null ? null : skiCentar.getSifraSkiCentra());
    }

    @Override
    public String vratiImeTabeleZaKlasu() {
        return "Staza";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idStaze = " + idStaze;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "sifraSkiCentra = (SELECT sifraSkiCentra FROM skiCentar WHERE NazivSkiCentra LIKE '%"
                + skiCentar.getNazivSkiCentra() + "%')";
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {

        this.setIdStaze(rs.getLong("idStaze"));
        this.setBrojStaze(rs.getString("brojStaze"));
        this.setNazivStaze(rs.getString("nazivStaze"));
        this.setTipStaze(rs.getString("tipStaze"));
        this.setSkiCentar(new SkiCentar(rs.getLong("sifraSkiCentra")));

    }

    @Override
    public String vratiNazivPK() {
        return "brojStaze";
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new Staza();
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        return 1;
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int i) {
        if (i == 0) {
            return skiCentar;// new SkiCentar();
        }
        return null;
    }

    @Override
    public void postaviVrednostVezanogObjekta(OpstiDomenskiObjekat vezo, int i) {
        if (i == 0) {
            this.setSkiCentar((SkiCentar) vezo);
        }
    }

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
        final Staza other = (Staza) obj;
        if (this.idStaze != other.idStaze) {
            return false;
        }
        return true;
    }

    @Override
    public void postaviVrednostPK(long id) {
        this.idStaze = id;
    }

    @Override
    public String vratiImenaAtrubita() {
        return "brojStaze, nazivStaze, tipStaze, sifraSkiCentra";
    }

}
