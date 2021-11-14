public class Food extends Product {
    private int caloriesPer100G;
    private float fatPercent;

    public Food() {}
    
    public Food(int caloriesPer100G, float fatPercent) {
       this.caloriesPer100G = caloriesPer100G;
       this.fatPercent = fatPercent;
    }


}
