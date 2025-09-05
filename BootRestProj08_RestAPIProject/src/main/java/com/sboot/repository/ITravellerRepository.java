package com.sboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sboot.model.TravellerEntity;
import com.sboot.vo.TravellerVO;

import jakarta.transaction.Transactional;

public interface ITravellerRepository extends JpaRepository<TravellerEntity, Integer>
{

	
	@Query("select te from TravellerEntity te join te.visitedCountries vs where vs in :countries")
	public List<TravellerEntity> findByVisitedCountries(List<String> countries);
	
	

	@Query("select te from TravellerEntity te where te.nativeLocation  in :locations")
	public List<TravellerEntity> findByTravellersNativeLocations(List<String> locations);
	
	
	@Query("update TravellerEntity te set te.currentLocation = :newLocation, te.updatedCount =te.updatedCount+1  where te.age<= :age")
	@Modifying
	@Transactional
    public int updateLocationByAge(String newLocation,Integer age);	
	
	
	//query to find all tid of visitedcountries
	
	@Query("select t.traveller_id from TravellerEntity t join t.visitedCountries vs where vs  in :countries")
	@Modifying
	@Transactional
	public List<Integer> selectAllTravellerByVisitedCountries(List<String> countries);
	
	@Query("delete from TravellerEntity te where te.traveller_id in :travellersIds ")
	@Modifying
	@Transactional
	public int deleteByTravellersByIds(List<Integer> travellerIds);
	
	
	
	
}


