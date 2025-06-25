package com.snhu.sslserver;

import java.security.MessageDigest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";
@RestController
class ServerController {
	@RequestMapping("/hash")
	public String myHash() throws Exception{
		String data = "Hello Cameron Beck";
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(data.getBytes());
		byte[] digest = md.digest();
		StringBuffer hexString = new StringBuffer();
		
		for(int i = 0; i <digest.length;i++){
			hexString.append(Integer.toHexString(0xFF & digest[i]));
		}
		return "<p>data: "+data+hexString.toString();
	}
	
}
