package com.kaveinga.pizzaria.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectUtil {

	public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}
}
