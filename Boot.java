
/**
 * class Boot - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (versie nummer of datum)
 */
public class Boot
{
    private int x;
    private int y;
    private int grootte;
    private boolean horizontaal;

    public Boot(int x, int y, int grootte, boolean horizontaal){
        this.x = x;
        this.y = y;
        this.grootte = grootte;
        this.horizontaal = horizontaal;
    }

    public Boot(){
        this(2,3,4,true);
    }

    /**
     * Method toonBoot
     *
     */
    public void toonBoot(){
        for(int t = 0; t < grootte; t++){
            if(horizontaal){
                System.out.println((x+t) + "," + y);
            }
            else {
                System.out.println(x + "," + (y+t));
            }
        }   
    }

    public boolean isRaak(int raakX, int raakY){
        boolean raak = false;
        for(int t = 0; t < grootte; t++){
            if(horizontaal){
                if((raakX == (x+t)) && (raakY == y)){
                    raak = true;
                }
            }
            else{
                if((raakX == x) && (raakY == (y+t))){
                    raak = true;
                }        
            }
        }        
        return raak;
    }

    public boolean overlaptBoot(Boot nieuweBoot){
        boolean overlapt = false;
        for(int t = 0; t < grootte; t++){
            if(horizontaal){
                if(nieuweBoot.isRaak((x+t), y)){
                    overlapt = true;
                }
            }
            else{
                if(nieuweBoot.isRaak(x, (y+t))){
                    overlapt = true;
                }        
            }
        }        
        return overlapt;    
    }
}
