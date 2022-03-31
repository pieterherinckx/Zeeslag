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
    private ArrayList<Boot> lijst;

    public Zee(int afmetingX, int afmetingY){
        this.afmetingX = afmetingX;
        this.afmetingY = afmetingY;
        lijst = new ArrayList<>();
    }

    public Zee(){
        this(10,10);
    }

    public void voegBootToe(Boot nieuweBoot){
        if(!overlaptBoot(nieuweBoot)){
            lijst.add(nieuweBoot);
        }
        else{
            System.out.println("De boot kan niet toegevoegd worden wegens overlapping");
        }
    }

    public void toonBoten(){
        for(Boot testboot: lijst){
            testboot.toonBoot();
        }
    }

    public boolean isRaak(int raakX, int raakY){
        boolean raak = false;
        for(Boot testboot: lijst){
            if(testboot.isRaak(raakX, raakY)){
                raak = true;
            }
        }
        return raak;
    }

    public boolean overlaptBoot(Boot nieuweBoot){
        boolean overlapt = false;
        for(Boot testboot: lijst){
            if(testboot.overlaptBoot(nieuweBoot)){
                overlapt = true;
            }
        }
        return overlapt;
    }

    public void maakWillekeurigeBoot(){
        Random random = new Random();
        int grootte = random.nextInt(4)+2;
        boolean horizontaal = random.nextBoolean();
        int x;
        int y;
        if(horizontaal){
            x = random.nextInt(afmetingX - grootte + 1);
            y = random.nextInt(afmetingY);
        }
        else{
            x = random.nextInt(afmetingX);
            y = random.nextInt(afmetingY - grootte + 1);
        }
        Boot nieuweBoot = new Boot(x, y, grootte, horizontaal);
        voegBootToe(nieuweBoot);
    }
}
