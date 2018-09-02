package hw1_single_inventory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {

	private File m_outputFile;
	private ArrayList<String> m_outStrings;
	private FileWriter m_fileWriter;
	
	public Writer(File outputFile, ArrayList<String> outStrings) {
		m_outputFile = outputFile;
		m_outStrings = outStrings;
		try {
			m_fileWriter = new FileWriter(m_outputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeAllStrings()
	{
		try {
			for (String string : m_outStrings) {
					m_fileWriter.write(string);
					
			}
			m_fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
