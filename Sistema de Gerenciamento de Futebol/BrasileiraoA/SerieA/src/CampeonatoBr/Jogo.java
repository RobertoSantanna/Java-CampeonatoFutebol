package CampeonatoBr;

import java.util.Date;

/**
 *
 * @author Marco Santana
 * @author Roberto Santana
 */

public class Jogo extends Clubes{
    
    private Clubes TimeA;
    private Clubes TimeB;
    private int SaldoA;
    private int SaldoB;
    private Date Data;
    
    
    public Clubes getTimeA() {
        return TimeA;
    }
    
    public Clubes getTimeB() {
        return TimeB;
    }
    
    public int getSaldoA(){
        return SaldoA;
    }
    
    public int getSaldoB(){
        return SaldoB;
    }
    
    public Date getData() {
        return Data;
    }
    
    public void setTimeA(Clubes TimeA) {
        this.TimeA = TimeA;
    }
    
    public void setTimeB(Clubes TimeB) {
        this.TimeB = TimeB;
    }
    
    public void setSaldoA(int SaldoA) {
        this.SaldoA = SaldoA;
    }
    
    public void setSaldoB(int SaldoB) {
        this.SaldoB = SaldoB;
    }
    
    public void setDate(Date Data) {
        this.Data = Data;
    }
}
