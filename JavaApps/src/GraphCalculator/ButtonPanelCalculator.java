package GraphCalculator;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ButtonPanelCalculator extends JPanel {

	private Calculator cpu;
	
	public ButtonPanelCalculator(Calculator cpu) {
		this.cpu = cpu;
		this.setLayout(new GridLayout(6, 4, 5, 5));
		this.setBackground(ColorCalculator.BACKGROUND.getColor());
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ButtonCalc[][] button = {{ButtonCalc.PERCENTAGE, ButtonCalc.SQRT,    ButtonCalc.SQUARE,  ButtonCalc.INVERSE},
				                 {ButtonCalc.CLEAR_ALL,  ButtonCalc.CLEAR,   ButtonCalc.DELETE,  ButtonCalc.DIVITION},
				                 {ButtonCalc.NUMBER7,    ButtonCalc.NUMBER8, ButtonCalc.NUMBER9, ButtonCalc.MULTIPLICATION},
				                 {ButtonCalc.NUMBER4,    ButtonCalc.NUMBER5, ButtonCalc.NUMBER6, ButtonCalc.SUBSTRACTION},
				                 {ButtonCalc.NUMBER1,    ButtonCalc.NUMBER2, ButtonCalc.NUMBER3, ButtonCalc.ADDITION},
				                 {ButtonCalc.NEGATION,   ButtonCalc.NUMBER0, ButtonCalc.DECIMAL, ButtonCalc.EQUAL}};
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				this.add(new ButtonCalculator(button[i][j], this.cpu));
			}
		}
		
	}

}
