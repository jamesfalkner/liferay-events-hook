/**
 * Copyright 2016 Liferay, Inc. All rights reserved.
 * http://www.liferay.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author James Falkner
 */

package com.liferay.events.global.mobile.portlet;

public class Candidate {

	private String name;
	private String attendeeType;
	private String jobTitle;
	private String industry;
	private String city;
	private String country;
	private double distance;
	private String picUrl;
	private long eventContactId;
	private double likeness;

	public String getAttendeeType() {
		return attendeeType;
	}

	public void setAttendeeType(String attendeeType) {
		this.attendeeType = attendeeType;
	}

	public String getLikenessDescription() {
		return likenessDescription;
	}

	public void setLikenessDescription(String likenessDescription) {
		this.likenessDescription = likenessDescription;
	}

	private String likenessDescription;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public long getEventContactId() {
		return eventContactId;
	}

	public void setEventContactId(long eventContactId) {
		this.eventContactId = eventContactId;
	}

	public double getLikeness() {
		return likeness;
	}

	public void setLikeness(double likeness) {
		this.likeness = likeness;
	}
}
