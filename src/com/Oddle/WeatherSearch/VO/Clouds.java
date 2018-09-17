/*Author - Adit
 * Date 19/3/2017
 */
package com.Oddle.WeatherSearch.VO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Clouds implements Serializable {

	private static final long serialVersionUID = -8841197286768728465L;
	@Column(name="cloud_percent")
	private int all;

	/**
	 * 
	 */
	public Clouds() {
	}

	

	/**
	 * @return the all
	 */
	public Integer getAll() {
		return all;
	}

	/**
	 * @param all
	 *            the all to set
	 */
	public void setAll(Integer all) {
		this.all = all;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Clouds [all=");
		builder.append(all);
		builder.append("]");
		return builder.toString();
	}

}
