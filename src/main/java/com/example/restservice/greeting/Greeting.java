package com.example.restservice.greeting;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Greeting {

	 final long id;
	 final String content;
	
}
