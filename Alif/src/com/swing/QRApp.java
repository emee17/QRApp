package com.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRApp extends JFrame 
{
	private static final long serialVersionUID = -7582039312264469946L;
	JPanel jp;
	JButton b1;
	JLabel l1,l2;
	JTextField t;
	
	QRApp()
	{
		jp = new JPanel();
		jp.setBackground(UIManager.getColor("TextArea.selectionBackground"));
		b1 = new JButton();
		b1.setFont(new Font("Tahoma", Font.BOLD, 14));
		b1.setToolTipText("Enter to submit");
		b1.setBackground(new Color(255, 160, 122));
		l1 = new JLabel();
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2 = new JLabel("> ");
		l2.setForeground(new Color(0, 0, 255));
		t = new JTextField (40);
		t.setFont(new Font("Candara", Font.PLAIN, 15));
		t.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		t.setToolTipText("Write");
		
		setVisible(true);
		getContentPane().setLayout(new FlowLayout());
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("QR Generator");
		setContentPane(jp);
		jp.setLayout(null);
		
		/*jp.setBackground(Color.BLUE);*/
		l1.setBounds(20, 20, 250, 30);
		l2.setBounds(20,50,246,30);
		t.setBounds(16, 90, 250, 60);
		b1.setBounds(16, 158, 250, 30);
		
		getContentPane().add(b1); getContentPane().add(l1); getContentPane().add(l2); getContentPane().add(t);
		l1.setText("Enter Your Details to generate QR");
		l2.setAlignmentX(CENTER_ALIGNMENT);
		b1.setText("Enter");
		
		
		b1.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(java.awt.event.ActionEvent e)
					{
						try {
							qrcode();
							
						} catch (IOException e1) {
							e1.printStackTrace();
							
						}
						l2.setText("> Succesfully Generated : "+t.getText());
						t.setText("");
					}
				});
		t.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				try {
					qrcode();
					
				} catch (IOException e1) {
					e1.printStackTrace();
					
				}
				l2.setText("> Succesfully Generated : "+t.getText());
				t.setText("");
			}
		});
		
		
	}
	
	
	public void qrcode() throws IOException 
	{
		boolean b = true;
		ByteArrayOutputStream  out = QRCode.from(t.getText()).to(ImageType.JPG).stream();
		
		
		File f = new File("D:\\Downloads\\AppQR.jpg"); //creation of  file
		
		FileOutputStream fos = new FileOutputStream(f);
		
		fos.write(out.toByteArray());
		fos.flush();
		
		
	}
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
				{
					public void run()
					{
						QRApp app = new QRApp();
						app.setVisible(true);
					}
				});
		
	}

}
