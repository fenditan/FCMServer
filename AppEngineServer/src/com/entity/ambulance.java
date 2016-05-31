package com.entity;


public class ambulance {
	String ambulanceName = "";
	Double latitude = (double) 0;// Refers to Latitude of location
	Double longitude = (double) 0;// Refers to Longitude for location
	public ambulance(String ambulanceName, Double latitude,Double longitude)
	{
		this.ambulanceName = ambulanceName;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getAmbulanceName()
	{
		return ambulanceName;
	}
	public Double getLatitude()
	{
		return latitude;
	}
	public Double getLongitude()
	{
		return longitude;
	}
}

