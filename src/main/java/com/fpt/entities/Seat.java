package com.fpt.entities;
// Generated Jan 18, 2017 7:34:38 AM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Seat generated by hbm2java
 */
@Entity
@Table(name = "seat", catalog = "cm")
public class Seat implements java.io.Serializable {

	private int seatId;
	private Integer room;
	private String theater;
	private String seat;
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public Seat() {
	}

	public Seat(int seatId) {
		this.seatId = seatId;
	}

	public Seat(int seatId, Integer room, String theater, String seat, Set<Ticket> tickets) {
		this.seatId = seatId;
		this.room = room;
		this.theater = theater;
		this.seat = seat;
		this.tickets = tickets;
	}

	@Id

	@Column(name = "seat_id", unique = true, nullable = false)
	public int getSeatId() {
		return this.seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	@Column(name = "room")
	public Integer getRoom() {
		return this.room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	@Column(name = "theater", length = 50)
	public String getTheater() {
		return this.theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	@Column(name = "seat", length = 3)
	public String getSeat() {
		return this.seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seat")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
