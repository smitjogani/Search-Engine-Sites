package searchEngine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;


public class SearchEngine{
		
	public void result() throws IOException
	{		
//		StringBuilder sb = new StringBuilder();
		String keyword = textField.getText();
		String url = "https://www.google.com/search" + "?q=" + keyword;
		Document doc = Jsoup.connect(url).get();
		String html = doc.html();
//		Files.write(Paths.get("S://file.txt"),html.getBytes());
		Elements links = doc.select("cite"); 
		
		for(Element link: links)
		{
			String text = link.text();
			if(text.contains(">"))
			{
				text = text.replaceAll(">","/");
			}
			
			System.out.println(text);
		}

	}
	
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEngine window = new SearchEngine();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchEngine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(226, 226, 226));
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(8, 15, 509, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Serch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					result();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnNewButton.setBounds(525, 15, 117, 40);
		frame.getContentPane().add(btnNewButton);
		
	}
}
