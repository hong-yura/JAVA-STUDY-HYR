package Chapter06;

class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void turnOnOff() {
		// (1) isPowerOn 의 값이 true 면 false 로 , false 면 true 로 바꾼다.
		if(isPowerOn = true) {
			isPowerOn = false;
		} else if(isPowerOn = false) {
			isPowerOn = true;
		}
	}
	
	void volumeUp() {
		// (2) volume 의 값이 MAX_VOLUME 보다 작을 때만 값을 1 증가시킨다.
		if(volume < MAX_VOLUME) {
			volume++;
		}
	}
	
	void volumeDown() {
		// (3) volume 의 값이 MIN_VOLUME 보다 클 때만 값을 1 감소시킨다.
		if(volume > MIN_VOLUME) {
			volume--;
		}
	}
	
	void channelUp() {
		// (4) channel 의 값을 1 증가시킨다.
		// 만일 channel 이 MAX_CHANNEL 이면, channel 의 값을 MIN_CHANNEL 로 바꾼다.
		if(channel == MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		} else {
			channel++;			
		}
	}

	void channelDown() {
		// (5) channel 의 값을 1 감소시킨다.
		// 만일 channel 이 MIN_CHANNEL 이면, channel 의 값을 MAX_CHANNEL 로 바꾼다.
		if(channel == MIN_CHANNEL) {
			channel = MAX_CHANNEL;
		} else {
			channel--;			
		}
	}
	
} // class MyTv

public class Exercise6_21 {
	public static void main(String[] args) {
		MyTv t = new MyTv();
		
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH : " + t.channel + ", VOL : "+ t.volume);
		
		t.channelDown();
		t.volumeDown();
		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);
		
		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH : " + t.channel + ", VOL:" + t.volume);
	}
}


