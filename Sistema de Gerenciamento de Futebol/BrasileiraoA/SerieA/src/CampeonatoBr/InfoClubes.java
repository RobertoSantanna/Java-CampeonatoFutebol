package CampeonatoBr;

/**
 *
 * @author Marco Santana
 * @author Roberto Santana
 */

public abstract class InfoClubes {
    
    private String name;
    private String location;
    private String statistics;
    
    @Override
    public boolean equals(Object o) {
        return this.name.equals(((InfoClubes)o).name);
    }
    
    
    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getStatistics() {
        return statistics;
    }
    
    public void setLocation(String s) {
        this.location = s;
    }
    
    public void setName(String s) {
        this.name = s;
    } 
    
    public void setStatistics(String s) {
        this.statistics = s;
    }   
    
}
