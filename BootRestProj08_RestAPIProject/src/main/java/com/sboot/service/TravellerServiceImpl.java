package com.sboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.sboot.exception.GlobalException;
import com.sboot.exception.TravellerNotFoundException;
import com.sboot.model.TravellerEntity;
import com.sboot.repository.ITravellerRepository;
import com.sboot.vo.TravellerVO;

@Service("travellerRepo")
public class TravellerServiceImpl implements ITravellerService {

    
	
	@Autowired
	private ITravellerRepository travellerRepo;

  

	@Override
	public String registerTraveller(TravellerVO vo) {
		
		//use repo
		TravellerEntity entity=new TravellerEntity();
		BeanUtils.copyProperties(vo, entity);
		travellerRepo.save(entity);
    return "Traveller saved with id value::"+entity.getTraveller_id();
	}

	@Override
	public String registerTravellers(List<TravellerVO> vo) {

		List<TravellerEntity> list = vo.stream().map((voEntity) ->{
			 TravellerEntity entity =new TravellerEntity();
			    BeanUtils.copyProperties(voEntity, entity);
			    travellerRepo.save(entity);
			    return entity;
		}).toList();
	
		return "Traveller saved  with id values::"+list.stream().map((entity) ->entity.getTraveller_id()).toList();
	}

	@Override
	public TravellerVO findById(Integer id) {
		
	 TravellerEntity entity = travellerRepo.findById(id).orElseThrow(()-> new TravellerNotFoundException("invald id"));
	 TravellerVO vo=new TravellerVO();
	 BeanUtils.copyProperties(entity, vo);
	 return vo;
	}
	
	
	
	@Override
	public List<TravellerVO> findAll() {
		//use repo
		List<TravellerEntity> all = travellerRepo.findAll();
		 return all.stream().map((entity) ->{
			TravellerVO vo=new TravellerVO();
			BeanUtils.copyProperties(entity, vo);
			return vo;
		}).toList();
	}

	@Override
	public List<TravellerVO> findByVisitedCountries(List<String> countries) {
		
		List<TravellerEntity> list = travellerRepo.findByVisitedCountries(countries);
		
		 return list.stream().map((Entity) ->{
			TravellerVO vo=new TravellerVO();
			BeanUtils.copyProperties(Entity, vo);
			return vo;
		}).toList();
		
	}

	@Override
	public List<TravellerVO> findAllTravllersLocation(List<String> country)
	{
		  List<TravellerEntity> countries = travellerRepo.findByTravellersNativeLocations(country);
		  return countries.stream().map((Entity) ->{
				TravellerVO vo=new TravellerVO();
				BeanUtils.copyProperties(Entity, vo);
				return vo;
			}).toList();
			
	}

	@Override
	public String updateLocationByAge(String location, Integer age) {
		
		
		 int updateLocationByAge = travellerRepo.updateLocationByAge(location, age);
		  
		  return "Travellers updated count::"+updateLocationByAge;
	}

	

	@Override
	public String updateTraveller(TravellerVO vo) 
	{
		//use repo
		 TravellerEntity entity = travellerRepo.findById(vo.getTraveller_id()).orElseThrow(()-> new TravellerNotFoundException("invald id"));
		     BeanUtils.copyProperties(vo, entity);
			 TravellerEntity save = travellerRepo.save(entity);
			 return "Traveller updated wiith id value  :"+save.getTraveller_id()+"sucessfullty";
		
		
	      //throw new TravellerNotFoundException();
	}

	@Override
	public String deleteById(Integer id) {
		//use repo
		 TravellerEntity entity = travellerRepo.findById(id).orElseThrow(()-> new TravellerNotFoundException("invald id"));
		 if(entity!=null)
		 {
			 travellerRepo.deleteById(entity.getTraveller_id());
			 return "Traveller deleted successfully :"+entity.getTraveller_id();
		 }
		
	      throw new TravellerNotFoundException();
	}
	
	
	
	@Override
	public String deleteTravellerByVisitedCountries(List<String> countries)
	{
	    //frist delete child table by visitedCountries
		//use repo
		List<Integer> list = travellerRepo.selectAllTravellerByVisitedCountries(countries);
		//make parent class entity as orphan and delete them
		travellerRepo.deleteAllById(list);
		return "Travellers are deleted successfully and count is:"+list;

	}

}




