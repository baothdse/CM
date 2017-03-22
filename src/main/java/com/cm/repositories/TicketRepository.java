package com.cm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cm.entities.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
	
//	@Query("Select t from TicketEntity t, SeatEntity s where t.seat.seatId = :seatId and s.seatId = :seatId")
//	TicketEntity findBySeat(@Param(value = "seatId") Long seatId);
	
	@Query("Select t from TicketEntity t, SeatEntity s where t.seat.seatId = :seatId and s.seatId = :seatId")
	TicketEntity findAllBySeat(@Param(value = "seatId") Long seatId);
}
