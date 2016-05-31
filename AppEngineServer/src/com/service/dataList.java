package com.service;


public class dataList {
//	static List<areaUnit> areaList = new ArrayList<areaUnit>();
	static boolean debug = false;
	public static void init()
	{
//		areaList = new ArrayList<areaUnit>();
//		initAreaList();//setup the area list that will be used for complete list

	}
//
//	/*
//	 * Initialize the contents of AreaList , in the War folder
//	 * The area list is in XML format , thus using the Document builder and getting the respective nodes required and storing them as a AreaUnit within a list.
//	 * 
//	 */
//	public static void initAreaList()
//	{
//		try {
//
//	         File inputFile = new File("./resource/AreaFile.xml");
//	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//	         Document doc = dBuilder.parse(inputFile);
//	         doc.getDocumentElement().normalize();
//	         NodeList nList = doc.getElementsByTagName("area");
//	         for (int i = 0; i < nList.getLength(); i++) {
//	            Node nNode = nList.item(i);
//	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//	               Element eElement = (Element) nNode;
//	               String name = eElement.getElementsByTagName("Name").item(0).getTextContent();
//	               String slatitude = eElement.getElementsByTagName("latitude").item(0).getTextContent();
//	               String slongitude = eElement.getElementsByTagName("longitude").item(0).getTextContent();
//	               double latitude = Double.parseDouble(slatitude);
//	               double longitude = Double.parseDouble(slongitude);
//	               areaUnit temp1 = new areaUnit(name,latitude,longitude);
//	               areaList.add(temp1);
//	            }
//	         }
//	      } catch (Exception e) {
//	         e.printStackTrace();
//	    }
//		//print what is in the array for debugging purposes
//		if(debug)
//		{
//			for (int i = 0; i<areaList.size();i++)
//			{
//				areaUnit temp = areaList.get(i);
//				System.out.println("NAME : " +temp.getAreaName() + " Latitude = "+temp.getLatitude()+" long " + temp.getLongitude());
//			}
//		}
//	}

}
