package org.gnius.hr.util;

import java.time.LocalDate;

public class DateUtil {
	public static boolean isIn(LocalDate from, LocalDate to, LocalDate search) {
		if (search == null) {
			throw new NullPointerException("Null search");
		}
		if (from == null) {
			if (to == null) {
				return true;
			} else {
				return to.compareTo(search) >= 0;
			}
		} else {
			if (to == null) {
				return from.compareTo(search) <= 0;
			} else {
				return to.compareTo(search) >= 0 && from.compareTo(search) <= 0;
			}
		}
	}
}
