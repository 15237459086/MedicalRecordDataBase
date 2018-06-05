package com.kurumi.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HospitalHoliday {
	
	private Integer id;
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date holidaysDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getHolidaysDate() {
		return holidaysDate;
	}

	public void setHolidaysDate(Date holidaysDate) {
		this.holidaysDate = holidaysDate;
	}

}
