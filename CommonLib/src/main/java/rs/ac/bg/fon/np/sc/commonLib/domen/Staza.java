package rs.ac.bg.fon.np.sc.commonlib.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Staza implements OpstiDomenskiObjekat, Serializable {

    private long idStaze;
    private String brojStaze;
    private String nazivStaze;
    private String tipStaze;
    private SkiCentar skiCentar;

    public Staza() {

    }

    public Staza(long id, String brojStaze, String nazivStaze, String tipStaze, SkiCentar skiCentar) {
        this.idStaze = id;
        this.brojStaze = brojStaze;
        this.nazivStaze = nazivStaze;
        this.tipStaze = tipStaze;
        this.skiCentar = skiCentar;
    }

    public long getIdStaze() {
        return idStaze;
    }

    public void setIdStaze(long idStaze) {
        this.idStaze = idStaze;
    }

    public String getBrojStaze() {
        return brojStaze;
    }

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
        return brojStaze + ", " + (nazivStaze == null ? null : "'" + nazivStaze + "'") + ", "
                + (tipStaze == null ? null : "'" + tipStaze + "'") + ", "
                + (skiCentar == null ? null : skiCentar.getSifraSkiCentra());
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "brojStaze = " + brojStaze + ", " + "nazivStaze = "
                + (nazivStaze == null ? null : "'" + nazivStaze + "'") + ", " + "tipStaze = "
                + (tipStaze == null ? null : "'" + tipStaze + "'") + ", " + "sifraSkiCentra = "
                + (skiCentar == null ? null : skiCentar.getSifraSkiCentra());
    }

    @Override
    public String vratiImeKlase() {
        return "Staza";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "brojStaze = " + brojStaze;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        // return "tipStaze LIKE '" + tipStaze + "'";
        return "sifraSkiCentra = (SELECT sifraSkiCentra FROM skiCentar WHERE NazivSkiCentra LIKE '"
                + skiCentar.getNazivSkiCentra() + "')";
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {

        Staza s = (Staza) this;
        s.setIdStaze(rs.getLong("idStaze"));
        s.setBrojStaze(rs.getString("brojStaze"));
        s.setNazivStaze(rs.getString("nazivStaze"));
        s.setTipStaze(rs.getString("tipStaze"));
        SkiCentar sc = new SkiCentar();
        sc.setSifraSkiCentra(rs.getLong("sifraSkiCentra"));
        s.setSkiCentar(sc);

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
        if (this.brojStaze != other.brojStaze) {
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
