package com.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.service.ITravellerService;
import com.sboot.vo.TravellerVO;

@RestController
@RequestMapping("/traveller-api")
public class TravellerOperations {
	
	@Autowired
	private ITravellerService travellerService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody TravellerVO vo)
	{
		
		String registerTraveller = travellerService.registerTraveller(vo);
		 return new ResponseEntity<String>(registerTraveller,HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/registerAll",
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
		    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
		)
	public ResponseEntity<String> registerTravellers(@RequestBody List<TravellerVO> vo)
	{
		
		String registerTraveller = travellerService.registerTravellers(vo);
		 return new ResponseEntity<String>(registerTraveller,HttpStatus.OK);
	}
	
	
	@GetMapping("/findById/{id}")		
	public ResponseEntity<TravellerVO> TravellersById(@PathVariable Integer id)
	{
		System.out.println("TravellerOperations.TravellersById()");
		TravellerVO entity = travellerService.findById(id);
		 return new ResponseEntity<TravellerVO>(entity,HttpStatus.OK);
	}
	
	
	@GetMapping("/findAll")		
	public ResponseEntity<List<TravellerVO>>TravellersAll()
	{
		System.out.println("TravellerOperations.TravellersAll()");
		//use service
		List<TravellerVO> all = travellerService.findAll();
		 return new ResponseEntity<List<TravellerVO>>(all,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/findAllByVisitedCountries/{countries}")		
	public ResponseEntity<List<TravellerVO>> TravellersByVistiedCountries(@PathVariable List<String> countries)
	{
		System.out.println("TravellerOperations.TravellersById()");
		List<TravellerVO> list = travellerService.findByVisitedCountries(countries);
		 return new ResponseEntity<List<TravellerVO>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/findByNativeLocation/{countries}")		
	public ResponseEntity<List<TravellerVO>> TravellersByCurrentLocation(@PathVariable List<String> countries)
	{
		//use service
		 return new ResponseEntity<List<TravellerVO>>(travellerService.findAllTravllersLocation(countries),HttpStatus.OK);
	}
	

	@PatchMapping("/updateLocation/{location}/{age}")		
	public ResponseEntity<String> TravellersByCurrentLocation(@PathVariable String location,@PathVariable Integer age)
	{
		//use service
		 return new ResponseEntity<String>(travellerService.updateLocationByAge(location, age),HttpStatus.OK);
	}
	
	

	@PutMapping("/update")		
	public ResponseEntity<String> updateTraveller(@RequestBody TravellerVO vo)
	{
		//use service
		 return new ResponseEntity<String>(travellerService.updateTraveller(vo),HttpStatus.OK);
	}

	
	@DeleteMapping("/deleteByCountries/{countries}")		
	public ResponseEntity<String> removeByCountriesVisited(@PathVariable List<String> countries)
	{
		//use service.
		return new ResponseEntity<String>(travellerService.deleteTravellerByVisitedCountries(countries),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteById/{id}")		
	public ResponseEntity<String> removeById(@PathVariable Integer id)
	{
		//use service.
		return new ResponseEntity<String>(travellerService.deleteById(id),HttpStatus.OK);
		
	}

	

}
