import java.util.ArrayList;

class PaintingJob{
	public static void main(String args[]){
		Job myJob = new Job();
		myJob.features.add(new Wall(10.2,6.1));
		myJob.features.add(new Round(4.8));
		// compute price of job
		double totalArea = 0.0;
		for (Feature feature:myJob.features){
			if (feature.type == FeatureType.ROUND)
				totalArea += 3.14 * (((Round) feature).radius) * (((Round) feature).radius);
			else
				totalArea += ((Wall)feature).length * ((Wall)feature).width;
		}
		System.out.println(String.format("Total area of job is %.2f metres squared", totalArea));
	}
}
	
enum FeatureType{WALL, ROUND};

class Job{
	public ArrayList<Feature> features = new ArrayList<Feature>();
}

class Feature{
  public FeatureType type;
}

class Wall extends Feature{
	public Wall(double length, double width){
		this.length = length;
		this.width = width;
		type = FeatureType.WALL;
	}
	public double length;
	public double width; 
}

class Round extends Feature{
	public Round(double radius){
		this.radius = radius;
		type = FeatureType.ROUND;
	}
	public double radius;
}