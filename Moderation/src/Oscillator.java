
public class Oscillator extends SoundGenerator {

	private Waveform wf;
	public Oscillator() {
		// by default just create default instance of waveform
		wf = new Waveform();
	}
	
	public double[] testGet(double hz) {
		double[] output = new double[(int) (SAMPLERATE)];
		for (int i = 0; i < output.length; i++) {
			//output[i] = wf.sine((i * hz)/(SAMPLERATE * Waveform.PERIOD));
			output[i] = 1;
		}
		return output;
	}
	
	public double[][] get(double hz, double time) {
		// where time is in seconds
		double[][] output = {new double[(int) (SAMPLERATE * time)], new double[(int) (SAMPLERATE * time)]};
		for (int i = 0; i < output[0].length; i++) {
			output[0][i] = wf.get((i * hz)/(SAMPLERATE * Waveform.PERIOD));
		}
		return output;
	}

}
