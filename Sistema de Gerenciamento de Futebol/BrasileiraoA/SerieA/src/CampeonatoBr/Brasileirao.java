
package CampeonatoBr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Marco Nascimento
 * @author Roberto Santana
 */


//Aqui é onde começa a classe Brasileirao
//Ela implementa GerenciaLiga 
public class Brasileirao implements GerenciaLiga {
    
    private final int numeroTime;
    private final ArrayList<Clubes> liga;
    private final Scanner scanner;
    private final ArrayList<Jogo> jogos;
    
    public Brasileirao(int numeroTime) {
        
        this.numeroTime = numeroTime;
        liga = new ArrayList<>();
        jogos = new ArrayList<>();
        scanner = new Scanner(System.in);
        exibirMenu();
    }
    
    public void exibirMenu() {
        while(true) {
            System.out.println("Menu do Brasileirão serie A: \n");
            System.out.println("Criar / Adicionar um novo time no Brasileirão (digite 1) \n");
            System.out.println("Exclui um time que existe no Brasileirão (digite 2) \n");
            System.out.println("Exibir estatísticas do time (digite 3) \n");
            System.out.println("Exibir tabela do Brasileirão (digite 4) \n");
            System.out.println("Adicionar um jogo (digite 5) \n");
            System.out.println("Exibir calendário e encontrar jogo (digite 6) \n");
            String line = scanner.nextLine();
            int aux = 0;

            try {
                aux = Integer.parseInt(line);
            } catch (Exception e) {
        }

            switch(aux) {
                case 1:
                   criarTime();
            break;
                case 2:
                    excluirTime();
                    break;
                case 3:
                    exibirEstatisticas();
                  break;
                case 4:
                    exibirTabela();
                  break;
                case 5:
                    criarJogo();
                   break;
                case 6:
                    exibirCalendario();
                   break;
            default:
            System.out.println("Comando inválido!");
        }
    } 
   }
    public void criarTime(){
        if(liga.size() == numeroTime) {
            System.out.println("Não pode adicionar mais clubes no Brasileirão");
            return;
        }
        
        Clubes time = new Clubes();
        System.out.println("Digite um time: ");
        String line = scanner.nextLine();
        time.setName(line);
        
        if(liga.contains(time)){
            System.out.println("Esse time já está no Brasileirão!");
            return;
        }
        System.out.println("De onde é o time: ");
        line = scanner.nextLine();
        time.setLocation(line);
        liga.add(time);   
    }

    private void excluirTime() {
        System.out.println("Digite um time: ");
        String line = scanner.nextLine();
         for(Clubes time : liga) {
             if(time.getName().equals(line)){
                liga.remove(time);
                 System.out.println("Time "+ time.getName()+" Excluído com sucesso!");
                 return;
             }
         }
         System.out.println("Não tem esse clube no Brasileirão!");
    }
    
    private void exibirEstatisticas() {
        
        System.out.println("Digite um time: ");
        String line = scanner.nextLine();
         for (Clubes time : liga) {
             if(time.getName().equals(line)){
                 System.out.println("Time " + time.getName()+ " Jogo(s) ganho(s): " + time.getContadorVitoria());
                 System.out.println("Time " + time.getName()+ " Jogo(s) perdido(s): " + time.getContadorDerrota());
                 System.out.println("Time " + time.getName()+ " Empate(s): " + time.getContadorEmpate());
                 System.out.println("Time " + time.getName()+ " Saldo de gols: " + time.getContadorGolsMarcados());
                 System.out.println("Time " + time.getName()+ " Gols sofridos: " + time.getContadorGolsSofridos());
                 System.out.println("Time " + time.getName()+ " Ponto(s): " + time.getPontos());
                 System.out.println("Time " + time.getName()+ " Partidas jogada(s): " + time.getPartidasJogadas());
                 return;
             }
         }
         System.out.println("Não tem esse clube no Brasileirão!");
    } 
    
    private void exibirTabela() {
        
        Collections.sort(liga, new ModoComparar());
        for(Clubes time : liga) {
            System.out.println("Time: " + time.getName()+" Pontos: "+ time.getPontos()+" Diferença de gols: "+ (time.getContadorGolsMarcados() - time.getContadorGolsSofridos()));
    }    
  }
    
