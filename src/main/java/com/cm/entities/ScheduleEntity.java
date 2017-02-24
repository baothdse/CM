package com.cm.entities;
// Generated Feb 21, 2017 8:16:36 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Schedules generated by hbm2java
 */
@Entity
@Table(name = "schedules", catalog = "cm")
public class ScheduleEntity implements java.io.Serializable {

	private Long scheduleId;
	private MovieEntity movie;
	private Date startDate;
	private Date startTime;
	private String theatre;
	private Integer room;
	private Set<SeatEntity> seats = new HashSet<SeatEntity>(0);

	public ScheduleEntity() {
	}

	public ScheduleEntity(MovieEntity movie, Date startDate, Date startTime, String theatre, Integer room, Set<SeatEntity> seats) {
		this.movie = movie;
		this.startDate = startDate;
		this.startTime = startTime;
		this.theatre = theatre;
		this.room = room;
		this.seats = seats;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "scheduleId", unique = true, nullable = false)
	public Long getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movieId")
	public MovieEntity getMovie() {
		return this.movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "startDate", length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "startTime", length = 8)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "theatre", length = 50)
	public String getTheatre() {
		return this.theatre;
	}

	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}

	@Column(name = "room")
	public Integer getRoom() {
		return this.room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "schedules")
	public Set<SeatEntity> getSeats() {
		return this.seats;
	}

	public void setSeats(Set<SeatEntity> seats) {
		this.seats = seats;
	}

}
