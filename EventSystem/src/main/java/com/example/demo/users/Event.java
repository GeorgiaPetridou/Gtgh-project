package com.example.demo.users;

public class Event {
	private static int counter = 0;
	private int id;
	private String title;
	private String theme;
	private String description;
	private String location;
	private int maxCapacity;
	private int day;
	private String month;
	private int year;
	private int hour;
	private int minute;
	private Organizer organizer;
	private String status; // Added / Denied / Deleted / ToBeAdded / ToBeDeleted	
	//private static List<Visitor> visitors= new ArrayList<Visitor>();
	private int countVisitors;
	
	//Constractor
	public Event(String title, String theme, String description, String location, int maxCapacity, int day,
			String month, int year, int hour, int minute,Organizer organizer) {
	
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
		this.status = "toBeAdded";
		this.countVisitors=0;
	}

	//Getters + Setters
	
	
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
		return "Event [title=" + title + ", organizer=" + organizer.getName() + ", status=" + status + "]";
	}
	
	public void addToCountVisitors() {
		this.countVisitors++;
	}
	
	public void removeToCountVisitors() {
		this.countVisitors--;
	}
	
	
	
}
