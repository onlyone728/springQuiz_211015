package com.quiz.tongnamu;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.tongnamu.bo.BookingBO;
import com.quiz.tongnamu.model.Booking;

@Controller
public class tongnamuController {

	@Autowired
	private BookingBO bookingBO;
	
	// 메인 화면
	@RequestMapping("/tongnamu/index")
	public String indexView() {
		return "tongnamu/template";
	}
	
	// 예약 확인 기능 - AJAX 호출
	@ResponseBody
	@PostMapping("/tongnamu/search_reservation")
	public Map<String, Object> seafchReservation(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB select
		Booking booking = bookingBO.getBookingByNameAndPhoneNumber(name, phoneNumber);
		
		// return map
		Map<String, Object> result = new HashMap<>();
		
		if (booking != null) {
			result.put("name", booking.getName());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(booking.getDate());
			
			result.put("date", date);
			result.put("day", booking.getDay());
			result.put("headcount", booking.getHeadcount());
			result.put("state", booking.getState());
		} 
		
		return result;
	}
	
	// 예약 리스트 화면
	@RequestMapping("/tongnamu/reservation_list")
	public String reservationList(Model model) {
		
		// DB select
		List<Booking> bookingList = bookingBO.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "tongnamu/reservation_list_template";
	}
	
	// 예약 삭제 기능 - AJAX 호출
	@ResponseBody
	@PostMapping("/tongnamu/delete_booking")
	public Map<String, Boolean> deleteBooking(
			@RequestParam("id") int id) {
		
		// DB delete
		boolean deleteBooking = bookingBO.deleteBookingById(id);
		
		// map return
		Map<String, Boolean> result = new HashMap<>();
		result.put("result", deleteBooking);
		
		return result;
	}
	
	// 예약 화면
	@RequestMapping("/tongnamu/reservation")
	public String reservationView() {
		return "tongnamu/reservation_template";
	}
	
	// 예약 추가 기능 - AJAX 호출
	@ResponseBody
	@PostMapping("/tongnamu/add_reservation")
	public Map<String, Boolean> addReservation(
			@RequestParam("name") String name,
			@RequestParam("headcount") int headcount,
			@RequestParam("day") int day,
			@RequestParam("date") String date,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB insert
		boolean addReservation = bookingBO.addBooking(name, headcount, day, date, phoneNumber);
		
		// map return
		Map<String, Boolean> result = new HashMap<>();
		result.put("result", addReservation);
		
		return result;
	}
}
