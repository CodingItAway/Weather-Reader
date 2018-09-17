/*Author - Adit
 * Date 19/3/2017
 */
package com.Oddle.WeatherSearch.DAO;

import java.util.List;

import com.Oddle.WeatherSearch.VO.CityDetails;

public interface WeatherSearchPageDAO {
	
	public void writeWeatherDataToDB(CityDetails weatherDetails);
	public List<CityDetails> getWeatherDataList();
	public void deleteWeatherLogRecord(int idForDelete);
	public void deleteWeatherLogRecordForCityId(int cityIdForDelete);

}
