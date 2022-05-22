package Chapter07;

import java.awt.*;
import java.awt.event.*;

// Exercise7_28
// 아래의 EventHandler 를 익명 클래스(anonymous class)로 변경하시오.
public class Exercise7_28 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.addWindowListener(new EventHandler());
	}
}

class EventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}
}
