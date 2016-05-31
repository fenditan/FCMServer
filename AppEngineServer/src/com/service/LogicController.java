package com.service;

import com.entity.ambulance;

public class LogicController {

	public static ambulance notifyAmbulance(String quizResults) {
		ambulance ambulance = new ambulance("TESTing22", 1.6222, 1.6222);
		System.out.println("inside notifier");
				return ambulance;
	}

}
// /*
// * returns the complete area score based on the quiz results
// */
// public static List<area> getCompleteAreaScore(String quizResults)
// {
// List<area> results = new ArrayList<area>();
// List<areaUnit> compareAreaList= dataList.getAreaList();
// for(int i = 0; i < compareAreaList.size();i++)
// {
// areaUnit temp = compareAreaList.get(i);
// area tempArea =
// getIndividualAreaScore(temp.getAreaName(),quizResults,temp.getLatitude(),temp.getLongitude());
//
// results.add(tempArea);
// }
//
// Collections.sort(results);
//
// List<area> finalResults = new ArrayList<area>();
// for(int i = 0; i < settings.getTopHowMany();i++)
// {
// finalResults.add(results.get(i));
// }
//
// return finalResults;
// }
// /*
// * returns the individual area score based on quiz results.
// * this takes in the individual address information.
// * as this is can be used by complete area and Directly , if address is blank
// , get the respective address.
// */
// public static area getIndividualAreaScore(String address,String quizResults ,
// Double Latitude, Double Longitude)
// {
// if(address.equals(""))
// {
// try {
// address = googleAPI.getAddressFromCoordinates(Latitude,Longitude);
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
// area area = new area(address,Latitude,Longitude);
// //area area = new area(address,1.36911,103.84543);
// char test = quizResults.charAt(0);
//
// for(int i = 0 ; i < quizResults.length();i++)
// {
// if (quizResults.charAt(i) == '1')
// {
// typeUnit temp = dataList.getTypeUnit(i);
// int score = temp.getScore();
// List<location> resultList =
// getIndividualCategoryScoreList(Latitude,Longitude,temp.getList(),score);
//
// category cat = new category();
// cat.addLocations(resultList);
// cat.setCategoryType(temp.getType());
// area.addCategory(cat);
// }
// }
// return area;
// }
