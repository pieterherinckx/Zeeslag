
/**
 * Write a description of class Boot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boot
{
    private int positieX;
    private int positieY;
    private int grootte;    
    private boolean horizontaal;

    
    public Boot(int positieX, int positieY, int grootte, boolean horizontaal){
        this.positieX = positieX;        
        this.positieY = positieY;
        this.grootte = grootte;        
        this.horizontaal = horizontaal;
    }
    
    public Boot(){
        this(3,3,3,true);
    }
    
    public void toonBoot(){
        for(int i=0;i<grootte;i++){
            if(horizontaal){
                System.out.println((positieX+i)+","+positieY);
            }
            else{
                System.out.println(positieX+","+(positieY+i));
            }
        }
    }
    
    public boolean isRaak(int x, int y){
        boolean raak = false;
        for(int i=0;i<grootte;i++){
            if(horizontaal){
                if((x == (positieX+i)) && (y == positieY)){
                    raak = true;
                }
            }
            else{
                if((x == positieX) && (y == (positieY+i))){
                    raak = true;
                } 
            }
        }
        return raak;
    } 
    
    public boolean overlaptBoot(Boot testboot){
        boolean overlapt = false;
        for(int i=0;i<grootte;i++){
            if(horizontaal){
                if(testboot.isRaak((positieX+i),positieY)){
                    overlapt = true;
                }
            }
            else{
                if(testboot.isRaak(positieX,(positieY+i))){
                    overlapt = true;
                }            
            }
        }
        return overlapt;
    }
}
