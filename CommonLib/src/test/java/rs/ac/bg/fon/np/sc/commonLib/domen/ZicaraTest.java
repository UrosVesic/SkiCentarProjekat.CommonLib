/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.np.sc.commonLib.domen;

import java.sql.ResultSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author UrosVesic
 */
public class ZicaraTest {

    private Zicara odo;
    @Mock
    private ResultSet rs;

    @BeforeEach
    public void setUp() {
        odo = new Zicara();

    }

    @AfterEach
    public void tearDown() {
        odo = null;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/zicara/vrati_vrednosti_atributa.csv")
    public void vratiVrednostiAtributaTest(String nazivZicare, String radnoVreme, int kapacitet, boolean UFunkciji, Long sifraSkiCentra, String rezultat) {
        odo.setNazivZicare(nazivZicare);
        odo.setRadnoVreme(radnoVreme);
        odo.setKapacitet(kapacitet);
        odo.setUFunkciji(UFunkciji);
        if (sifraSkiCentra != null) {
            odo.setSkiCentar(new SkiCentar(sifraSkiCentra));
        }

        String str = odo.vratiVrednostiAtributa();
        Assertions.assertThat(str).isEqualTo(rezultat);
    }

    @Test
    public void vratiImenaAtrubitaTest() {
        Assertions.assertThat(odo.vratiImenaAtrubita()).isEqualTo("nazivZicare, radnoVreme, kapacitet, UFunkciji, sifraSkiCentra");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/zicara/postavi_vrednosti_atributa.csv")
    public void postaviVrednostiAtributaTest(String nazivZicare, String radnoVreme, int kapacitet, boolean UFunkciji, Long sifraSkiCentra, String rezultat) {
        odo.setNazivZicare(nazivZicare);
        odo.setRadnoVreme(radnoVreme);
        odo.setKapacitet(kapacitet);
        odo.setUFunkciji(UFunkciji);
        if (sifraSkiCentra != null) {
            odo.setSkiCentar(new SkiCentar(sifraSkiCentra));
        }
        String str = odo.postaviVrednostiAtributa();
        Assertions.assertThat(str).isEqualTo(rezultat);
    }

    @Test
    public void vratiImeKlaseTest() {
        Assertions.assertThat(odo.vratiImeTabeleZaKlasu()).isEqualTo("Zicara");
    }

    @Test
    public void vratiUslovZaNadjiSlogTest() {
        long id = 23;
        odo.setSifraZicare(id);
        Assertions.assertThat(odo.vratiUslovZaNadjiSlog()).isEqualTo("SifraZicare = 23");
    }
    
    @Test
    public void vratiUslovZaNadjiSlogoveTest(){
        odo.setSkiCentar(new SkiCentar(0, "Kopaonik", null, null));
        Assertions.assertThat(odo.vratiUslovZaNadjiSlogove()).isEqualTo("sifraSkiCentra = (SELECT sifraSkiCentra FROM skiCentar WHERE NazivSkiCentra LIKE 'Kopaonik')");
    }
    
    @ParameterizedTest
    @CsvSource({"0", "1"})
    public void vratiVezaniObjekatTest(int i) {
        SkiCentar sc = new SkiCentar(123);
        odo.setSkiCentar(sc);
        if (i == 0) {
            Assertions.assertThat(odo.vratiVezaniObjekat(i)).isEqualTo(sc);
        } else {
            Assertions.assertThat(odo.vratiVezaniObjekat(i)).isEqualTo(null);
        }
    }
    
    @ParameterizedTest
    @CsvSource({"0", "1"})
    public void postaviVrednostVezanogObjektaTest(int i) {
        SkiCentar sc = new SkiCentar(123);
        odo.postaviVrednostVezanogObjekta(sc, i);
        if (i == 0) {
            Assertions.assertThat(odo.vratiVezaniObjekat(i)).isEqualTo(sc);
        } else {
            Assertions.assertThat(odo.vratiVezaniObjekat(i)).isEqualTo(null);
        }
    }

    @Test
    public void napuniTest() throws Exception {
        AutoCloseable ac = MockitoAnnotations.openMocks(this);

        BDDMockito.given(rs.getLong("sifraZicare")).willReturn(1l);
        BDDMockito.given(rs.getString("nazivZicare")).willReturn("Pancicev vrh");
        BDDMockito.given(rs.getString("radnoVreme")).willReturn("09-17");
        BDDMockito.given(rs.getInt("kapacitet")).willReturn(2000);
        BDDMockito.given(rs.getBoolean("uFunkciji")).willReturn(true);
        BDDMockito.given(rs.getLong("sifraSkiCentra")).willReturn(2l);

        odo.napuni(rs);
        Assertions.assertThat(odo.getSifraZicare()).isEqualTo(1);
        Assertions.assertThat(odo.getNazivZicare()).isEqualTo("Pancicev vrh");
        Assertions.assertThat(odo.getRadnoVreme()).isEqualTo("09-17");
        Assertions.assertThat(odo.getKapacitet()).isEqualTo(2000);
        Assertions.assertThat(odo.isUFunkciji()).isEqualTo(true);
        Assertions.assertThat(odo.getSkiCentar().getSifraSkiCentra()).isEqualTo(2l);

        ac.close();
    }

    @Test
    public void vratiNazivPKTest() {
        Assertions.assertThat(odo.vratiNazivPK()).isEqualTo("SifraZicare");
    }

    @Test
    public void kreirajInstancuTest() {
        Zicara z = new Zicara();
        Assertions.assertThat(odo.kreirajInstancu()).isEqualTo(z);
    }

    @Test
    public void vratiBrojVezanihObjekataTest() {
        Assertions.assertThat(odo.vratiBrojVezanihObjekata()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"123", "321", "231"})
    public void postaviVrednostPKTest(long id) {
        odo.postaviVrednostPK(id);
        Assertions.assertThat(odo.getSifraZicare()).isEqualTo(id);
    }

}
