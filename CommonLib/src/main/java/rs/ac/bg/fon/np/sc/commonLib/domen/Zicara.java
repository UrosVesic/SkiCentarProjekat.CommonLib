package rs.ac.bg.fon.np.sc.commonLib.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Zicara implements OpstiDomenskiObjekat, Serializable {

    private long SifraZicare;
    private String nazivZicare;
    private String radnoVreme;
    private int kapacitet;
    private boolean UFunkciji;
    private SkiCentar skiCentar;

    public Zicara() {

    }

    public Zicara(long SifraZicare, String nazivZicare) {
        this.SifraZicare = SifraZicare;
        this.nazivZicare = nazivZicare;
    }

    public Zicara(long SifraZicare, String NazivZicare, String RadnoVreme, int Kapacitet, boolean UFunkciji,
            SkiCentar skiCentar) {
        this.SifraZicare = SifraZicare;
        this.nazivZicare = NazivZicare;
        this.radnoVreme = RadnoVreme;
        this.kapacitet = Kapacitet;
        this.UFunkciji = UFunkciji;
        this.skiCentar = skiCentar;
    }

    public long getSifraZicare() {
        return SifraZicare;
    }

    public void setSifraZicare(long SifraZicare) {
        this.SifraZicare = SifraZicare;
    }

    public String getNazivZicare() {
        return nazivZicare;
    }

    public void setNazivZicare(String nazivZicare) {
        this.nazivZicare = nazivZicare;
    }

    public String getRadnoVreme() {
        return radnoVreme;
    }

    public void setRadnoVreme(String radnoVreme) {
        this.radnoVreme = radnoVreme;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public boolean isUFunkciji() {
        return UFunkciji;
    }

    public void setUFunkciji(boolean UFunkciji) {
        this.UFunkciji = UFunkciji;
    }

    public SkiCentar getSkiCentar() {
        return skiCentar;
    }

    public void setSkiCentar(SkiCentar skiCentar) {
        this.skiCentar = skiCentar;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return (nazivZicare == null ? null : "'" + nazivZicare + "'") + ", "
                + (radnoVreme == null ? null : "'" + radnoVreme + "'") + ", " + kapacitet + ", " + UFunkciji + ", "
                + (skiCentar == null ? null : skiCentar.getSifraSkiCentra());
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "nazivZicare = "
                + (nazivZicare == null ? null : "'" + nazivZicare + "'") + ", " + "radnoVreme = "
                + (radnoVreme == null ? null : "'" + radnoVreme + "'") + ", " + "kapacitet = " + kapacitet + ", "
                + "uFunkciji = " + UFunkciji + ", " + "sifraSkiCentra = "
                + (skiCentar == null ? null : skiCentar.getSifraSkiCentra());
    }

    @Override
    public String vratiImeTabeleZaKlasu() {
        return "Zicara";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "SifraZicare = " + SifraZicare;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "sifraSkiCentra = (SELECT sifraSkiCentra FROM skiCentar WHERE NazivSkiCentra LIKE '"
                + skiCentar.getNazivSkiCentra() + "')";
    }

    @Override
    public void napuni(ResultSet rs) throws SQLException {
        SifraZicare = rs.getLong("sifraZicare");
        nazivZicare = rs.getString("nazivZicare");
        radnoVreme = rs.getString("radnoVreme");
        kapacitet = rs.getInt("kapacitet");
        UFunkciji = rs.getBoolean("uFunkciji");
        skiCentar = new SkiCentar(rs.getLong("sifraSkiCentra"));

    }

    @Override
    public String vratiNazivPK() {
        return "SifraZicare";
    }

    @Override
    public OpstiDomenskiObjekat kreirajInstancu() {
        return new Zicara();
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        return 1;
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int i) {
        if (i == 0) {
            return skiCentar;
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
    public void postaviVrednostPK(long id) {
        this.SifraZicare = id;
    }

    @Override
    public String vratiImenaAtrubita() {
        return "nazivZicare, radnoVreme, kapacitet, UFunkciji, sifraSkiCentra";
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
        final Zicara other = (Zicara) obj;
        if (!Objects.equals(this.nazivZicare, other.nazivZicare)) {
            return false;
        }
        return true;
    }

}
