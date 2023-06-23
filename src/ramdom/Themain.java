package ramdom;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Themain extends JFrame {
	private String[] names=ReadTheNames.ReadTheName();	//调用ReadTheNames类中的静态方法ReadTheName获得一个名字的String数组
	private JPanel contentPane;	
	private JTextField textField;
	private JTextField textField_1;	
	int intMin;
	int intMax;
	//boolean isReset;
	public void DetectSelectName(JCheckBox chckbxNewCheckBox) {
		//String Min = textField.getText();
	   //intMin = Integer.parseInt(Min);
	   //String Max = textField_1.getText();
	    //intMax = Integer.parseInt(Max);
		//if ((intMin!=1 || intMax!=52)&& !isReset) {
			chckbxNewCheckBox.setSelected(false);
		//}else {
			//isReset=false;
		//}
	}

	public void DeterminesSelected(JLabel THEnumber,JCheckBox chckbxNewCheckBox,int randomNumber,int max,int min) {
		//用来检测显示名字的单选框是否勾选，并因此调整结果显示的位置，字体大小和内容
		if(chckbxNewCheckBox.isSelected()==true && max==52 && min==1) {
        	THEnumber.setFont(new Font("宋体", Font.BOLD, 40));
        	THEnumber.setBounds(433, 95, 268, 126);
        	THEnumber.setText(names[randomNumber]);
        }else if(chckbxNewCheckBox.isSelected()==true && (max!=52 || min!=1)){
        	JOptionPane.showMessageDialog(this, "错误，仅在最大值为52且最小值为1时才允许使用显示人名模式"); 
        }else {
        	THEnumber.setFont(new Font("宋体", Font.BOLD, 72));
        	THEnumber.setBounds(458, 98, 268, 126);
        	THEnumber.setText(randomNumber+"");
        }
	}
	public Themain() {
		//初始化面板
		setTitle("可爱的井ノ上たきな随机数生成器");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Themain.class.getResource("/images/5.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ImageIcon image = new ImageIcon("src/images/3.jpg");
		ImageIcon image= new ImageIcon(Themain.class.getResource("/images/3.jpg"));
		setBounds(100, 100, image.getIconWidth(), image.getIconHeight());
		setSize(800, 371);
		//使窗口居中显示
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//创建随机数生成类的对象
		RandomNumberGenerator generator = new RandomNumberGenerator();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//创建菜单
        JMenuBar menuBar = new JMenuBar();
        JMenu Menu = new JMenu("更多");
        JMenuItem updateMemu = new JMenuItem("更新日志");
        updateMemu.setIcon(new ImageIcon(Themain.class.getResource("/images/8.jpg")));
        JMenuItem About = new JMenuItem("关于");
        About.setIcon(new ImageIcon(Themain.class.getResource("/images/about.jpg")));
        Menu.add(updateMemu);
        Menu.add(About);
        menuBar.add(Menu);
        setJMenuBar(menuBar);
        
		//创建按钮
		JButton btnNewButton = new JButton("抽取");
		btnNewButton.setBounds(229, 200, 141, 51);
		contentPane.add(btnNewButton);
		btnNewButton.setFocusPainted(false);//使按钮失焦

		JButton btnNewButton_1 = new JButton("十连");
		btnNewButton_1.setBounds(394, 200, 141, 51);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFocusPainted(false);//使按钮失焦
		
		JButton btnNewButton_2 = new JButton("再抽一次");
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_2.setBounds(421, 220, 155, 66);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		btnNewButton_2.setFocusPainted(false);//使按钮失焦
		btnNewButton_2.setContentAreaFilled(false);//使按钮透明 
		
		JButton btnNewButton_3 = new JButton("重置");
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_3.setBounds(718, 6, 58, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setContentAreaFilled(false); //使按钮透明
		btnNewButton_3.setFocusPainted(false);//使按钮失焦
		
		//创建标签
		JLabel lblNewLabel = new JLabel("随机抽取器");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 26));
		lblNewLabel.setBounds(310, 39, 141, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("最小");
		lblNewLabel_1.setBounds(332, 122, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel THEnumber = new JLabel("");
		THEnumber.setHorizontalAlignment(SwingConstants.LEFT);
		THEnumber.setForeground(new Color(114, 68, 208));
		THEnumber.setFont(new Font("宋体", Font.BOLD, 72));
		THEnumber.setBounds(433, 95, 268, 126);
		contentPane.add(THEnumber);
		
		JLabel lblNewLabel_2 = new JLabel("最大");
		lblNewLabel_2.setBounds(406, 122, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("__");
		lblNewLabel_3.setBounds(375, 148, 28, 15);
		contentPane.add(lblNewLabel_3);
		
		//创建文本框
		textField = new JTextField();
		textField.setText("1");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(317, 147, 54, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("52");
		textField_1.setBounds(394, 147, 54, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		//创建单选框
		JCheckBox chckbxNewCheckBox = new JCheckBox("显示姓名");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(6, 6, 103, 23);
		contentPane.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setFocusPainted(false);

		//提前设置窗口背景为可爱的井ノ上たきな,并设置隐藏
		JLabel background = new JLabel(image);
		background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        contentPane.add(background);
        background.setVisible(false);
        
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	DetectSelectName(chckbxNewCheckBox);
            	
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	//DetectSelectName(chckbxNewCheckBox);
            	
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
            	//DetectSelectName(chckbxNewCheckBox);
            	
            }
        });
        textField_1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	DetectSelectName(chckbxNewCheckBox);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	//DetectSelectName(chckbxNewCheckBox);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	//DetectSelectName(chckbxNewCheckBox);
            }
       });
		
        //下面是点击抽取时的事件处理
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//获取文本框内的最大最小值，并调用generator类的setMinAndMax方法设置或更改最大最小值
				    String Min = textField.getText();
				    intMin = Integer.parseInt(Min);
				    String Max = textField_1.getText();
				    intMax = Integer.parseInt(Max);
				    generator.setMinAndMax(intMin,intMax);	
				} catch (NumberFormatException err2) {
				    // 处理异常
				    System.err.println("无法将文本转换为数字");
				}
				//try {
						//使井ノ上たきな出现并隐藏一些组件以免阻挡可爱的井ノ上たきな
						background.setVisible(true);
						THEnumber.setVisible(true);
						btnNewButton_2.setVisible(true);
						lblNewLabel.setVisible(false);
						lblNewLabel_1.setVisible(false);
						lblNewLabel_2.setVisible(false);
						lblNewLabel_3.setVisible(false);
						btnNewButton_1.setVisible(false);
						btnNewButton.setVisible(false);
						textField.setVisible(false);
						textField_1.setVisible(false);
						//开始生成随机数并调用DeterminesSelected方法
		                int randomNumber = generator.generate();
		                DeterminesSelected(THEnumber,chckbxNewCheckBox,randomNumber,intMax,intMin);
		       // } catch (IllegalStateException err) {
		        	//如果所有随机数都取遍了就清除过去记录的随机数重新开始
		        	// generator.reset();
		       // }
			}
		});
        
        //点击十连的事件
        btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int[] ten =new int[10];
			    String Min = textField.getText();
			    intMin = Integer.parseInt(Min);
			    String Max = textField_1.getText();
			    intMax = Integer.parseInt(Max);
				generator.setMinAndMax(intMin,intMax);
				for(int i = 0;i<10;i++) {
					int randomNumber = generator.generate();
                	 ten[i]=randomNumber;
                }
		       // Thread thread = new Thread(new Runnable() {
		         //   public void run() {
		            	Test.Genshin(ten);
		         //   }
		       // });
		        //thread.start();
				
			}
		});
        
        //点击再抽一次的事件
    	btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try {
					//开始生成随机数并调用DeterminesSelected方法
	                int randomNumber = generator.generate();
	                DeterminesSelected(THEnumber,chckbxNewCheckBox,randomNumber,intMax,intMin);
				//} catch (IllegalStateException err) {
	        	// generator.reset();
				//}
			}
		});
		//一下是点击重置时的处理
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				background.setVisible(false);
				THEnumber.setVisible(false);
				btnNewButton_2.setVisible(false);
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_2.setVisible(true);
				lblNewLabel_3.setVisible(true);
				btnNewButton_1.setVisible(true);
				btnNewButton.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				//isReset=true;
				textField.setText("1");
				textField_1.setText("52");
				chckbxNewCheckBox.setSelected(true);
				
			}
		});
		//点击关于菜单时的处理
		updateMemu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		JFrame newFrame = new JFrame("Changelog");
                newFrame.setSize(400, 400);
                newFrame.setVisible(true);
                newFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(Themain.class.getResource("/images/8.jpg")));
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                newFrame.setLocation(dim.width/2-newFrame.getSize().width/2, dim.height/2-newFrame.getSize().height/2);
                JLabel label = new JLabel("<html><body>1.0.0  随机数生成器java重置版诞生了！<br/>1.1.0  1.十连增加跳过选项<br/>&nbsp;&nbsp;&nbsp;&thinsp;2.添加是否显示名字自动检测<br/>&nbsp;&nbsp;&nbsp;&thinsp;3.修复关闭十连窗口时整个程序都<br/>&nbsp;&nbsp;&nbsp;&thinsp;会退出的恶性bug.<body></html>");
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("宋体", Font.BOLD, 20));
                newFrame.getContentPane().add(label);
                newFrame.setVisible(true);
            }
        });
		
		About.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		JFrame newFrame_2 = new JFrame("About");
                newFrame_2.setSize(410, 250);
                newFrame_2.setVisible(true);
                newFrame_2.setIconImage(Toolkit.getDefaultToolkit().getImage(Themain.class.getResource("/images/about.jpg")));
                //使窗口居中显示
                Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();   
                newFrame_2.setBounds(p.x - 410 / 2, p.y - 250 / 2, 410, 250);
                
                JLabel label = new JLabel("<html><body>作者：缘扬风星<br/>联系方式：cjl2597588144@gmail.com<br/>软件介绍：1.拥有公平管理系统（保证了公平，抽过一次不会再抽到，但是相应的舍弃了一定的随机性）<br/>2.拥有泷奈！（本产品的最大优势）<body></html>");
                label.setFont(new Font("宋体", Font.BOLD, 20));
                newFrame_2.getContentPane().setLayout(null);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBounds(0, 0, 410, 200);
                newFrame_2.getContentPane().add(label);
                newFrame_2.setVisible(true);
            }
        });
		
}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Themain frame = new Themain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
