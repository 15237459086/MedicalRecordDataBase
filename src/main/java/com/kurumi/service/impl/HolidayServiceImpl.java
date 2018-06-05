package com.kurumi.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurumi.datasource.TargetDataSource;
import com.kurumi.mapper.HolidayMapper;
import com.kurumi.pojo.HospitalHoliday;
import com.kurumi.service.HolidayService;
import com.kurumi.util.DateUtil;

@Service
public class HolidayServiceImpl implements HolidayService{
	
	@Autowired
	private HolidayMapper holidayMapper;

	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public int setHoliday(Date date, String tag) {
		HospitalHoliday hospitalHoliday = null;
		int count = 0;
		if(tag.equalsIgnoreCase("1")){
			hospitalHoliday = new HospitalHoliday();
			hospitalHoliday.setHolidaysDate(date);
			count = holidayMapper.insert(hospitalHoliday);
		}else{
			count = holidayMapper.deleteByHolidayDate(date);
		}
		
		return count;
	}

	@Override
	@TargetDataSource(name="ds1")
	public List<String> getHoliday(Date startDate,Date endDate) {
		// TODO Auto-generated method stub
		return holidayMapper.getHolidays(startDate, endDate);
	}

	@Override
	@Transactional
	@TargetDataSource(name="ds1")
	public List<String> initHoliday(Date startDate,Date endDate) {
		// TODO Auto-generated method stub
		List<String> holidays = new ArrayList<String>();
		holidayMapper.deleteByStartDateAndEndDate(startDate, endDate);
		Date currentDate = startDate;
		while(currentDate.compareTo(endDate)< 0){
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(currentDate);
			if(cal.get(Calendar.DAY_OF_WEEK) == 7 || cal.get(Calendar.DAY_OF_WEEK) == 1){
				
				HospitalHoliday hospitalHoliday = new HospitalHoliday();
				hospitalHoliday.setHolidaysDate(currentDate);
				holidayMapper.insert(hospitalHoliday);
				holidays.add(DateUtil.dateFormat(currentDate));
			}
			currentDate = DateUtil.addDay(currentDate, 1);
			
		}
		return holidays;
	}

}
