package hw1_single_inventory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataEntry {

	private String m_name;
	private String m_company;
	private Date m_date;
	private SimpleDateFormat m_format;
	
	private int m_quantity;
	
	// Overload Ctor
	public DataEntry(String name, String company, Date date, int quantity) {
		setName(name);
		setCompany(company);
		m_date = date;
		setQuantity(quantity);
		
		m_format = new SimpleDateFormat("MM/dd/yyyy");
		m_format.setLenient(false);
	}

	// Default Ctor
	public DataEntry() {
		// TODO Auto-generated constructor stub
		m_name = null;
		m_company = null;
		m_date = new Date();
		m_format = new SimpleDateFormat("MM/dd/yyyy");
		m_format.setLenient(false);
	}

	public String getName() {
		return m_name;
	}

	public void setName(String m_name) {
		this.m_name = m_name;
	}

	public String getCompany() {
		return m_company;
	}

	public void setCompany(String m_company) {
		this.m_company = m_company;
	}

	public Date getDate() {
		return m_date;
	}

	public boolean setDate(String date) {
		boolean retVal = false;
		try 
		{
			this.m_date = m_format.parse(date);
			retVal = true;
		}
		catch (ParseException e)
		{
			retVal = false;
		}
		return retVal;
	}

	public int getQuantity() {
		return m_quantity;
	}

	public boolean setQuantity(int m_quantity) {
		boolean retVal = false;
		if (m_quantity >= 0)
		{
			this.m_quantity = m_quantity;
			retVal = true;
		}
		else
		{
			retVal = false;
		}
		return retVal;
	}

}
