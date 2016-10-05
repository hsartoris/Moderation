
public class Waveform {
/*
 * stores a function that defines a waveform.
 * 
 */
	static final double PERIOD = 1; //defines the period of the waveform for arbitrary input.
	
	private double triLvl = 0; // ranges 0.0 - 1.0
	private double sineLvl = 0; // same
	private double squareLvl = 0; // also same
	private double sawLvl = 0;
	
	public Waveform() {
		// initializes to a pure sinewave at 1.0 amplitude
		sineLvl = 1;
	}
	
	public Waveform(double triLevel, double sineLevel, double squareLevel, double sawLevel) {
		triLvl = triLevel;
		sineLvl = sineLevel;
		squareLvl = squareLevel;
		sawLvl = sawLevel;
	}
	
	public double get(double x) {
		// gets the output of the configured waveform
		return ((tri(x) * triLvl) + (sine(x) * sineLvl) + (square(x) * squareLvl) + (saw(x) * sawLvl));
	}
	
	public double tri(double x) {
		/*
		 * One of the three basic waveforms
		 * Returns based on x, where x falls somewhere on the x-axis
		 * outputs range [-1,1]; -2 for error
		 * 
		 * triangle wave
		 */
		if (x < 0) return -2;
		x = x % PERIOD;
		if (x <= PERIOD/4) return x / (PERIOD/4);
		if (x > PERIOD/4 && x <= 3*PERIOD/4) return 2 - (4 * x / PERIOD);
		return -4 + (4 * x/ PERIOD);
	}
	
	public double sine(double x) {
		/*
		 * sine wave 
		 */
		if (x < 0) return -2;
		x = x % PERIOD;
		return Math.sin((x / PERIOD) * 2 * Math.PI);
	}
	
	public double square(double x) {
		/*
		 * square wave
		 */
		x = x % PERIOD;
		if (x <= PERIOD / 2) return 1;
		return 0;
	}
	
	public double saw(double x) {
		/*
		 * saw wave
		 */
		x = x % PERIOD;
		return 1 - (2 * x);
	}
	
}
