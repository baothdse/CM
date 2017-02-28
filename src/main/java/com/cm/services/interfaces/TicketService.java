package com.cm.services.interfaces;

import java.util.List;

import com.cm.entities.TicketEntity;

public interface TicketService {
	boolean saveTicket(String username, String phone, Long price, Long seatId, Long userId, List<TicketEntity> listOfTicket );
//	TicketEntity getTicketBySeatId(Long seatId);
	List<TicketEntity> getAllTicketBySeatId(List<Long> seatId);
}
