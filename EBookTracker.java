import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList; 
import java.io.BufferedWriter;


public class EBookTracker extends JPanel{
	private Button submitS, submitE, submitCO, submitR; 
	private Label std_idL, std_gradeL, std_fnameL, std_lnameL, ebk_idL, ebk_titleL, idCOL, bookidCOL, startL, endL, codeL; 
	private TextField std_idIN, std_gradeIN, std_fnameIN, std_lnameIN, ebk_idIN, ebk_titleIN, idCO, bookidCO, start, end, code;
	private static File fstudents = new File("C://Users//laurenfunston//documents//students.txt");
	private static File febooks = new File("C://Users//laurenfunston//documents//ebooks.txt");
	private static File fborrow_record = new File("C://Users//laurenfunston//documents//borrow_record.txt");
	private static ArrayList<String> std_id = new ArrayList<String>(); 
	private static ArrayList<String> std_grade = new ArrayList<String>(); 
	private static ArrayList<String> std_fname = new ArrayList<String>(); 
	private static ArrayList<String> std_lname = new ArrayList<String>(); 
	private static ArrayList<String> ebk_id = new ArrayList<String>(); 
	private static ArrayList<String> ebk_title = new ArrayList<String>(); 
	private static ArrayList<String> brd_code = new ArrayList<String>(); 
	private static ArrayList<String> brd_std = new ArrayList<String>(); 
	private static ArrayList<String> brd_ebk = new ArrayList<String>(); 
	private static ArrayList<String> brd_start = new ArrayList<String>(); 
	private static ArrayList<String> brd_end = new ArrayList<String>(); 
	private Scanner s_read, e_read, br_read; 
	private static BufferedWriter s_writer, s_clear, e_writer, e_clear, br_writer, br_clear; 
	
