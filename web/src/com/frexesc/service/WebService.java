package com.frexesc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/**
 * This WebService Class is Copyrighted to @freedomofkeima 2013
 *
 */

@SuppressWarnings("deprecation")
public class WebService {
	/** List of Attributes */
	private ArrayList<NameValuePair> mParams;
	private ArrayList<NameValuePair> mHeaders;
	private String mUrl;
	private int mResponseCode;
	private String mMessage;
	private String mResponse;

	public static enum REQUEST_METHOD {
		GET, POST
	};

	/** List of Methods */
	public String getResponse() {
		return mResponse;
	}

	public String getErrorMessage() {
		return mMessage;
	}

	public int getResponseCode() {
		return mResponseCode;
	}

	public WebService(String url) {
		this.mUrl = url;
		mParams = new ArrayList<NameValuePair>();
		mHeaders = new ArrayList<NameValuePair>();
	}

	public void addParam(String name, String value) {
		mParams.add(new BasicNameValuePair(name, value));
	}

	public void addHeader(String name, String value) {
		mHeaders.add(new BasicNameValuePair(name, value));
	}

	/** Execute specific request (Get / Method) **/
	public void execute(REQUEST_METHOD method) throws Exception {
		/** Switch between GET and POST */
		switch (method) {
		case GET: {
			String tempParams = "";
			if (!mParams.isEmpty()) {
				tempParams += "?";

				for (int i = 0; i < mParams.size(); i++) {
					String paramStr = mParams.get(i).getName()
							+ "="
							+ URLEncoder.encode(mParams.get(i).getValue(),
									"UTF-8");
					if (tempParams.length() > 1) {
						tempParams += "&" + paramStr;
					} else {
						tempParams += paramStr;
					}
				}
			}
			HttpGet request = new HttpGet(mUrl + tempParams);

			for (int i = 0; i < mHeaders.size(); i++) {
				request.addHeader(mHeaders.get(i).getName(), mHeaders.get(i)
						.getValue());
			}

			executeRequest(request);
			break;
		}
		case POST: {
			HttpPost request = new HttpPost(mUrl);

			for (int i = 0; i < mHeaders.size(); i++) {
				request.addHeader(mHeaders.get(i).getName(), mHeaders.get(i)
						.getValue());
			}

			if (!mParams.isEmpty()) {
				request.setEntity(new UrlEncodedFormEntity(mParams, HTTP.UTF_8));
			}

			executeRequest(request);
			break;
		}

		}
	}

	/** Execute request from specific URL */
	private void executeRequest(HttpUriRequest request) {

		HttpClient client = new DefaultHttpClient();

		HttpResponse httpResponse;
		HttpEntity entity = null;

		try {
			if (request != null) {
				httpResponse = client.execute(request);
				mResponseCode = httpResponse.getStatusLine().getStatusCode();
				mMessage = httpResponse.getStatusLine().getReasonPhrase();

				entity = httpResponse.getEntity();
			}

			if (entity != null) {
				InputStream in = entity.getContent();
				BufferedReader br = new BufferedReader(
						new InputStreamReader(in));
				StringBuilder sb = new StringBuilder();
				String line = null;
				try {
					while ((line = br.readLine()) != null) {
						sb.append(line + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					mResponse = sb.toString();
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (ClientProtocolException e) {
			client.getConnectionManager().shutdown();
			e.printStackTrace();
		} catch (IOException e) {
			client.getConnectionManager().shutdown();
			e.printStackTrace();
		}

	}

	/** Execute request from specific URL */
	public void executeRequest(HttpPost request) {

		HttpClient client = new DefaultHttpClient();

		HttpResponse httpResponse;
		HttpEntity entity = null;

		try {
			if (request != null) {
				httpResponse = client.execute(request);
				mResponseCode = httpResponse.getStatusLine().getStatusCode();
				mMessage = httpResponse.getStatusLine().getReasonPhrase();

				entity = httpResponse.getEntity();
			}

			if (entity != null) {
				InputStream in = entity.getContent();
				/** Parsing input to GSON String */
				// TODO : Refactor parser to new method @freedomofkeima
				BufferedReader br = new BufferedReader(
						new InputStreamReader(in));
				StringBuilder sb = new StringBuilder();
				String line = null;
				try {
					while ((line = br.readLine()) != null) {
						sb.append(line + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					mResponse = sb.toString();
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
