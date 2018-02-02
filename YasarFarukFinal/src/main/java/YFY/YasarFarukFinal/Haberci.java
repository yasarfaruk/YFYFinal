//YasarFarukYILMAZ//
//H5160020//

package YFY.YasarFarukFinal;

public class Haberci {
    public static int COUNT = 0;
    private int id;
    private String haber;
    private String tarih;
    public Haberci(String haber, String tarih) {
        this.id = COUNT;
        this.haber = haber;
        this.tarih = tarih;
    }
    public String getHaber() {
        return haber;
    }
    public String getTarih() {
        return tarih;
    }
    
}
