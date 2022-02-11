package com.quiz.tongnamu.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.tongnamu.dao.BookingDAO;
import com.quiz.tongnamu.model.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingDAO bookingDAO;
	
	public List<Booking> getBookingList() {
		return bookingDAO.selectBookingList();
	}
	
	public boolean deleteBookingById(int id) {
		return bookingDAO.deleteBookingById(id);
	}
	
	public boolean addBooking(String name, int headcount, int day, String date, String phoneNumber) {
		return bookingDAO.insertBooking(name, headcount, day, date, phoneNumber); 
	}
	
	public Booking getBookingByNameAndPhoneNumber(String name, String phoneNumber) {
		return bookingDAO.selectBookingByNameAndPhoneNumber(name, phoneNumber);
	}
}
