package com.Geekster.zippopotam;

import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;

@SpringBootApplication
public class ZippopotamApplication {
	@SneakyThrows
	public static void main(String[] args) {

		URL getUrl = new URL("https://api.zippopotam.us/us/33162");
		HttpURLConnection  connection= (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();

		if(responseCode == 200){
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonResponseData = new StringBuilder();
			String readLine = null;
			while((readLine = br.readLine()) != null){
				jsonResponseData.append(readLine);
			}
			br.close();

			JSONObject data = new JSONObject(jsonResponseData.toString());
			System.out.println(data);
		}else{
			System.out.println("Not valid URL");
		}
	}

}
