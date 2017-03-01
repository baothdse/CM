package com.cm.entities;
// Generated Mar 1, 2017 2:04:33 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Seat generated by hbm2java
 */
@Entity
@Table(name = "seat", catalog = "cm")
public class SeatEntity implements java.io.Serializable {

	private Long seatId;
	private ScheduleEntity schedules;
	private String seatName;
	private Boolean seatStatus;
	private Set<TicketEntity> tickets = new HashSet<TicketEntity>(0);

	public SeatEntity() {
	}

	public SeatEntity(ScheduleEntity schedules, String seatName, Boolean seatStatus, Set<TicketEntity> tickets) {
		this.schedules = schedules;
		this.seatName = seatName;
		this.seatStatus = seatStatus;
		this.tickets = tickets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "seatId", unique = true, nullable = false)
	public Long getSeatId() {
		return this.seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scheduleId")
	public ScheduleEntity getSchedules() {
		return this.schedules;
	}

	public void setSchedules(ScheduleEntity schedules) {
		this.schedules = schedules;
	}

	@Column(name = "seatName", length = 4)
	public String getSeatName() {
		return this.seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	@Column(name = "seatStatus")
	public Boolean getSeatStatus() {
		return this.seatStatus;
	}

	public void setSeatStatus(Boolean seatStatus) {
		this.seatStatus = seatStatus;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seat")
	public Set<TicketEntity> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<TicketEntity> tickets) {
		this.tickets = tickets;
	}

}
