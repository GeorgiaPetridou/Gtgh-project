package com.example.demo.users;


public class Event {
	private static Integer counter = 0;
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
	private Organizer organizer;
	private String status; //  Added / Denied / Deleted / ToBeAdded / ToBeDeleted
	private int countVisitors;
	
	//Constractor
	public Event(String title, String theme, String description, String location, Integer maxCapacity, Integer day,
			String month, Integer year, Integer hour, Integer minute,Organizer organizer) {
		this.id=counter++;
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
		this.organizer = organizer;
		this.status = "ToBeAdded";
		this.countVisitors=0;
	}

	//Getters + Setters
	
	

	public String getTitle() {
		return title;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
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



	public int getMaxCapacity() {
		return maxCapacity;
	}



	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}



	public int getDay() {
		return day;
	}



	public void setDay(int day) {
		this.day = day;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public int getHour() {
		return hour;
	}



	public void setHour(int hour) {
		this.hour = hour;
	}



	public int getMinute() {
		return minute;
	}



	public void setMinute(int minute) {
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

	public int getCountVisitors() {
		return countVisitors;
	}

	public void setCountVisitors(int countVisitors) {
		this.countVisitors = countVisitors;
	}

	

	//ToString	
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", theme=" + theme + ", description=" + description
				+ ", location=" + location + ", maxCapacity=" + maxCapacity + ", day=" + day + ", month=" + month
				+ ", year=" + year + ", hour=" + hour + ", minute=" + minute + ", organizer=" + organizer + ", status="
				+ status + "]";
	}
//	
//	
//	public void addToCountVisitors() {
//		this.countVisitors++;
//	}
//
//	public void removeToCountVisitors() {
//		this.countVisitors--;
//	}
	
	
	
}
