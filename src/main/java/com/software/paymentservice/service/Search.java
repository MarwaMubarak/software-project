package com.software.paymentservice.service;

import java.util.ArrayList;
import java.util.Map;

import  com.software.paymentservice.Data.NameServicePair;
import  com.software.paymentservice.Data.SavedData;

public class Search {

	
	static public ArrayList<NameServicePair> search(String id) {
		ArrayList<NameServicePair> searchResult = new ArrayList<NameServicePair>();
		
		for(Map.Entry<String, Service> service : SavedData.getObj().services.entrySet()) {
			if(service.getKey().contains(id)) {				
				searchResult.add(new NameServicePair(service.getKey(), service.getValue() ) );
				
			}
		}
		return searchResult;
	}
	
	static public void showSearchResult(ArrayList<NameServicePair>searchResult) {
		for(int i =0 ;i<searchResult.size();i++) {
			System.out.println(searchResult.get(i).name);
		}		
	}
	 
}