    private void criarJogo(){
        System.out.println("Qual data do jogo? (formato mes-dia-ano): ");
        String line = scanner.nextLine();
        Date date;
        try {
            date = new SimpleDateFormat("MM-dd-yyyy").parse(line);
        } catch (ParseException ex) {
            System.out.println("Tem que ser assim : (formato mes-dia-ano)");
            return;
        }
        System.out.println("Digite o time da casa: ");
        line = scanner.nextLine();
        Clubes casa = null;
          for(Clubes time : liga){
              if(time.getName().equals(line))
                  casa = time;
          }  
          if (casa == null) {
              System.out.println("Não tem esse clube no Brasileirão!");
              return;
          }
          System.out.println("Digite o time de fora: ");
          line = scanner.nextLine();
          Clubes fora = null;
           for(Clubes time : liga){
              if(time.getName().equals(line))
              fora = time;
          } 
           if (fora == null) {
              System.out.println("Não tem esse clube no Brasileirão!");
              return;
          }
           
           System.out.println("Gols do time da casa: ");
           line = scanner.nextLine();
           int golsCasa = -1;
             try {
                golsCasa = Integer.parseInt(line);                
             } catch (Exception e) { 
    }
         if (golsCasa == -1) {
             System.out.println("Tem que colocar o número de gols");
             return;
         }
         
         System.out.println("Gols do time de fora: ");
           line = scanner.nextLine();
           int golsFora = -1;
             try {
                golsFora = Integer.parseInt(line);                
             } catch (Exception e) { 
    }
         if (golsFora == -1) {
             System.out.println("Tem que colocar o número de gols");
             return;
         }
         
         Jogo jogo = new Jogo();
         jogo.setDate(date);
         jogo.setTimeA(casa);
         jogo.setTimeB(fora);
         jogo.setSaldoA(golsCasa);
         jogo.setSaldoB(golsFora);
         jogos.add(jogo);
         casa.setContadorGolsMarcados(casa.getContadorGolsMarcados()+golsCasa);
         fora.setContadorGolsMarcados(fora.getContadorGolsMarcados()+golsFora);
         casa.setContadorGolsSofridos(casa.getContadorGolsSofridos()+golsFora);
         fora.setContadorGolsSofridos(fora.getContadorGolsSofridos()+golsCasa);
         casa.setPartidasJogadas(casa.getPartidasJogadas()+1);
         fora.setPartidasJogadas(fora.getPartidasJogadas()+1);
         
         if (golsCasa > golsFora) {            
            casa.setPontos(casa.getPontos()+3);
            casa.setContadorVitoria(casa.getContadorVitoria()+1);
            fora.setContadorDerrota(fora.getContadorDerrota()+1);
         }
         
         else if (golsCasa < golsFora) {            
            fora.setPontos(fora.getPontos()+3);
            fora.setContadorVitoria(fora.getContadorVitoria()+1);
             casa.setContadorDerrota(casa.getContadorDerrota()+1);
         }
         else {
            casa.setPontos(casa.getPontos()+1);
            fora.setPontos(fora.getPontos()+1);
             casa.setContadorEmpate(casa.getContadorEmpate()+1);
             fora.setContadorEmpate(fora.getContadorEmpate()+1);
         }      
    } 
    
    private void exibirCalendario() {
        
        System.out.println("Digite o ano: ");
        String line = scanner.nextLine();
         int Y = -7777;
           try {
               Y = Integer.parseInt(line);
           } catch (Exception e) { 
    }
         if (Y == -7777) {
             System.out.println("Tem que digitar o ano!");
             return;
         }
    
          System.out.println("Digite o mês: ");
          line = scanner.nextLine();
          int M = 0;
           try {
               M = Integer.parseInt(line);
           } catch (Exception e) { 
    }
         if (M == 0) {
             System.out.println("Tem que digitar o mês!");
             return;
         }
         
         String[] meses = {
            "",
             "Janeiro", "Fevereiro", "Março",
             "Abril", "Maio", "Junho",
             "Julho", "Agosto", "Setembro",
             "Outubro", "Novembro", "Dezembro"  
         };
         
         int[] dias = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
         
         if (M == 2 && isLeapYear(Y)) dias[M] = 29;
         
         System.out.println("    " + meses[M] + " " + Y);
         System.out.println("D  S  T  Q  Q  S  S");
         
         int d = day(M, 1, Y);
         //String space = "";
         
         for (int i = 0; i < d; i++)
             System.out.print("   ");
         for (int i = 1; i <= dias[M]; i++) {
             if (i<10)
                 System.out.print(i +"  ");
             else 
                 System.out.print(i+" ");
             if (((i + d) % 7 == 0) || (i == dias[M])) System.out.println();
         }
         
         System.out.println("Digite o dia: ");
         line = scanner.nextLine();
         int D = 0;
           try {
               D= Integer.parseInt(line);
           }  catch (Exception e) {             
           }
       if (D == 0 || dias[M] < D) {
           System.out.println("Tem que digitar o dia");
           return;
       }  
       
       Calendar cal = Calendar.getInstance();
       cal.set(Y, M-1, D);
       for (Jogo m : jogos) {
           Calendar cal2 = Calendar.getInstance();
           cal2.setTime(m.getData());
            if (cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) || cal.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)) {
                System.out.println(m.getTimeA().getName()+ " "+m.getSaldoA() + " : "+ m.getSaldoB()+ " "+ m.getTimeB().getName());
            }
       }   
    } 
   
    public int day(int M, int D, int Y) {
        int y = Y - (14 - M) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = M + 12 * ((14-M) / 12) - 2;
        int d = (D + x + (31*m)/12) % 7;
        return d;
    }
    
    public boolean isLeapYear(int year) {
        
        if ((year % 4 ==0) && (year % 100 !=0 )) return true;
        if (year % 400 == 0) return true;
        return false;  
    }

    public int getPontos() {
        return 0;
    }
} 
    
    
    
    

