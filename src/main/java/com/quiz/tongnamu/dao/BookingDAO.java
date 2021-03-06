package com.quiz.tongnamu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.tongnamu.model.Booking;

@Repository
public interface BookingDAO {

	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	public int insertBooking(
			@Param("name") String name, 
			@Param("headcount") int headcount, 
			@Param("day") int day, 
			@Param("date") String date, 
			@Param("phoneNumber") String phoneNumber);
	
	public List<Booking> selectBookingByNameAndPhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
}
