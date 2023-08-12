package CampeonatoBr;

import java.util.Comparator;

/**
 * @author Roberto Santana
 */

public class ModoComparar implements Comparator<Clubes> {
    
    @Override
    public int compare(Clubes t, Clubes  t1) {
        
        if(t.getPontos() > t1.getPontos()) 
            return -1;
        else 
            if (t.getPontos() < t1.getPontos())
                return 1;
            else {
                int goalDif = t.getContadorGolsMarcados()-t.getContadorGolsSofridos();
                int goalDif1 = t1.getContadorGolsMarcados()-t1.getContadorGolsSofridos();
                if(goalDif > goalDif1)
                    return -1;
                else
                    if(goalDif < goalDif1)
                        return 1;
                    else return 0;
            }        
    }
}
