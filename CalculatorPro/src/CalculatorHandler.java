import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorHandler implements ActionListener{


	CalculatorFrame cf ;
	public CalculatorHandler(CalculatorFrame calculatorFrame) {
		this.cf = calculatorFrame;
	}

	public void actionPerformed(ActionEvent e) {

		
		int a = Integer.parseInt(cf.getOperend1Txt().getText());
		int b = Integer.parseInt(cf.getOperend2Txt().getText());
		int result;
		if(e.getActionCommand().equalsIgnoreCase("Add")) {
			
			result = a+b;
			cf.getAnswerLbl().setText("Answer = "+ result);
			
		}else if(e.getActionCommand().equalsIgnoreCase("Subtract")) {
			
			result = a-b;
			cf.getAnswerLbl().setText("Answer = "+ result);
		}
	}

}
