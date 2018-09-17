/*Author - Adit
 * Date 19/3/2017
 */
package com.Oddle.WeatherSearch.VO;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Snow {
	
	@Column(name="snow_volume")
	private Integer snowVolume;

	/**
	 * @return the snowVolume
	 */
	public Integer get3h() {
		return snowVolume;
	}

	/**
	 * @param snowVolume
	 *            the snowVolume to set
	 */
	public void set3h(Integer snowVolume) {
		this.snowVolume = snowVolume;
	}

	/**
	 * 
	 */
	public Snow() {
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
		result = prime * result + ((snowVolume == null) ? 0 : snowVolume.hashCode());
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
		Snow other = (Snow) obj;
		if (snowVolume == null) {
			if (other.snowVolume != null)
				return false;
		} else if (!snowVolume.equals(other.snowVolume))
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
		builder.append("Rain [snowVolume=");
		builder.append(snowVolume);
		builder.append("]");
		return builder.toString();
	}

}