	public EBookTracker() throws IOException {
		
        super(new GridLayout(0,1)); 
        JTabbedPane tabbedPane = new JTabbedPane();
        
        s_read = new Scanner(fstudents);
        e_read = new Scanner(febooks);
        br_read = new Scanner(fborrow_record); 
        
       
        
        
        while(s_read.hasNextLine()){
        	String [] current = s_read.nextLine().split(",", 0); 
        	std_id.add(current[0]); 
        	std_lname.add(current[1]); 
        	std_fname.add(current[2]); 
        	std_grade.add(current[3]); 
        }
        
        while(e_read.hasNextLine()){
        	String [] current = e_read.nextLine().split(",", 0); 
        	ebk_id.add(current[0]); 
        	ebk_title.add(current[1]); 
        }
        
        while(br_read.hasNextLine()){
        	String [] current = br_read.nextLine().split(",", 0); 
        	brd_code.add(current[0]); 
        	brd_std.add(current[1]); 
        	brd_ebk.add(current[2]); 
        	brd_start.add(current[3]); 
        	brd_end.add(current[4]); 
        	
        }
        
        JComponent panel1 = makeTextPanel("Add New Student: ");
        tabbedPane.addTab("Add Student", panel1);
        panel1.setPreferredSize(new Dimension(400,200));
        std_idL = new Label("Student ID: "); 
        panel1.add(std_idL);
        std_idIN = new TextField(6);
        panel1.add(std_idIN);
        std_fnameL = new Label("First Name: "); 
        panel1.add(std_fnameL);
        std_fnameIN = new TextField(20); 
        panel1.add(std_fnameIN); 
        std_lnameL = new Label("Last Name: "); 
        panel1.add(std_lnameL); 
        std_lnameIN = new TextField(20); 
        panel1.add(std_lnameIN); 
        std_gradeL = new Label("Grade: "); 
        panel1.add(std_gradeL); 
        std_gradeIN = new TextField(2); 
        panel1.add(std_gradeIN); 
        submitS = new Button("Submit"); 
        submitS.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent evt){
        		std_id.add(std_idIN.getText()); 
        		std_fname.add(std_fnameIN.getText()); 
        		std_lname.add(std_lnameIN.getText()); 
        		std_grade.add(std_gradeIN.getText());
        		std_idIN.setText(""); 
        		std_fnameIN.setText("");
        		std_lnameIN.setText("");
        		std_gradeIN.setText("");
        	}
        });
        panel1.add(submitS);
        
        
        JComponent panel2 = makeTextPanel("Add New E-Book: ");
        tabbedPane.addTab("Add E-Book", panel2);
        panel2.setPreferredSize(new Dimension(400,200));
        ebk_idL = new Label("E-Book ID: "); 
        panel2.add(ebk_idL); 
        ebk_idIN = new TextField(6);
        panel2.add(ebk_idIN); 
        ebk_titleL = new Label("E-Book Title: "); 
        panel2.add(ebk_titleL); 
        ebk_titleIN = new TextField(20); 
        panel2.add(ebk_titleIN); 
        submitE = new Button("Submit"); 
        submitE.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent evt){
        		ebk_id.add(ebk_idIN.getText()); 
        		ebk_title.add(ebk_titleIN.getText());
        		ebk_idIN.setText("");
        		ebk_titleIN.setText("");
        	}
        });
        panel2.add(submitE); 
        
        
        JComponent panel3 = makeTextPanel("Enter the following information: ");
        tabbedPane.addTab("Check Out", panel3);
        panel3.setPreferredSize(new Dimension(400,200));
        idCOL = new Label("Student ID: "); 
        panel3.add(idCOL); 
        idCO = new TextField(6); 
        panel3.add(idCO); 
        bookidCOL = new Label("Book ID: "); 
        panel3.add(bookidCOL); 
        bookidCO = new TextField(10); 
        panel3.add(bookidCO); 
        startL = new Label("Current Date (dd-MON-yyyy): "); 
        panel3.add(startL); 
        start = new TextField(8); 
        panel3.add(start); 
        endL = new Label("Due Date (dd-MON-yyyy): "); 
        panel3.add(endL); 
        end = new TextField(8); 
        panel3.add(end); 
        submitCO = new Button("Submit"); 
        submitCO.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent evt){
        		if(std_id.indexOf(idCO.getText()) == -1){
        			idCO.setText("");
        			idCOL.setText("Student ID: (Please enter a valid student ID)");
        		}
        		else if(ebk_id.indexOf(bookidCO.getText()) == -1){
        			bookidCO.setText("");
        			bookidCOL.setText("Book ID: (Please enter a valid book ID)");
        		}
        		else{
        			System.out.print(brd_code.size());
        			brd_code.add((int)(Math.random() * 2000 + 1000) + ""); 
        			System.out.print(brd_code.size());
        			brd_std.add(idCO.getText()); 
        			idCO.setText("");
        			brd_ebk.add(bookidCO.getText()); 
        			bookidCO.setText("");
        			brd_start.add(start.getText()); 
        			start.setText("");
        			brd_end.add(end.getText());
        			end.setText("");
        		}
        	}
        });
        panel3.add(submitCO); 
        
        JComponent panel4 = makeTextPanel("Enter the following information: ");
        tabbedPane.addTab("Return", panel4);
        panel4.setPreferredSize(new Dimension(400,200));
        codeL = new Label("Redemption Code: "); 
        panel4.add(codeL);
        code = new TextField(8); 
        panel4.add(code);
        submitR = new Button("Submit");
        submitR.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent evt){
        		if(brd_code.indexOf(code.getText()) == -1){
        			code.setText("");
        			codeL.setText("Redemption Code: (Please enter a valid code);"); 
        		}
        		else{
        			int index = brd_code.indexOf(code.getText()); 
        			brd_code.remove(index); 
        			brd_std.remove(index); 
        			brd_ebk.remove(index); 
        			brd_start.remove(index); 
        			brd_end.remove(index); 
        			code.setText("");
        		}
        	}
        	
        });
        panel4.add(submitR); 
        
         
        JComponent panel5 = makeTextPanel("Currently checked out books: ");
        tabbedPane.addTab("Report", panel5);
        for(int i = 0; i < brd_code.size(); i++){
        	panel5.add(new Label(std_fname.get(std_id.indexOf(brd_std.get(i))) + "  " + std_lname.get(std_id.indexOf(brd_std.get(i))) + " -- " + ebk_title.get(ebk_id.indexOf(brd_ebk.get(i))))); 
        }
        
         
        //Add the tabbed pane to this panel.
        add(tabbedPane);
         
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        s_read.close(); 
        e_read.close(); 
        br_read.close(); 
        
    }
     
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(0,1));
        panel.add(filler);
        return panel;
    }
     
    
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(new EBookTracker());
        
        frame.addWindowListener(new java.awt.event.WindowAdapter(){
        	@Override
        	public void windowClosing(java.awt.event.WindowEvent windowEvent){
        		try{s_clear = new BufferedWriter(new FileWriter(fstudents));
                s_clear.write(std_id.get(0) + "," + std_lname.get(0) + "," + std_fname.get(0) + "," + std_grade.get(0)); 
                s_clear.newLine(); 
                
                s_writer = new BufferedWriter(new FileWriter(fstudents, true)); 
                for(int i = 1; i < std_id.size(); i++){
                	s_writer.write(std_id.get(i) + "," + std_lname.get(i) + "," + std_fname.get(i) + "," + std_grade.get(i));
                	s_writer.newLine(); 
                }
                
                e_clear = new BufferedWriter(new FileWriter(febooks));
                e_clear.write(ebk_id.get(0) + "," + ebk_title.get(0)); 
                e_clear.newLine(); 
                
                e_writer = new BufferedWriter(new FileWriter(febooks, true)); 
                for(int i = 1; i < ebk_id.size(); i++){
                	e_writer.write(ebk_id.get(i) + "," + ebk_title.get(i));
                	e_writer.newLine(); 
                }
                
                br_clear = new BufferedWriter(new FileWriter(fborrow_record));
                br_clear.write(brd_code.get(0) + "," + brd_std.get(0) + "," + brd_ebk.get(0) + "," + brd_start.get(0) + "," + brd_end.get(0)); 
                br_clear.newLine(); 
                
                br_writer = new BufferedWriter(new FileWriter(fborrow_record, true)); 
                for(int i = 1; i < brd_code.size(); i++){
                	br_writer.write(brd_code.get(i) + "," + brd_std.get(i) + "," + brd_ebk.get(i) + "," + brd_start.get(i) + "," + brd_end.get(i));
                	br_writer.newLine(); 
                }
                
                s_clear.flush(); 
                s_clear.close(); 
                s_writer.flush(); 
                s_writer.close(); 
                e_clear.flush(); 
                e_clear.close(); 
                e_writer.flush(); 
                e_writer.close(); 
                br_clear.flush(); 
                br_clear.close(); 
                br_writer.flush(); 
                br_writer.close(); }
        		catch(IOException e){
        			System.out.print("you're a disgrace");
        		}
        	}
        });
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
    }
     
    public static void main(String[] args) throws IOException{
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        createAndShowGUI(); 
        
        
        
        
        
    }
}