package data.management.timeseries;

/**
 * The Linear class handles linear time series analysis.
 * 
 * This class is modeled after the static Math java class.
 * 
 * @author Ben Long
 *
 */
public final class Linear {

	/**
	 * Null constructor for the DataAnalysis class
	 * 
	 * The constructor is set to private to not allow instantiation of this class
	 * Methods are used by the client statically.
	 */
	private Linear() {}
	
	/**
	 * Calculates the mean of a time series.
	 * 
	 * @param data The time series to find the mean of (int)
	 * @return The mean of the time series
	 */
	public static double mean(int[] data) {
		if (data == null) {
			throw new NullPointerException();
		}
		
		int n = data.length;
    double mean = 0;
    
    //First, sum up the data
    for (int i = 0; i < n; i++) {
    	mean += data[i];
    }
		
    //Now divide by the length of the data (calculate the mean)
    mean = mean / n;
    
    return mean;
	}
	
	/**
	 * Calculates the mean of a time series.
	 * 
	 * @param data The time series to find the mean of (double)
	 * @return The mean of the time series
	 */
	public static double mean(double[] data) {
		int n = data.length;
    double mean = 0;
    
    //First, sum up the data
    for (int i = 0; i < n; i++) {
    	mean += data[i];
    }
		
    //Now divide by the length of the data (calculate the mean)
    mean = mean / n;
    
    return mean;
	}
	
	/**
	 * Calculates the standard deviation of a time series.
	 * 
	 * @param data The time series to find the standard deviation of (int)
	 * @return The standard deviation of a time series
	 */
	public static double standardDeviation(int[] data) {
		int n = data.length;
    double mean = mean(data), var = 0;
    
	  for (int i = 0; i < n; i++) {
	  	data[i] = (int) (data[i] - mean);
	  }
		
	  for (int i = 0; i < n; i++) {
	  	var += data[i] * data[i];
	  }
		
	  var = Math.sqrt(var / n);
	  
	  return var;
	}
	
	/**
	 * Calculates the standard deviation of a time series.
	 * 
	 * @param data The time series to find the standard deviation of (double)
	 * @return The standard deviation of a time series
	 */
	public static double standardDeviation(double[] data) {
		int n = data.length;
    double mean = mean(data), var = 0;
    
	  for (int i = 0; i < n; i++) {
	  	data[i] = data[i] - mean;
	  }
		
	  for (int i = 0; i < n; i++) {
	  	var += data[i] * data[i];
	  }
		
	  var = Math.sqrt(var / n);
	  
	  return var;
	}
	
	/**
	 * Calculates the coefficient of variation of a time series
	 * 
	 * @param data The time series to find the CV of (double)
	 * @return The CV of a time series
	 */
	public static double coefficientOfVariation(int[] data) {
		double mean = mean(data);
		double std = standardDeviation(data);
		
		double cv = (std / mean) * 100;
		
		return cv;
	}
	
	/**
	 * Calculates the coefficient of variation of a time series
	 * 
	 * @param data The time series to find the CV of (double)
	 * @return The CV of a time series
	 */
	public static double coefficientOfVariation(double[] data) {
		double mean = mean(data);
		double std = standardDeviation(data);
		
		double cv = (std / mean) * 100;
		
		return cv;
	}
	
	/**
	 * This method subtracts the mean from a time series
	 * 
	 * @param data The time series data to normalize
	 * @return The normalized data
	 */
	public static double[] normalizeByMean(double[] data) {
		int n = data.length;
    double mean = 0;
    
    //First, sum up the data
    for (int i = 0; i < n; i++) {
    	mean += data[i];
    }
		
    //Now divide by the length of the data (calculate the mean)
    mean = mean / n;
    
    //Now lets normalize by subtracting out the mean from the data set
	  for (int i = 0; i < n; i++) {
	  	data[i] = data[i] - mean;
	  }
	  
	  return data;
	}
	
	/**
	 * This method subtracts the mean from data, then divides the data by their
	 * standard deviation. 
	 * 
	 * @param data The time series data to normalize
	 * @return The normalized data
	 */
	public static double[] normalizeByStandardDeviation(double[] data) {

		int n = data.length;
    double mean = 0, var = 0;
    
    //First, sum up the data
    for (int i = 0; i < n; i++) {
    	mean += data[i];
    }
		
    //Now divide by the length of the data (calculate the mean)
    mean = mean / n;
    
    //Now lets normalize by subtracting out the mean from the data set
    //and lets calculate the standard deviation (SD) of the data to normalize by
	  for (int i = 0; i < n; i++) {
	  	data[i] = data[i] - mean;
	  }
		
	  for (int i = 0; i < n; i++) {
	  	var += data[i] * data[i];
	  }
		
	  var = Math.sqrt(var / n);
	  
	  //Finally, divide the data by the SD
    for (int i = 0; i < n; i++) {
    	data[i] = data[i] / var;
    }
    
		return data;
	}
}
