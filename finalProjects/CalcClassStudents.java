package finalProjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class CalcClassStudents {

	public static void main(String[] args) {
		
		JFileChooser jfc = new JFileChooser();
		int selection = jfc.showOpenDialog(null);
		if(selection == jfc.APPROVE_OPTION){
			File file = jfc.getSelectedFile();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				reader.mark(300000);
				int counter = 0;
				int studentCounter=0;
				String line=reader.readLine();
				while(line!=null){
					counter++;
					if(line.equals("test:")){
						studentCounter++;
					}
					line=reader.readLine();
				}
				reader.reset();
				for(int stuco=0;stuco<studentCounter;stuco++){
					Student student = new Student(reader.readLine());
					reader.mark(10000);
					line=reader.readLine();
					int testC=0;
					
					while(!line.equals("quizzes:")){
						testC++;
						line=reader.readLine();
					}
					reader.reset();
					student.createTests(testC-1);
					for(int d=0;d<testC-1;d++){
						
					}
					while(!line.equals("homeworks:")){
						
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
