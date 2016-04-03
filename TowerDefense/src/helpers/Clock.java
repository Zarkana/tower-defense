package helpers;

import org.lwjgl.Sys;

public class Clock {

	private static boolean paused = false;
	public static long lastFrame, totalTime;
	public static float d = 0, multiplier = 1;

	/**
	 * TODO write
	 * @return
	 */
	public static long getTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
	
	/**
	 * TODO write
	 * @return
	 */
	public static float getDelta() {
		long currentTime = getTime();
		int delta = (int)(currentTime - lastFrame);
		lastFrame = getTime();
		return delta * 0.01f;
	}
	
	/**
	 * TODO write
	 * @return
	 */
	public static float Delta() {
		if (paused) 
			return 0;
		else
			return d * multiplier;
	}

	/**
	 * TODO write
	 * @return
	 */	
	public static float TotalTime(){
		return totalTime;
	}

	/**
	 * TODO write
	 * @return
	 */	
	public static float Multiplier() {
		return multiplier;		
	}

	/**
	 * TODO write
	 * @return
	 */	
	public static void update() {
		d = getDelta();
		totalTime += d;
	}
	
	/**
	 * TODO write
	 * @param change
	 */
	public static void ChangeMultiplier(int change) {
		if(multiplier + change < -1 && multiplier + change > 7){
			
		}else{
			multiplier += change;
		}
	}
	/**
	 * Pauses and un-pauses the game
	 */
	public static void Pause() {
		if(paused)
			paused = false;
		else
			paused = true;
	}
	
}
