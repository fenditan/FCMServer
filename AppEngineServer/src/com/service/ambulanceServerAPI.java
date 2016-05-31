package com.service;

import java.io.*;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.entity.ambulance;

@Api(name="ambulanceServerAPI",version="v1", description="Ambulance Call Server")
public class ambulanceServerAPI {


	
	/*
	 * Allows startup for all services required
	 * Input : quiz Results, Postal code / Coordinates to be decided
	 * Output : Area with a list of categories with locations within them
	 */
	@ApiMethod(name="startUp")
	public void startUp() {
		System.out.println("Starting Setup");
		settings.initSetup();
		System.out.println("Setup Complete");
		
	}
	
//	/*
//	 * Get score based on Input Coordinates / postal code
//	 * Input : quiz Results, Postal code / Coordinates to be decided
//	 * Output : Area with a list of categories with locations within them
//	 */
//	@ApiMethod(name="getIndividualResults")
//	public area getIndividualResults(@Named("quizResults") String quizResults,@Named("Latitude") Double Latitude,@Named("Longitude") Double Longitude) {
//		
//		return LogicController.getIndividualAreaScore("",quizResults,Latitude,Longitude);
//	}
//	
//	/*
//	 * Get score based on All Coordinates in the list
//	 * Input : quiz Results
//	 * Output : list of Area with a list of categories with locations within them
//	 */
//	@ApiMethod(name="getCompleteResults")
//	public List<area> getCompleteResults(@Named("quizResults") String quizResults) {
//
//		return LogicController.getCompleteAreaScore(quizResults);
//	}
	
	@ApiMethod(name="callAmbulance")
	public ambulance callAmbulance(@Named("quizResults") String quizResults) {

		System.out.println("starting sending to fcm");
		FirebaseOptions options = null;
		try {
			options = new FirebaseOptions.Builder()
					.setServiceAccount(new FileInputStream(
							"src/Development/Notifications/FCMServer-10635b55de7d.json"))
					.setDatabaseUrl("https://project-8376045166047526213.firebaseio.com/")
					.build();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		FirebaseApp.initializeApp(options);

		// Obtain serverKey from Project Settings -> Cloud Messaging tab
		// for "My Notification Server" project in Firebase Console.
		final String serverKey = "10635b55de7d755ea9c9ae8860e4ad6b50310a88";
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					Sender sender = new FCMSender(serverKey);
					Message message = new Message.Builder().collapseKey("message").timeToLive(3).delayWhileIdle(true)
							.addData("message", "Notification from Java application").build();

					// Use the same token(or registration id) that was earlier
					// used to send the message to the client directly from
					// Firebase Console's Notification tab.
					
					Result result = sender.send(message,
							"cM60NEJ2rK0APA91bHFq5ohk0qP3SZWtmicY88e2h0_Epni-ND8yRFtq39jHNWIUIbv8C2p7A4vOi4y2eqVQNRimgDSUL7llC4vpH4i7YCju3yOS8zHSpnu21gjBfMVvCS3PYpKHG-ag9Z65mqqviNj",
							1);
					System.out.println("Result: " + result.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
		try {
			t.join();
		} catch (InterruptedException iex) {
			iex.printStackTrace();
		}
		System.out.println("complete sending to fcm");
		return LogicController.notifyAmbulance(quizResults);
	}
	

	
}
