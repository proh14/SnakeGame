import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Start extends JPanel {
	
	
 int selectedOption; 
	
	public Start(){
		
		
		
		selectedOption = JOptionPane.showConfirmDialog(null, 
                "Start?", 
                "Start", 
                JOptionPane.YES_NO_OPTION); 
}
		
		
	}
	


