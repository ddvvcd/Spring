package sub1;

public class SamsungTV {
	
	private Speaker spk;
	
	public void powerOn() {
		System.out.println("SamsungTV powerOn...");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV powerOff...");
	}
	
	public void soundUp() {
		spk.soundUp();
	}
	
	public void soundDown() {
		spk.soundDown();
	}
}
