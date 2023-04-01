public class Cluster {
    private double xCentriod;
    private double yCentriod;
    private int clusterNumber;

    public Cluster(int clusterNumber, double xCentriod, double yCentriod){
        super();
        this.clusterNumber = clusterNumber;
        this.xCentriod = xCentriod;
        this.yCentriod = yCentriod;
    }

    public int getClusterNumber() {
        return clusterNumber;
    }
    public void setClusterNumber(int clusterNumber) {
        this.clusterNumber = clusterNumber;
    }
    public double getxCentriod() {
        return xCentriod;
    }
    public void setxCentriod(double xCentriod) {
        this.xCentriod = xCentriod;
    }
    public double getyCentriod() {
        return yCentriod;
    }
    public void setyCentriod(double yCentriod) {
        this.yCentriod = yCentriod;
    }
    @Override
    public String toString() {
        return (" Cluster Number = " + clusterNumber + ": Cluster: X Centriod = " + xCentriod + ", Y Centriod = " + yCentriod);
    }

    public double calculateDist(Point point){
        return Math.sqrt(Math.pow(getxCentriod() - point.getX(), 2) + Math.pow(getyCentriod() - point.getY(), 2));
    }

    public void updateCentriod(Point point){
        setxCentriod((getxCentriod()+point.getX())/2);
        setyCentriod((getyCentriod()+point.getY())/2);
    }

}
