package YFY.YasarFarukFinal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTServisi {

    private static final List<Haberci> HABERLER = new ArrayList<Haberci>();
    
    private Object kilit = new Object();
    
    @RequestMapping("/haberci/olustur")
    public synchronized Haberci haberciOlustur(String haber, String tarih){
        synchronized (kilit) {
            Haberci haberci = new Haberci(haber, tarih);
            HABERLER.add(haberci);
            return haberci;
        }
    }
    
    @RequestMapping("/haberci/listele")
    public synchronized List<Haberci> haberciListele(){
        synchronized (kilit) {
            if (HABERLER.size()>10) {
                return HABERLER.subList(0, 10);
            } else {
                return HABERLER;
            }
            
        }
    }
    
    @RequestMapping("/haberci/temizle")
    public String haberciTemizle(){
        synchronized (kilit) {
            HABERLER.clear();
            return "OK";
        }
    }
    
    
    
    
    
    
}
