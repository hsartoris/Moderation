import javax.sound.sampled.*;
import java.io.*;
import javazoom.jl.player.StdPlayer;

public class AudioMaster extends SoundGenerator {
	public static void main(String[] args) {
		Oscillator osc = new Oscillator();
		double[][] test = osc.get(440, 1);
		double[] test1 = new double[441000];
		for (int i = 0; i < test1.length; i++) {
			test1[i] = 0.0;
		}
		StdPlayer.playWave(test1);
	}
}
