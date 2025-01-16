package com.example.demo.users;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Event {
	private Integer id;
	private String title;
	private String theme;
	private String description;
	private String location;
	private Integer maxCapacity;
	private Integer day;
	private String month;
	private Integer year;
	private Integer hour;
	private Integer minute;
	private Integer duration;
	@JsonIgnore
	private Organizer organizer;
	private String status; // Approved / Denied / Deleted / ToBeAdded / ToBeDeleted

	public Event(String title, String theme, String description, String location, Integer maxCapacity, Integer day,
			String month, Integer year, Integer hour, Integer minute, Integer duration) {
		// this.id=id;
		this.title = title;
		this.theme = theme;
		this.description = description;
		this.location = location;
		this.maxCapacity = maxCapacity;
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.status = "ToBeAdded";
		this.duration = duration;

	}

	// Getters + Setters

	// ToString
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", theme=" + theme + ", description=" + description
				+ ", location=" + location + ", maxCapacity=" + maxCapacity + ", day=" + day + ", month=" + month
				+ ", year=" + year + ", hour=" + hour + ", minute=" + minute + ", duration=" + duration + ", organizer="
				+ organizer + ", status=" + status + "]";
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getMinute() {
		return minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
