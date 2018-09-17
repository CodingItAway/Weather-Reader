/*Author - Adit
 * Date 19/3/2017
 */
package com.Oddle.WeatherSearch.VO;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Rain {
	
	@Column(name="rain_volume")
	private Integer rainVolume;

	/**
	 * @return the rainVolume
	 */
	public Integer get3h() {
		return rainVolume;
	}

	/**
	 * @param rainVolume
	 *            the rainVolume to set
	 */
	public void set3h(Integer rainVolume) {
		this.rainVolume = rainVolume;
	}

	/**
	 * 
	 */
	public Rain() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rainVolume == null) ? 0 : rainVolume.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rain other = (Rain) obj;
		if (rainVolume == null) {
			if (other.rainVolume != null)
				return false;
		} else if (!rainVolume.equals(other.rainVolume))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rain [rainVolume=");
		builder.append(rainVolume);
		builder.append("]");
		return builder.toString();
	}

}
