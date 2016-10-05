
public class Oscillator extends SoundGenerator {

	private double amplitude = 0;
	
	private Waveform wf;
	public Oscillator() {
		// by default just create default instance of waveform
		amplitude = (double) Byte.MAX_VALUE;
		wf = new Waveform();
	}
	
	public byte[] testGet(double hz) {
		byte[] output = new byte[(int) (SAMPLERATE)];
		for (int i = 0; i < output.length; i++) {
			//System.out.print(wf.sine((i * hz)/(SAMPLERATE * Waveform.PERIOD)) + ": ");
			output[i] = (byte) (amplitude * wf.sine((i * hz)/(SAMPLERATE * Waveform.PERIOD)));
			//System.out.print(output[i] + "; ");
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
