package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Greeting {
    @RequestMapping("")
    public String greeter(@RequestParam(value="first_name", required=false) String firstName,
    					@RequestParam(value="last_name", required=false) String lastName,
    					@RequestParam(value="times", required=false) Integer times
    					) {
    	if (firstName == null) {
    		return "Hello Human";
    	}
    	if(times > 0){
    		String x= "";
			for (int i=0; i<times; i++) {
				x += "Hello " + firstName + " " + lastName+" ";
			}
			return x;
    	}
		else {
			return "Hello " + firstName + " " + lastName;
		}
}
}
