package mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AccountModel{
	
	private int CHARGE_PER_WEEK=10; // the charge per week on the user

	/**
	 * Calculates the charge on the user depending on the current date
	 * @param dates - an array containing all dates of the books borrowed by the user
	 * @return - returns the total charge on the user
	 */
	public int calcTotalCharge(String[] dates) {
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
		Date current_date= new Date();
		System.out.println(date_format.format(current_date));
		 
		int total_charge=0;
		for(int i=0;i<dates.length;i++) {
			try {
				if(dates[i]!=null) {
					Date borrowed_date=date_format.parse(dates[i]);
					long diff= current_date.getTime()- borrowed_date.getTime();
					
					long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
					
					System.out.println(days);
					
					if(days>7) {
						total_charge+= (days/7)*CHARGE_PER_WEEK;
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 
		 }
		return total_charge;
		
	}
}
