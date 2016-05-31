package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class googleAPI {
	static String url = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	static String url2 = "https://maps.googleapis.com/maps/api/geocode/json?latlng=";
	static String url3 = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=Washington,DC&destinations=New+York+City,NY";
	
	//`
	
	/*
	 * get the coordinate from the postal code given.
	 * As this method required a proper api key , this is a way to get past the temporary requirement by checking the message if its okay , if not re request recursively after a time out of 1 second.
	 */
	public static Double[] getCoordinatesFromPostalCode(String postal)throws IOException, JSONException 
	{
		Double[] result = {(double) 0,(double) 0};
		JSONObject json = readJsonFromUrl(url+postal);

		System.out.println("json "+json.toString());
		String status = json.get("status").toString();
		if(status.equals("OK"))
		{
			JSONArray results =  json.getJSONArray("results");
			JSONObject geometry = results.getJSONObject(0).getJSONObject("geometry");
			JSONObject location = (JSONObject) geometry.get("location");
			Double lat = (Double) location.get("lat");
			Double lng = (Double) location.get("lng");
			
			result[0] = Double.parseDouble(lat.toString());
			result[1] = Double.parseDouble(lng.toString());
		}
		else if (status.equals("OVER_QUERY_LIMIT"))
		{
			delay(1000);
			result = getCoordinatesFromPostalCode(postal);
		}
		return result;
	}
	/*
	 * Gets the address given a the latitude and longitude
	 * As this method required a proper api key , this is a way to get past the temporary requirement by checking the message if its okay , if not re request recursively after a time out of 1 second.
	 */
	public static String getAddressFromCoordinates(Double Latitude, Double Longitude) throws IOException, JSONException
	{
		String result = "";
		JSONObject json = readJsonFromUrl(url+Latitude+","+Longitude);
		
		System.out.println("json "+json.toString());
		String status = json.get("status").toString();
		if(status.equals("OK"))
		{
			JSONArray results =  json.getJSONArray("results");
			result = results.getJSONObject(0).getString("formatted_address");
		}
		else if (status.equals("OVER_QUERY_LIMIT"))
		{
			delay(1000);
			result = getAddressFromCoordinates(Latitude,Longitude);
		}
		return result;
		
	}

	public static String getDistanceMatrix(Double Latitude, Double Longitude) throws IOException, JSONException
	{
		String result = "";
		JSONObject json = readJsonFromUrl(url3+Latitude+","+Longitude);
		
		System.out.println("json "+json.toString());
		String status = json.get("status").toString();
		if(status.equals("OK"))
		{
			JSONArray results =  json.getJSONArray("results");
			result = results.getJSONObject(0).getString("formatted_address");
		}
		else if (status.equals("OVER_QUERY_LIMIT"))
		{
			delay(1000);
			result = getAddressFromCoordinates(Latitude,Longitude);
		}
		return result;
		
	}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	}
	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	
	public static void delay(int amount)
	{
		try {
		    Thread.sleep(amount);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}
