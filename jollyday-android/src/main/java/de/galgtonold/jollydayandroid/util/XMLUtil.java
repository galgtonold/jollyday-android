/**
 * Copyright 2010 Sven Diedrichsen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *
 * @author sven
 * @version $Id: $
 */
package de.galgtonold.jollydayandroid.util;

import org.joda.time.DateTimeConstants;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import de.galgtonold.jollydayandroid.HolidayType;
import de.galgtonold.jollydayandroid.config.Configuration;
import de.galgtonold.jollydayandroid.config.Month;
import de.galgtonold.jollydayandroid.config.Weekday;
import de.galgtonold.jollydayandroid.holidaytype.LocalizedHolidayType;

public class XMLUtil {

	/**
	 * the package name to search for the generated java classes.
	 */
	public static final String PACKAGE = "de.galgtonold.jollydayandroid.config";

	private static Logger LOG = Logger.getLogger(XMLUtil.class.getName());

	/**
	 * Unmarshalls the configuration from the stream. Uses <code>JAXB</code> for
	 * this.
	 * 
	 * @param stream
	 *            a {@link InputStream} object.
	 * @return The unmarshalled configuration.
	 * @throws IOException
	 *             Could not close the provided stream.
	 */
	public Configuration unmarshallConfiguration(InputStream stream) throws IOException {
		if (stream == null) {
			throw new IllegalArgumentException("Stream is NULL. Cannot read XML.");
		}
		Serializer serializer = new Persister();
		try {
			return serializer.read(Configuration.class, stream);
		} catch (Exception e) {
			throw new IOException("Error reading holiday XML file", e);
		}
	}

	/**
	 * Returns the <code>DateTimeConstants</code> value for the given weekday.
	 * 
	 * @param weekday
	 *            a {@link de.galgtonold.jollydayandroid.config.Weekday} object.
	 * @return DateTimeConstants value.
	 */
	public final int getWeekday(Weekday weekday) {
		switch (weekday) {
		case MONDAY:
			return DateTimeConstants.MONDAY;
		case TUESDAY:
			return DateTimeConstants.TUESDAY;
		case WEDNESDAY:
			return DateTimeConstants.WEDNESDAY;
		case THURSDAY:
			return DateTimeConstants.THURSDAY;
		case FRIDAY:
			return DateTimeConstants.FRIDAY;
		case SATURDAY:
			return DateTimeConstants.SATURDAY;
		case SUNDAY:
			return DateTimeConstants.SUNDAY;
		default:
			throw new IllegalArgumentException("Unknown weekday " + weekday);
		}
	}

	/**
	 * Returns the <code>DateTimeConstants</code> value for the given month.
	 * 
	 * @param month
	 *            a {@link de.galgtonold.jollydayandroid.config.Month} object.
	 * @return DateTimeConstants value.
	 */
	public int getMonth(Month month) {
		switch (month) {
		case JANUARY:
			return DateTimeConstants.JANUARY;
		case FEBRUARY:
			return DateTimeConstants.FEBRUARY;
		case MARCH:
			return DateTimeConstants.MARCH;
		case APRIL:
			return DateTimeConstants.APRIL;
		case MAY:
			return DateTimeConstants.MAY;
		case JUNE:
			return DateTimeConstants.JUNE;
		case JULY:
			return DateTimeConstants.JULY;
		case AUGUST:
			return DateTimeConstants.AUGUST;
		case SEPTEMBER:
			return DateTimeConstants.SEPTEMBER;
		case OCTOBER:
			return DateTimeConstants.OCTOBER;
		case NOVEMBER:
			return DateTimeConstants.NOVEMBER;
		case DECEMBER:
			return DateTimeConstants.DECEMBER;
		default:
			throw new IllegalArgumentException("Unknown month " + month);
		}
	}

	/**
	 * Gets the type.
	 * 
	 * @param type
	 *            the type of holiday in the config
	 * @return the type of holiday
	 */
	public HolidayType getType(de.galgtonold.jollydayandroid.config.HolidayType type) {
		switch (type) {
		case OFFICIAL_HOLIDAY:
			return LocalizedHolidayType.OFFICIAL_HOLIDAY;
		case UNOFFICIAL_HOLIDAY:
			return LocalizedHolidayType.UNOFFICIAL_HOLIDAY;
		default:
			throw new IllegalArgumentException("Unknown type " + type);
		}
	}
}
