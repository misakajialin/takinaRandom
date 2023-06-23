package ramdom;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
public class w extends JFrame {
	public w() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(341, 10, 93, 23);
		getContentPane().add(btnNewButton_1);
	}

		
		// ImageIcon i = new ImageIcon("src/images/6.gif");
		ImageIcon i = new ImageIcon(Test.class.getResource("/images/6.gif"));
		public static void Genshin(int[] ten){
			JFrame frame=new JFrame();
			JLabel lable=new JLabel(new Test().i);
			frame.getContentPane().add(lable);
			frame.setBounds(100, 100, 705, 425);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			
		
			
			Timer timer = new Timer(6500, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                lable.setVisible(false);
	                JLabel label_2=new JLabel();
	                label_2.setText(ten[0]+" "+ten[1]+" "+ten[2]+" "+ten[3]+" "+ten[4]+" "+ten[5]+" "+ten[6]+" "+ten[7]+" "+ten[8]+" "+ten[9]);
	                frame.getContentPane().add(label_2);
	                label_2.setFont(new Font("宋体", Font.BOLD, 40));
	                label_2.setHorizontalAlignment(SwingConstants.CENTER);
	                //停止定时器
	                ((Timer)e.getSource()).stop();
	            }
	        });
	        //启动定时器
	        timer.start();
	    	JButton btnNewButton = new JButton("跳过");
			btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
			btnNewButton.setBounds(80, 80, 11, 11);
			frame.getContentPane().add(btnNewButton);
			btnNewButton.setContentAreaFilled(false); //使按钮透明
			btnNewButton.setFocusPainted(false);//使按钮失焦

		}
}

