package com.quiz.tongnamu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public Map<String, Object> searchReservation(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB select
		Booking booking = bookingBO.getBookingByNameAndPhoneNumber(name, phoneNumber);
		
		// return map
		Map<String, Object> result = new HashMap<>();
		
		if (booking == null) {
			// 실패시
			// {"result":"fail"
			//  "code":"500"}
			result.put("result", "fail");
			result.put("code", 500);
		} else {
			// 성공시
			// {"result":"success"
			//  "code":"1"
			//  "booking":{"name":"장하나", "phoneNumber":"010-..."....}}
			result.put("result", "success");
			result.put("code", 1);
			result.put("booking", booking);
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
	@DeleteMapping("/tongnamu/delete_booking")
	public Map<String, String> deleteBooking(
			@RequestParam("id") int id) {
		
		// DB delete
		int count = bookingBO.deleteBookingById(id);
		
		// map return
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		if (count < 1) {
			result.put("result", "fail");
		}
		
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
	public Map<String, String> addReservation(
			@RequestParam("name") String name,
			@RequestParam("headcount") int headcount,
			@RequestParam("day") int day,
			@RequestParam("date") String date,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB insert
		int count = bookingBO.addBooking(name, headcount, day, date, phoneNumber);
		
		// map return
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		result.put("code", "1");
		
		if (count < 1) {
			result.put("result", "fail");
			result.put("code", "500");
		}
		
		return result;
	}
}
