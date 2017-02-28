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
	
	@RequestMapping(value = "/bookTicket", method = RequestMethod.POST)
	public ResponseEntity<?> bookTicketBySeatId (@RequestParam(value = "username") String username,
												@RequestParam(value = "phone") String phone,											
												@RequestParam(value = "price") Long price,
												@RequestParam(value = "seatId") List<Long> listOfSeatId,
												@RequestParam(value = "userId") Long userId) {
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
