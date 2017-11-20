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
 */
package de.galgtonold.jollydayandroid.parser.impl;

import org.joda.time.LocalDate;

import java.util.Set;

import de.galgtonold.jollydayandroid.Holiday;
import de.galgtonold.jollydayandroid.HolidayType;
import de.galgtonold.jollydayandroid.config.Fixed;
import de.galgtonold.jollydayandroid.config.Holidays;
import de.galgtonold.jollydayandroid.parser.AbstractHolidayParser;

/**
 * The Class FixedParser. Parses a fixed date
 * 
 * @author tboven
 * @version $Id: $
 */
public class FixedParser extends AbstractHolidayParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.galgtonold.jollydayandroid.parser.HolidayParser#parse(int, java.util.Set,
	 * de.galgtonold.jollydayandroid.config.Holidays)
	 */
	/** {@inheritDoc} */
	public void parse(int year, Set<Holiday> holidays, final Holidays config) {
		for (Fixed f : config.getFixed()) {
			if (!isValid(f, year)) {
				continue;
			}
			LocalDate date = calendarUtil.create(year, f);
			LocalDate movedDate = moveDate(f, date);
			HolidayType type = xmlUtil.getType(f.getLocalizedType());
			Holiday h = new Holiday(movedDate, f.getDescriptionPropertiesKey(), type);
			holidays.add(h);
		}
	}

}
