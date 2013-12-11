package com.frexesc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class HttpRequest {

	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String URL_MASTER = "http://esc-wbd.herokuapp.com/";
	private static final HttpClient client = HttpClientBuilder.create().build(); 

	// HTTP GET request
	public static String sendGet(String url) throws Exception {
		HttpGet request = new HttpGet(URL_MASTER + url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}

	// HTTP POST request
	public static String sendPost(String url) throws Exception {
		HttpPost post = new HttpPost(URL_MASTER + url);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("cn", ""));
		urlParameters.add(new BasicNameValuePair("locale", ""));
		urlParameters.add(new BasicNameValuePair("caller", ""));
		urlParameters.add(new BasicNameValuePair("num", "12345"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}
	
	public static String sendPut(String path, List<NameValuePair> hm) throws Exception {
		List<NameValuePair> params = hm;
		HttpPut put = new HttpPut(URL_MASTER + path);
		put.setEntity(new UrlEncodedFormEntity(params));
		put.setHeader("User-Agent", USER_AGENT);
		
		HttpResponse response = client.execute(put);
		System.out.println("\nSending 'PUT' request to URL : " + path);
		System.out.println("Put parameters : " + put.getEntity());
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}
	
	public static String sendDelete(String url) throws Exception {
		HttpDelete request = new HttpDelete(URL_MASTER + url);
		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'DELETE' request to URL : " + url);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}
}