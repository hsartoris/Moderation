import javax.sound.sampled.*;
import java.io.*;

public class AudioMaster extends SoundGenerator {
	public AudioMaster() {
		
	}
	
	public static void main(String[] args) {
		Oscillator osc = new Oscillator();
		double[][] test = osc.get(440, 1);
		byte[] test1 = osc.testGet(440);
		AudioMaster m = new AudioMaster();
		m.playDoubleArray(test1);
	}
	
	public void playDoubleArray(byte[] input) {
		SourceDataLine speaker = null;
		try { 
			DataLine.Info speakerInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
			speaker = (SourceDataLine) AudioSystem.getLine(speakerInfo);
		} catch (LineUnavailableException e){
			e.printStackTrace();
		}
		System.out.println("playing");
	    speaker.write(input, 0, input.length);
	}
}
