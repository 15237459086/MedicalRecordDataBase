package com.kurumi.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kurumi.pojo.HospitalHoliday;

public interface HolidayMapper {
	
	List<String> getHolidays(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	
	int insert(HospitalHoliday hospitalHoliday);
	
	int deleteByHolidayDate(@Param("holidayDate")Date holidayDate);

	int deleteByStartDateAndEndDate(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}
