package rs.ac.bg.fon.np.sc.commonlib.domen;

import com.google.gson.annotations.Expose;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SkiCentar implements OpstiDomenskiObjekat {

    @Expose
    private long sifraSkiCentra;
    @Expose
    private String nazivSkiCentra;
    @Expose
    private String nazivPlanine;
    @Expose
    private String radnoVreme;

    public SkiCentar() {

    }

    public SkiCentar(long sifraSkiCentra) {
        this.sifraSkiCentra = sifraSkiCentra;
    }

    public SkiCentar(long sifraSkiCentra, String nazivSkiCentra, String nazivPlanine, String radnoVreme) {
        this.sifraSkiCentra = sifraSkiCentra;
        this.nazivSkiCentra = nazivSkiCentra;
        this.nazivPlanine = nazivPlanine;
        this.radnoVreme = radnoVreme;
    }

    public long getSifraSkiCentra() {
        return sifraSkiCentra;
    }

    public void setSifraSkiCentra(long sifraSkiCentra) {
        this.sifraSkiCentra = sifraSkiCentra;
    }

    public String getNazivSkiCentra() {
        return nazivSkiCentra;
    }

    public void setNazivSkiCentra(String nazivSkiCentra) {
        this.nazivSkiCentra = nazivSkiCentra;
    }

    public String getNazivPlanine() {
        return nazivPlanine;
    }

    public void setNazivPlanine(String nazivPlanine) {
        this.nazivPlanine = nazivPlanine;
    }

    public String getRadnoVreme() {
        return radnoVreme;
    }

    public void setRadnoVreme(String radnoVreme) {
        this.radnoVreme = radnoVreme;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return (nazivSkiCentra == null ? null : "'" + nazivSkiCentra + "'") + ", "
                + (nazivPlanine == null ? null : "'" + nazivPlanine + "'") + ", "
                + (radnoVreme == null ? null : "'" + radnoVreme + "'");
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "nazivSkiCentra = "
                + (nazivSkiCentra == null ? null : "'" + nazivSkiCentra + "'") + ", " + "nazivPlanine = "
                + (nazivPlanine == null ? null : "'" + nazivPlanine + "'") + ", " + "radnoVreme = "
                + (radnoVreme == null ? null : "'" + radnoVreme + "'");
    }

    @Override
    public String vratiImeKlase() {
        return "SkiCentar";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {

        return "sifraSkiCentra= " + sifraSkiCentra;
    }

    @Override
    public String vratiUslovZaNadjiSlog2() {
        return "nazivSkiCentra LIKE '%" + nazivSkiCentra + "%'";
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
        SkiCentar sc = (SkiCentar) this;
        sc.setSifraSkiCentra(rs.getLong("sifraSkiCentra"));
        sc.setNazivSkiCentra(rs.getString("nazivSkiCentra"));
        sc.setNazivPlanine(rs.getString("nazivPlanine"));
        sc.setRadnoVreme(rs.getString("radnoVreme"));
    }

    @Override
    public String toString() {
        return nazivSkiCentra;
    }

    @Override
    public String vratiNazivPK() {
        return "sifraSkiCentra";
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new SkiCentar();
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
        final SkiCentar other = (SkiCentar) obj;
        if (this.sifraSkiCentra != other.sifraSkiCentra) {
            return false;
        }
        return true;
    }

    @Override
    public void postaviVrednostPK(long id) {
        this.sifraSkiCentra = id;
    }

    @Override
    public String vratiImenaAtrubita() {
        return "nazivSkiCentra, nazivPlanine, radnoVreme";
    }

    @Override
    public String vratiUslovZaPromeniSlog() {
        return "sifraSkiCentra = " + sifraSkiCentra;
    }

}
