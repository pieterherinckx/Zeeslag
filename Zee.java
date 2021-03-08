import java.util.ArrayList;
import java.util.Random;
/**
* class Zee - geef hier een beschrijving van deze class
*
* @author (jouw naam)
* @version (versie nummer of datum)
*/
public class Zee
{
private int afmetingX;
private int afmetingY;
private ArrayList<Boot> botenlijst;

public Zee(int afmetingX, int afmetingY){
    this.afmetingX = afmetingX;
    this.afmetingY = afmetingY;
    this.botenlijst = new ArrayList<Boot>();
}

public Zee(){
    this(10,10);
}

public void voegBootToe(Boot nieuweBoot){
    if(!overlaptBoot(nieuweBoot)){
        botenlijst.add(nieuweBoot);
    }
}

public void toonBoten(){
    for (Boot boot: botenlijst){
        boot.toonBoot();
    }
}

public boolean isRaak(int raakX, int raakY){
    boolean raak = false;
    for (Boot boot: botenlijst){
        if(boot.isRaak(raakX, raakY)){
            raak = true;
        }
    }
    return raak;
}

public boolean overlaptBoot(Boot nieuweBoot){
    boolean overlapt = false;
    for (Boot boot: botenlijst){
        if(boot.overlaptBoot(nieuweBoot)){
            overlapt = true;
        }
    }        
    return overlapt;
}

public void maakWillekeurigeBoot(){
        Random rg = new Random();
        int x;
        int y;
        int grootte = rg.nextInt(5) + 2; 
        boolean horizontaal = rg.nextBoolean();        

        if(horizontaal){
            x = rg.nextInt(afmetingX - grootte + 1) + 1;
            y = rg.nextInt(afmetingY) + 1;
        }
        else {
            x = rg.nextInt(afmetingX) + 1;
            y = rg.nextInt(afmetingY - grootte + 1) + 1;
        }
  
        Boot nieuweBoot = new Boot(x, y, grootte, horizontaal);
        voegBootToe(nieuweBoot);
    }
}
