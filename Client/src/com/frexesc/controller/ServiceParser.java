package com.frexesc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ServiceParser {
	public static String BASE_URL = "http://localhost:8080/web-services/";
	
	public static String readUrl(String urlString) throws Exception
	{
		BufferedReader reader = null;
		try
		{
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally
		{
			if (reader != null)
				reader.close();
		}

	}
	
	
	public static String postUrl(String urlString, String[] paramName, String[] paramValue) throws Exception
	{
		BufferedReader reader = null;
		try
		{
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", "25");
			
			
			OutputStream out = conn.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			
			for (int i = 0; i < paramName.length; i++){
				writer.write(paramName[i]);
				writer.write("=");
				writer.write(URLEncoder.encode(paramValue[i], "UTF-8"));
				writer.write("&");
			}
			writer.close();
			out.close();
			
			
			
			
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			
			conn.disconnect();
			return sb.toString();
		} finally
		{
			if (reader != null)
				reader.close();
		}

	}
	
	public static <T> List<T> parseJsonToGenericlist(String json, Class<T> type){
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		JsonArray courseArray = jsonParser.parse(json).getAsJsonArray();
		List<T> coursesList = new ArrayList<T>();
		for (JsonElement course : courseArray)
		{
			T courseObj = gson.fromJson(course, type);
			coursesList.add(courseObj);
		}
		return coursesList;
	}
}
