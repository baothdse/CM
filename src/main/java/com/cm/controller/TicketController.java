package com.cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.constants.ErrorConstants;
import com.cm.constants.ParamConstants;
import com.cm.constants.URLConstants;
import com.cm.entities.SeatEntity;
import com.cm.entities.TicketEntity;
import com.cm.error.CustomError;
import com.cm.services.interfaces.SeatService;
import com.cm.services.interfaces.TicketService;

@RestController
@RequestMapping
public class TicketController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private SeatService seatService;
	
	/**
	 * @author BaoTHD
	 * @param username
	 * @param phone
	 * @param price
	 * @param listOfSeatId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = URLConstants.BOOK_TICKET_URL, method = RequestMethod.POST)
	public ResponseEntity<?> bookTicketBySeatId (@RequestParam(value = ParamConstants.USERNAME) String username,
												@RequestParam(value = ParamConstants.PHONE) String phone,											
												@RequestParam(value = ParamConstants.PRICE) Long price,
												@RequestParam(value = ParamConstants.SEAT_ID) List<Long> listOfSeatId,
												@RequestParam(value = ParamConstants.USER_ID) Long userId) {
		CustomError error = new CustomError(ErrorConstants.ER002, ErrorConstants.EM002);
		List<TicketEntity> listOfTicket = ticketService.getAllTicketBySeatId(listOfSeatId);
		
		for (int index = 0; index < listOfSeatId.size(); index++) {
			SeatEntity seatEntity = seatService.getSeatBySeatId(listOfSeatId.get(index));
			if (seatService.changeSeatState(seatEntity) == true) {
				ticketService.saveTicket(username, phone, price, seatEntity.getSeatId(), userId, listOfTicket);								
			} else {
				return new ResponseEntity<CustomError>(error, HttpStatus.OK);
			}
		}
		return new ResponseEntity<List<TicketEntity>>(listOfTicket, HttpStatus.OK);
	}
}
