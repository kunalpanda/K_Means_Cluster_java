public class Point{
    private double x;
    private double y;
    private int clusterNumber;

    public Point(double x, double y){
        super();
        this.x = x;
        this.y = y;
    }

   public void setClusterNumber(int clusterNumber) {
       this.clusterNumber = clusterNumber;
   }
   public int getClusterNumber() {
       return clusterNumber;
   }
   public void setX(double x) {
       this.x = x;
   }
   public double getX() {
       return x;
   }
   public double getY() {
       return y;
   }
   @Override
   public String toString() {
       return ("Point: X = " + x + " Y = " + y);
   }
}