package javatest;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestFrame extends JFrame {
	JLabel phone,message;
	JTextField phone_tf, message_tf;
	JButton send_btn,reset_btn;
	Container c;
	SmsDTO sdto;
	
	public TestFrame() {
		phone = new JLabel("��ȭ��ȣ");
		message = new JLabel("�޽���");
		phone_tf = new JTextField();
		message_tf = new JTextField();
		send_btn = new JButton("����");
		reset_btn = new JButton("�ʱ�ȭ");
		sdto = new SmsDTO();
		c = getContentPane();
		
		setSize(400,150);
		setTitle("����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new GridLayout(3,2));
		
		c.add(phone);
		c.add(phone_tf);
		c.add(message);
		c.add(message_tf);
		c.add(send_btn);
		c.add(reset_btn);
		
		send_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sdto.setPhone(phone_tf.getText());
				sdto.setMessage(message_tf.getText());
				SmsSend.��������(sdto.getPhone(), sdto.getMessage());
			}
		});
		
		reset_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				phone_tf.setText("");
				message_tf.setText("");
			}
		});
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestFrame();

	}

}
