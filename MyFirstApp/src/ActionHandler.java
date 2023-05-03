import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

	
	private TextField firsrtTf;
	
	private TextField secondTf;
	public ActionHandler(TextField firstTf, TextField secondTf) {
		this.firsrtTf = firstTf;
		this.secondTf = secondTf;
	}

	public void actionPerformed(ActionEvent e) {
		//Button b = (Button)e.getSource();
	
		//System.out.println(b.getActionCommand());
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equalsIgnoreCase("add")) {
		   System.out.println(this.firsrtTf.getText());
		   System.out.println(this.secondTf.getText());
			
		}else if (e.getActionCommand().equalsIgnoreCase("subtract")) {
			System.out.println(this.firsrtTf.getText());
			System.out.println(this.secondTf.getText());
		}
	}

}
