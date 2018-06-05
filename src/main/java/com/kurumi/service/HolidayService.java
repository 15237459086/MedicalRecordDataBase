package com.kurumi.service;

import java.util.Date;
import java.util.List;

public interface HolidayService {
	
	int setHoliday(Date date,String tag);
	

	List<String> getHoliday(Date startDate,Date endDate);
	
	
	List<String> initHoliday(Date startDate,Date endDate);
}
