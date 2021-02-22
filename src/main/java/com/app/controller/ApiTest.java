package com.app.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTest {
	@RequestMapping(value="getJson", method = RequestMethod.GET)
	public Map<String, Object> getJson() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(map, map)
	}
}
