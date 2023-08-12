package CampeonatoBr;

/**
 *
 * @author Marco Santana
 * @author Roberto Santana
 */

public class Clubes extends InfoClubes {
    
    private int contadorVitoria;
    private int contadorEmpate;
    private int contadorDerrota;
    private int contadorGolsMarcados;
    private int contadorGolsSofridos;
    private int pontos;
    private int partidasJogadas;
    
    public int getContadorVitoria(){
        return contadorVitoria;
    }
    
    public int getContadorEmpate() {
        return contadorEmpate;
    }
    
    public int getContadorDerrota(){
        return contadorDerrota;
    }
    
    public int getContadorGolsMarcados() {
        return contadorGolsMarcados;
    }
    
    public int getContadorGolsSofridos() {
        return contadorGolsSofridos;
    }
    
    public int getPontos() {
        return pontos;
    }
    
    public int getPartidasJogadas() {
        return partidasJogadas;
    }
    
    public void setContadorVitoria(int i) {
        contadorVitoria=i;
    }
    
    public void setContadorEmpate(int i){
        contadorEmpate = i;
    }
    
    public void setContadorDerrota(int i) {
        contadorDerrota=i;
    }
    
    public void setContadorGolsMarcados(int i){
        contadorGolsMarcados = i;
    }
    
     public void setContadorGolsSofridos(int i){
        contadorGolsSofridos = i;
    }
     
     public void setPontos(int i){
        pontos = i;
    }
    
     public void setPartidasJogadas(int i){
        partidasJogadas = i;
    }    
}
