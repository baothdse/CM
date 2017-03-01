package com.cm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.entities.AccountEntity;
import com.cm.entities.SeatEntity;
import com.cm.entities.TicketEntity;
import com.cm.repositories.AccountRepository;
import com.cm.repositories.SeatRepository;
import com.cm.repositories.TicketRepository;
import com.cm.services.interfaces.TicketService;

@Service
@Transactional
public class TicketServiceImp implements TicketService {

	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	/* 
	 * @author: BaoTHD
	 */
	@Override
	public boolean saveTicket(String username, String phone, Long price, Long seatId, Long userId,
								List<TicketEntity> listOfTicket) {
		// TODO Auto-generated method stub
		TicketEntity ticketEntity = new TicketEntity();
		SeatEntity seatEntity = seatRepository.findBySeatId(seatId);
		AccountEntity accountEntity = accountRepository.findByUserId(userId);
		
		ticketEntity.setUsername(username);
		ticketEntity.setPhone(phone);
		ticketEntity.setPrice(price);
		ticketEntity.setSeat(seatEntity);
		ticketEntity.setAccounts(accountEntity);
		ticketRepository.save(ticketEntity);
		listOfTicket.add(ticketEntity);
		return true;
	}

//	@Override
//	public TicketEntity getTicketBySeatId(Long seatId) {
//		// TODO Auto-generated method stub
//		return ticketRepository.findBySeat(seatId);
//	}

	/* 
	 * @author: BaoTHD
	 */
	@Override
	public List<TicketEntity> getAllTicketBySeatId(List<Long> listOfSeatId) {
		// TODO Auto-generated method stub
		List<TicketEntity> listOfTicket = null;
		for (int index = 0; index < listOfSeatId.size(); index++) {
			listOfTicket = ticketRepository.findAllBySeat(listOfSeatId.get(index));
		}
		return listOfTicket;
	}

}
