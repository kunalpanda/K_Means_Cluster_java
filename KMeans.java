import java.util.ArrayList; // all supporting imports
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//kmean algorithim class 
public class KMeans {
    
    List <Point> data = new ArrayList<Point>(); // dataset represented as an array list
    List <Cluster> clusters = new ArrayList<Cluster>(); //clusters represneted as an array list
    Map <Cluster, List<Point>> clusterPoints = new HashMap<>(); //List of clusters represented as key value pairs

    public static void main(String[] args) {
        
        int clusterNumber = 2; //declare amount of clusters
		KMeans demo = new KMeans(); // create object 
        //call all necessary methods 
		demo.generateData();
        demo.intializeClusterAndCentriod(clusterNumber);
        demo.printRecordInfo();
        demo.printClusterInfo();
    }

    private void generateData(){
        CSVHelper CSVRead = new CSVHelper("sample.csv"); // load csv file
        data = CSVRead.data; //import data from the csvHelper object
    }

    private void intializeClusterAndCentriod(int clusterNumber){
        int counter = 1; //counter for number of assigned points
        Iterator<Point> iterator = data.iterator(); //iterator for the dataset
        Point point = null;
        while (iterator.hasNext()){ //Loop over data points
            point = iterator.next();
            if (counter <= clusterNumber){ //Assign data point as a centriod
                point.setClusterNumber(counter);
                intializeCluster(counter, getRandomPoint());
                counter++;
            }
            else{
                double minDistance = Integer.MAX_VALUE; //Min distance from a point to a centriod
                Cluster whichCluster = null; //a point's assigned cluster

                for(Cluster cluster : clusters){ //loop over all clusters
                    double distance = cluster.calculateDist(point); //calculate distance from point to centriods
                    if(minDistance > distance) { //update min distance
                		minDistance = distance;
                		whichCluster = cluster;
                	}
                }
                point.setClusterNumber(whichCluster.getClusterNumber()); //assign cluster number
                whichCluster.updateCentriod(point); //update centriod data
                clusterPoints.get(whichCluster).add(point); //add point to its respective cluster in the Hash map
            }
        }
    }

    private void intializeCluster(int clusterNumber, Point point) { 
        Cluster cluster = new Cluster(clusterNumber, point.getX(), point.getY()); //create cluster object to make centriod
        clusters.add(cluster);
        List<Point> clusterPoint = new ArrayList<>(); //Array list to hold info about all points in each cluster
        clusterPoint.add(point); // add current centriod to cluster
        clusterPoints.put(cluster, clusterPoint); //add cluster to map
    }

    private void printRecordInfo(){ //print all data points
        System.out.println("********* Data Points *************");
        for(Point point : data){
            System.out.println(point);
        }
    }

    private void printClusterInfo(){ //print the info from the map to display each cluster and the data points in it
        System.out.println("********** Data Points Clustered ***************");
        for (Map.Entry<Cluster, List<Point>> entry : clusterPoints.entrySet()){
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue() + "\n");
        }
    }

    private Point getRandomPoint(){ //Get a random point from the data set to be the starting centriod
        Point point;
        int index = (int)(Math.random()*data.size());
        point = data.get(index);
        return point;
    }

}
