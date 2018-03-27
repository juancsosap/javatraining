package Location;

public interface IPoint {
 
    public default double diff(IPoint other) throws IllegalArgumentException {
    	double[] p1Array = this.toArray();
    	double[] p2Array = other.toArray();
    	
    	if(p1Array.length == p2Array.length) {
    		int dimentions = p1Array.length;
    		
    		double delta2 = 0; 
    		for(int i=0; i<dimentions; i++)
    			delta2 += Math.pow(p1Array[i] - p2Array[i], 2);
    		
    		return Math.sqrt(delta2);
    	} else
    		throw new IllegalArgumentException("Invalid Values, the point must have the same amount of dimentions.");
    }

    public default void add(IPoint other) throws IllegalArgumentException {
    	double[] p1Array = this.toArray();
    	double[] p2Array = other.toArray();
    	
    	if(p1Array.length == p2Array.length) {
    		int dimentions = p1Array.length;
    		
    		double[] array = new double[dimentions]; 
    		for(int i=0; i<dimentions; i++)
    			array[i] = p1Array[i] + p2Array[i];
    		
    		this.fromArray(array);
    	} else
    		throw new IllegalArgumentException("Invalid Values, the point must have the same amount of dimentions.");
    }
    
    public default void reset() {
    	double[] array = new double[this.getDimentions()];
    	for(int i=0; i<this.getDimentions(); i++)
    		array[i] = 0;
    	this.fromArray(array);
    }
    
    public double[] toArray();
    public void fromArray(double[] array) throws IllegalArgumentException;
    public int getDimentions();
    
    public String toString();

}
