package product;

public class Cleaning extends Product {
    private int toxicityLevel;
    
    public Cleaning() {}

    public Cleaning(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
    }

    public int getToxicityLevel() {
        return toxicityLevel;
    }

    public void setToxicityLevel(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
    }
}
