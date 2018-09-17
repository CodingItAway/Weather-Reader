/*Author - Adit
 * Date 19/3/2017
 */
package com.Oddle.WeatherSearch.Service;

import java.util.List;
import com.Oddle.WeatherSearch.VO.CityDetails;

public interface WeatherSearchPageService {

	public List<CityDetails> getWeatherDataService();
	public void writeWeatherDataToDB(CityDetails weatherDetails);
	public void deleteWeatherLogRecord(int idForDelete);
	public void deleteWeatherLogRecordForCityId(int cityIdForDelete);
}
