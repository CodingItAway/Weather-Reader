/*Author - Adit
 * Date 19/3/2017
 */
package com.Oddle.WeatherSearch.DAOImpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.Oddle.WeatherSearch.DAO.WeatherSearchPageDAO;
import com.Oddle.WeatherSearch.VO.CityDetails;

public class WeatherSearchPageDAOImpl implements WeatherSearchPageDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void writeWeatherDataToDB(CityDetails weatherDetails) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(weatherDetails);
		session.getTransaction().commit();
		session.close();
	}

	public List<CityDetails> getWeatherDataList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("weather.byName");
		@SuppressWarnings("unchecked")
		List<CityDetails> weatherList = query.list();
		return weatherList;
	}

	public void deleteWeatherLogRecord(int idForDelete) {		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		CityDetails weatherDetails = (CityDetails)session.get(CityDetails.class, idForDelete);
		session.delete(weatherDetails);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteWeatherLogRecordForCityId(int cityIdForDelete) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("weather.byCityId");
		query.setInteger(0, cityIdForDelete);
		@SuppressWarnings("unchecked")
		List<CityDetails> weatherList = query.list();
		session.delete(weatherList.get(0));
		session.getTransaction().commit();
		session.close();
	}

}
