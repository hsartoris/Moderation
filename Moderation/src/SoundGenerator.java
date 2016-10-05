import javax.sound.sampled.*;
import java.io.*;

public class SoundGenerator {
	/* SoundGenerator class for definitions common to all classes invoved with creating sound.
	 * So far just defines samplrate
	 */
	static final int SAMPLERATE = 44100; //samplerate, duh
	static final int bitDepth = 16;
	static final int channels = 1;
	static final boolean signed = true;
	static final boolean bigEndian = false;
	protected AudioFormat audioFormat = new AudioFormat(SAMPLERATE, bitDepth, channels, signed, bigEndian);
	
	
	static protected byte[] monoDoubleToByte(double[] in) {
		//converts an array of doubles corresponding with a mono sound signal to a byte array
		byte[] output = new byte[in.length];
		for (int i = 0; i < in.length; i++) {
			int tmp = (short) (in[i] * Integer.MAX_VALUE);
			output[i] = (byte) tmp;
		}
		return output;
	}
}
