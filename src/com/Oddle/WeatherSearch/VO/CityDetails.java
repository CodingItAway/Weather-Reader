/*Author - Adit
 * Date 19/3/2017
 */
package com.Oddle.WeatherSearch.VO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name="CITY_DETAILS")
@NamedQueries({
    @NamedQuery(name="weather.byName",query="from CITY_DETAILS order by CITY_NAME asc"),
    @NamedQuery(name="weather.byCityId",query="from CITY_DETAILS where cityId=?"),
}) 
public class CityDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long cityId;	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int weatherRecordid;

	@Column(name="city_name")
	private String cityName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@OneToMany(mappedBy="weatherDetailsData")
	@Cascade(CascadeType.ALL)
	private Collection<CityWeatherData> weatherDetails = new ArrayList<CityWeatherData>();
	
	public int getId() {
		return weatherRecordid;
	}

	public void setId(int id) {
		this.weatherRecordid = id;
	}
	
	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Collection<CityWeatherData> getWeatherDetails() {
		return weatherDetails;
	}

	public void setWeatherDetails(Collection<CityWeatherData> weatherDetails) {
		this.weatherDetails = weatherDetails;
	}

}
