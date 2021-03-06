package gomoku.gamepanel;

import gomoku.constants.Constants;
import gomoku.language.Language;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 * @author Norvi
 * create the dialogs
 * imcomplete version!!!!!
 *
 */
public class DialogCreator {
	static JDialog dialog = new JDialog();
	static JOptionPane dialogPane;
	public static int getValue;
	
	public static  int oneButtonDialog(String dialogName,String message){
		getValue=0;		
		JButton okButton;
		
		ImageIcon dialogBgIcon = new ImageIcon(Theme.dialogBg);
		ImageIcon okIcon = new ImageIcon(Language.OK);
		
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		Image cursorImage = Toolkit.getDefaultToolkit().getImage(Theme.arrow);
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0, 0), "mycursor");
		dialogPane.setCursor(cursor);
		//Use JOptionPane to place everything, and then create a diolog by JOptionPane
		
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());

		JLabel wordLabel = new JLabel();
		if(message.length()>wordLabel.getWidth()){
			message = "<html>" + message + "<html/>";
			message.replaceAll(""+message.charAt(wordLabel.getWidth()),message.charAt(wordLabel.getWidth())+"<br/>");
		}
		wordLabel.setText(message);
		wordLabel.setForeground(Theme.themeColor);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZEBIG));
		wordLabel.setBounds(10,40,400,100);
		
		okButton = new JButton();
		okButton.setIcon(okIcon);
		okButton.setBounds(160,160,okIcon.getIconWidth(),okIcon.getIconHeight());
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Media.playSound(Sound.dialog);
				dialog.dispose();
				getValue=1;
			}
			
		});
		
		dialogPane.add(wordLabel);
		dialogPane.add(okButton);
		dialogPane.add(imageLabel);
		//wordLabel-top;okButton-middle;imageLabel-bottom
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(okButton,dialogName);
	    dialog.setVisible(true);
	    //how to set a dialog as Opaque???
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(okButton); 
		
		Object selectedValue = dialogPane.getValue();
	    if(selectedValue == null){
	    	getValue=1;
	    }
	    return getValue;
	}
	
	public static  int twoButtonDialog(String dialogName,String message,String buttonMessage1,String buttonMessage2){
		getValue = 0;
		JButton button1;
		JButton button2;
		ImageIcon dialogBgIcon = new ImageIcon(Theme.dialogBg);
		ImageIcon button1Icon = new ImageIcon(buttonMessage1);
		ImageIcon button2Icon = new ImageIcon(buttonMessage2);
		
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		Image cursorImage = Toolkit.getDefaultToolkit().getImage(Theme.arrow);
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0, 0), "mycursor");
		dialogPane.setCursor(cursor);
		
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());

		JLabel wordLabel = new JLabel();
		if(message.length()>wordLabel.getWidth()){
			message = "<html>" + message + "<html/>";
			message.replaceAll(""+message.charAt(wordLabel.getWidth()),message.charAt(wordLabel.getWidth())+"<br/>");
		}
		wordLabel.setText(message);
		wordLabel.setForeground(Theme.themeColor);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZEBIG));
		wordLabel.setBounds(10,40,400,100);
		
		button1 = new JButton();
		button1.setIcon(button1Icon);
		button1.setBounds(100,160,button1Icon.getIconWidth(),button1Icon.getIconHeight());
		button1.setOpaque(true);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Media.playSound(Sound.dialog);

				getValue = 1;
				dialog.dispose();
			}
			
		});
		
		button2 = new JButton();
		button2.setIcon(button2Icon);
		button2.setBounds(250,160,button2Icon.getIconWidth(),button2Icon.getIconHeight());
		button2.setOpaque(true);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Media.playSound(Sound.dialog);

				getValue = 2;
				dialog.dispose();
			}
			
		});
		dialogPane.add(wordLabel);
		dialogPane.add(button1);
		dialogPane.add(button2);
		dialogPane.add(imageLabel);
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(dialogPane,dialogName);
	    dialog.setVisible(true);
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(button1); 
		return getValue;
	}
	
	public static  int twoButtonDialog(String dialogName,String message,String buttonMessage1,String buttonMessage2,int i){
		getValue = 0;
		JButton button1;
		JButton button2;

		ImageIcon dialogBgIcon = new ImageIcon(Theme.dialogBg);
		
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		Image cursorImage = Toolkit.getDefaultToolkit().getImage(Theme.arrow);
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0, 0), "mycursor");
		dialogPane.setCursor(cursor);
		
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());

		JLabel wordLabel = new JLabel();
		if(message.length()>wordLabel.getWidth()){
			message = "<html>" + message + "<html/>";
			message.replaceAll(""+message.charAt(wordLabel.getWidth()),message.charAt(wordLabel.getWidth())+"<br/>");
		}
		wordLabel.setText(message);
		wordLabel.setForeground(Theme.themeColor);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZEBIG));
		wordLabel.setBounds(10,40,400,100);
		
		button1 = new JButton();
		button1.setText(buttonMessage1);
		button1.setForeground(Theme.themeColor);
		button1.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZESMALL));
		button1.setBounds(0,160,200,50);
		button1.setOpaque(true);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Media.playSound(Sound.dialog);

				getValue = 1;
				dialog.dispose();
			}
			
		});
		
		button2 = new JButton();
		button2.setText(buttonMessage2);
		button2.setForeground(Theme.themeColor);
		button2.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZESMALL));
		button2.setBounds(200,160,200,50);
		button2.setOpaque(true);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Media.playSound(Sound.dialog);

				getValue = 2;
				dialog.dispose();
			}
		});
		
		dialogPane.add(wordLabel);
		dialogPane.add(button1);
		dialogPane.add(button2);
		dialogPane.add(imageLabel);
		//wordLabel-top;okButton-middle;imageLabel-bottom
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(dialogPane,dialogName);
	    dialog.setVisible(true);
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(button1); 
		return getValue;
	}
	
	public static  int threeButtonDialog(String dialogName,String message,String buttonMessage1,String buttonMessage2,String buttonMessage3){
		JButton button1;
		JButton button2;
		JButton button3;
		
		getValue = 0;

		ImageIcon dialogBgIcon = new ImageIcon(Theme.dialogBg);
		
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		Image cursorImage = Toolkit.getDefaultToolkit().getImage(Theme.arrow);
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0, 0), "mycursor");
		dialogPane.setCursor(cursor);
		
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());

		JLabel wordLabel = new JLabel();
		if(message.length()>wordLabel.getWidth()){
			message = "<html>" + message + "<html/>";
			message.replaceAll(""+message.charAt(wordLabel.getWidth()),message.charAt(wordLabel.getWidth())+"<br/>");
		}
		wordLabel.setText(message);
		wordLabel.setForeground(Theme.themeColor);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZEBIG));
		wordLabel.setBounds(10,40,400,100);
		
		button1 = new JButton();
		button1.setText(buttonMessage1);
		button1.setForeground(Theme.themeColor);
		button1.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZESMALL));
		button1.setBounds(0,160,120,50);
		button1.setOpaque(true);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Media.playSound(Sound.dialog);

				getValue = 1;
				dialog.dispose();
			}
		});
		
		button2 = new JButton();
		button2.setText(buttonMessage2);
		button2.setForeground(Theme.themeColor);
		button2.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZESMALL));
		button2.setBounds(100,160,120,50);
		button2.setOpaque(true);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Media.playSound(Sound.dialog);

				getValue = 2;
				dialog.dispose();
			}
		});
		
		button3 = new JButton();
		button3.setText(buttonMessage3);
		button3.setForeground(Theme.themeColor);
		button3.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZESMALL));
		button3.setBounds(200,160,220,50);
		button3.setOpaque(true);
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button3.setFocusPainted(false);
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Media.playSound(Sound.dialog);

				getValue = 3;
				dialog.dispose();
			}
		});
		
		dialogPane.add(wordLabel);
		dialogPane.add(button1);
		dialogPane.add(button2);
		dialogPane.add(button3);
		dialogPane.add(imageLabel);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(dialogPane,dialogName);
	    dialog.setVisible(true);
		dialog.add(dialogPane);
		dialog.setFocusable(true);
		dialog.getRootPane().setDefaultButton(button1);
		return getValue;
	}
	
	public static  String InputDialog(String dialogName,String message){
		String input = null;
		JButton okButton;
		JTextField inputField;

		ImageIcon dialogBgIcon = new ImageIcon(Theme.dialogBg);
		ImageIcon okIcon = new ImageIcon(Language.OK);
		
		dialogPane = new JOptionPane();
		dialogPane.setLayout(null);
		Image cursorImage = Toolkit.getDefaultToolkit().getImage(Theme.arrow);
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0, 0), "mycursor");
		dialogPane.setCursor(cursor);
		
		JLabel imageLabel = new JLabel(dialogBgIcon);
		imageLabel.setBounds(0,0,dialogBgIcon.getIconWidth(),dialogBgIcon.getIconHeight());

		JLabel wordLabel = new JLabel();
		if(message.length()>wordLabel.getWidth()){
			message = "<html>" + message + "<html/>";
			message.replaceAll(""+message.charAt(wordLabel.getWidth()),message.charAt(wordLabel.getWidth())+"<br/>");
		}
		wordLabel.setText(message);
		wordLabel.setForeground(Theme.themeColor);
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZEBIG));
		wordLabel.setBounds(10,30,400,100);
		
		okButton = new JButton();
		okButton.setIcon(okIcon);
		okButton.setBounds(160,160,okIcon.getIconWidth(),okIcon.getIconHeight());
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Media.playSound(Sound.dialog);

				dialog.dispose();
			}
			
		});
		
		inputField = new JTextField();
		inputField.setBounds(80, 120, 250, 30);
		inputField.setFocusable(true);
		
		dialogPane.add(inputField);
		dialogPane.add(wordLabel);
		dialogPane.add(okButton);
		dialogPane.add(imageLabel);
		dialogPane.setOpaque(false);
		
		dialogPane.setPreferredSize(new Dimension(400,250));
		dialog = dialogPane.createDialog(okButton,dialogName);
	    dialog.setVisible(true);
		dialog.add(dialogPane);
		dialog.getRootPane().setDefaultButton(okButton); 
		
		input = inputField.getText();
		System.out.println(input);
		return input;
	}
}
