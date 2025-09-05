package com.sboot.service;

import java.util.List;

import com.sboot.vo.TravellerVO;

public interface ITravellerService {
	
	
	
	//data jpa
	public String registerTraveller(TravellerVO vo);
	
	public String registerTravellers(List<TravellerVO> vo);
	
	
	public TravellerVO findById(Integer id);
	
	public List<TravellerVO> findAll();
	
	public List<TravellerVO> findByVisitedCountries(List<String> countries);
	
	public List<TravellerVO> findAllTravllersLocation(List<String> country);
	
	
	public String updateTraveller(TravellerVO vo);

	public String updateLocationByAge(String location,Integer age);
	
	
	public String deleteById(Integer id);
	
	public String deleteTravellerByVisitedCountries(List<String> countires);
	
	
	
	
	
	

}
