package data.management.timeseries;

/**
 * The NonLinear class handles non linear time series analysis.
 * 
 * This class is modeled after the static Math java class.
 * 
 * @author Ben Long
 *
 */
public final class NonLinear {
	
	/**
	 * Null constructor for the DataAnalysis class
	 * 
	 * The constructor is set to private to not allow instantiation of this class
	 * Methods are used by the client statically.
	 */
	public NonLinear() {}
	
	/**
	 * Calculate SampleEntropy of a signal
	 * 
	 * @param data The data to find the sample entropy of
	 * @return The sample entropy of a time series
	 */
	public double sampleEntropy(float[] data) {
		//TODO: finish this method
		return 0.0;
	}
	
	/**
	 * Perform Detrended Fluctuation Analysis
	 * 
	 * @param seq Input data array
   * @param npts Number of input points
   * @param nfit Order of detrending (2: linear, 3: quadratic, etc.)
   * @param rs Array of box sizes (uniformly distributed on log scale)
   * @param nr Number of entries in rs[] and mse[]
   * @param sw Mode (0: non-overlapping windows, 1: sliding window)
	 * @param data The data to perform DFA on
	 * @return The DFA array
	 */
	public double[] dfa(float[] data,long npts,int nfit,long[] rs,int nr,int sw) {
		//TODO: finish this method
		double[] dfa = new double[nr];
		return dfa;
	}
}
