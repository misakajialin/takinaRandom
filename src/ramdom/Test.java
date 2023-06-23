package ramdom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
public class Test {

	public void setTenVisible(JFrame frame,int[] ten,JButton btnNewButton_1,JLabel lable) {
		lable.setVisible(false);
        btnNewButton_1.setVisible(false);
		JLabel label_2=new JLabel();
        label_2.setText(ten[0]+" "+ten[1]+" "+ten[2]+" "+ten[3]+" "+ten[4]+" "+ten[5]+" "+ten[6]+" "+ten[7]+" "+ten[8]+" "+ten[9]);
        //frame.add(label_2);
        frame.getContentPane().add(label_2);
        label_2.setFont(new Font("宋体", Font.BOLD, 40));
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	// ImageIcon i = new ImageIcon("src/images/6.gif");
	ImageIcon i = new ImageIcon(Test.class.getResource("/images/6.gif"));
	public static void Genshin(int[] ten){
		JFrame frame=new JFrame();
		JButton btnNewButton_1 = new JButton("跳过");
		btnNewButton_1.setBounds(620, 10, 59, 23);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("微软雅宋", Font.BOLD,12));
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setFocusPainted(false);//使按钮失焦
		btnNewButton_1.setContentAreaFilled(false);//使按钮透明 
		JLabel lable=new JLabel(new Test().i);
		frame.add(lable);

		frame.setBounds(100, 100, 705, 425);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Test test =new Test();
            	test.setTenVisible(frame,ten,btnNewButton_1,lable);
            }
        });
		Timer timer = new Timer(6500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Test test =new Test();
            	test.setTenVisible(frame,ten,btnNewButton_1,lable);
                
                //停止定时器
                ((Timer)e.getSource()).stop();
            }
        });
        //启动定时器
        timer.start();
        



	}	

}