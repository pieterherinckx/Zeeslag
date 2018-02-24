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
    private int afmetingY;
    private int afmetingX;
    private ArrayList<Boot> botenlijst;

    public Zee(int afmetingX, int afmetingY){
        this.afmetingX =afmetingX;
        this.afmetingY = afmetingY;
        this.botenlijst = new ArrayList <Boot>();
    }

    public Zee(){
        this(10,10);
    }
    
    public void voegBootToe(Boot gegevenBoot){
        if(!overlaptBoot(gegevenBoot)){
            botenlijst.add(gegevenBoot);
        }
        else{
            System.out.println("De boot kan niet toegevoegd worden aangezien er een overlapping plaats vindt.");
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
            if(boot.isRaak(raakX,raakY)){
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
    
    public void willekeurigeBoot(){
        Random rg = new Random();
        boolean horizontaal = rg.nextBoolean();
        int grootte = rg.nextInt(3) + 2;
        int x;
        int y;
        if (horizontaal){
            x = rg.nextInt(afmetingX - grootte + 1);
            y = rg.nextInt(afmetingY);
        }
        else{
            x = rg.nextInt(afmetingX);
            y = rg.nextInt(afmetingY - grootte + 1);        
        }
        Boot boot = new Boot(x,y,grootte,horizontaal);
        voegBootToe(boot);
    }
}
