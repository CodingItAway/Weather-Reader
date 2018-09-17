/*Author - Adit
 * Date 19/3/2017
 */
package com.Oddle.WeatherSearch.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Oddle.WeatherSearch.DAO.WeatherSearchPageDAO;
import com.Oddle.WeatherSearch.Service.WeatherSearchPageService;
import com.Oddle.WeatherSearch.VO.CityDetails;

public class WeatherSearchPageServiceImpl implements WeatherSearchPageService{
	
	@Autowired
	private WeatherSearchPageDAO weatherSearchPageDAO;
	
	public WeatherSearchPageDAO getWeatherSearchPageDAO() {
		return weatherSearchPageDAO;
	}

	public void setWeatherSearchPageDAO(WeatherSearchPageDAO weatherSearchPageDAO) {
		this.weatherSearchPageDAO = weatherSearchPageDAO;
	}

	public List<CityDetails> getWeatherDataService()
	{
		return weatherSearchPageDAO.getWeatherDataList();		
	}

	public void writeWeatherDataToDB(CityDetails weatherDetails) {
		
		weatherSearchPageDAO.writeWeatherDataToDB(weatherDetails);
	}

	public void deleteWeatherLogRecord(int idForDelete) {
		
		weatherSearchPageDAO.deleteWeatherLogRecord(idForDelete);
	}

	public void deleteWeatherLogRecordForCityId(int cityIdForDelete) {
		
		weatherSearchPageDAO.deleteWeatherLogRecordForCityId(cityIdForDelete);
	}

}
