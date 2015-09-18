package com.andreylh.sqlvsnosql.trajectory;

import java.time.LocalDateTime;

import org.bson.Document;

public class Trajectory {
	private long id;
	private LocalDateTime dateTime;
	private double longitude;
	private double latitude;	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public Document getDocument() {
		Document doc = new Document();
		doc.append("id", id);
		doc.append("datetime", dateTime.toString());
		doc.append("longitude", longitude);
		doc.append("latitude", latitude);
		
		return doc;
	}
}
