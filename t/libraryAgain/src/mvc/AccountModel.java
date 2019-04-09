package mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AccountModel{
	
	private int CHARGE_PER_DAY=20; 

	public void addFunds(int amount) {
		/* Implement */
		System.out.printf("Added $%d into your account\n", amount);
		
	}
	
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
						total_charge+= (days-8)*CHARGE_PER_DAY;
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 
		 }
		return total_charge;
		
	}
}
