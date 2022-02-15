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
	
	public int deleteBookingById(int id) {
		return bookingDAO.deleteBookingById(id);
	}
	
	public int addBooking(String name, int headcount, int day, String date, String phoneNumber) {
		return bookingDAO.insertBooking(name, headcount, day, date, phoneNumber); 
	}
	
	public Booking getBookingByNameAndPhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingDAO.selectBookingByNameAndPhoneNumber(name, phoneNumber);
		Booking booking = null;
		
		// []
		// List에서 마지막 1개만 보내기
		if (bookingList.isEmpty() == false) {
			// 데이터가 있을 때
			booking = bookingList.get(bookingList.size() - 1);
		}
		return booking;
	}
}
