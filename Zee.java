import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Zee here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
        else {
            System.out.println("De boot kan niet toegevoegd worden omdat er een overlapping met een reeds bestaande boot zich voordoet.");
        }
    }

    public void toonBoten(){
        for(Boot boot: botenlijst){
            boot.toonBoot();
        }
    }

    public boolean isRaak(int raakX, int raakY){
        boolean raak = false;
        for(Boot boot: botenlijst){
            if(boot.isRaak(raakX, raakY)){
                raak = true;
            }
        }
        return raak;
    }

    public boolean overlaptBoot(Boot testboot){
        boolean overlapt = false;
        for(Boot boot: botenlijst){
            if(boot.overlaptBoot(testboot)){
                overlapt = true;
            }
        }
        return overlapt;
    }
    
    public void maakWillekeurigeBoot(){
        Random rg = new Random();
        boolean horizontaal = rg.nextBoolean();
        int grootte = rg.nextInt(4) + 2;
        int positieX;
        int positieY;
        if(horizontaal){
            positieX = rg.nextInt(afmetingX - grootte + 1) + 1;
            positieY = rg.nextInt(afmetingY) + 1;
        }
        else {
            positieX = rg.nextInt(afmetingX) + 1;
            positieY = rg.nextInt(afmetingY - grootte + 1) + 1;
        }
        Boot boot = new Boot(positieX, positieY, grootte, horizontaal);
        voegBootToe(boot);
    }

    public void testSchool(){
    
    }
    
}
