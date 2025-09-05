package com.sboot.vo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TravellerVO {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "Traveller_id",initialValue = 1000,allocationSize=1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer traveller_id;
	@Column(length=30)
	@NonNull
	private String name;
	private Integer age;
	private LocalDateTime dob;
	@Column(length=30)
	@NonNull
	private String nativeLocation;
	@Column(length=30)
	@NonNull
	private String currentLocation;
	@Column(length=30)
	@NonNull
	private String headingTo;
	@Column(length=30,name="VistiedCountires_Traveller")
	@NonNull
	@ElementCollection
	@CollectionTable(name="VistedCountrries_Traveller",joinColumns=@JoinColumn(name="traveller_id"))
	
	private List<String> visitedCountries;

}
