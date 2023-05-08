import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;

public class MyFrame extends Frame {

	
	public MyFrame(boolean visible,String title, int x,int y, int width ,int height) {
		this.setVisible(visible);
		this.setTitle(title);
		this.setBounds(x,y,width,height);
		
		
		TextField firstTf = new TextField();
		firstTf.setBounds(100,50,80,30);
		add(firstTf);
	
		
		TextField secondTf = new TextField();
		secondTf.setBounds(200,50,80,30);
		add(secondTf);
		
		Button addButton = new Button("Add");
		addButton.setBounds(100, 100, 80, 30);
		
		Button subButton = new Button("Subtract");
		subButton.setBounds(200, 100, 80, 30);
		this.setLayout(null);
		
		this.add(addButton);
		this.add(subButton);
		
		addButton.addActionListener(new ActionHandler(firstTf,secondTf));
		subButton.addActionListener(new ActionHandler(firstTf,secondTf));
		
		// multiple delgates for multiple events
		//this.addWindowListener(new WindowHandler());
		//this.addMouseListener(new MouseHandler());
		//this.addMouseMotionListener(new MouseMotionHandler());
	    
		
		// Single delegate for all types of events
		this.addWindowListener(new MasterWindowHandler());
		this.addMouseListener(new MasterWindowHandler());
		this.addMouseMotionListener(new MasterWindowHandler());
	
	}

}
