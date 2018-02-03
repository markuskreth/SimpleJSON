package de.ralleytn.simple.json;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JSONParserTest {

	private JSONParser parser;

	@BeforeEach
	void setUp() throws Exception {
		parser = new JSONParser();
	}

	@Test
	void testObjectFromString() throws JSONParseException {
		Object o= parser.parse("{}");
		assertTrue(o instanceof JSONObject);
		JSONObject obj = (JSONObject) o;
		assertEquals(0, obj.size());
		
		assertTrue(o instanceof JSONObject);
		o= parser.parse("{\"key\":\"value\"}");
		obj = (JSONObject) o;
		assertEquals(1, obj.size());
		assertTrue(obj.containsKey("key"));
		assertEquals("value", obj.get("key"));
	}

	@Test
	void testArrayFromString() throws JSONParseException {

		Object o= parser.parse("[]");
		assertTrue(o instanceof JSONArray);
		JSONArray arr = (JSONArray) o;
		assertEquals(0, arr.size());
	}
}
