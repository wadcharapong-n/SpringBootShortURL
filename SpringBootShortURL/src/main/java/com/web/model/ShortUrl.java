package com.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shortUrl")
public class ShortUrl {
	@Id
	private String id;
	
	String orginalUrl;
	
	String shortUrl;
	
	String clickCount;
	
	public ShortUrl() {
		
	}

	public ShortUrl(String orginalUrl, String shortUrl, String clickCount) {
		super();
		this.orginalUrl = orginalUrl;
		this.shortUrl = shortUrl;
		this.clickCount = clickCount;
	}

	@Override
	public String toString() {
		return "ShortUrl [id=" + id + ", orginalUrl=" + orginalUrl + ", ShortUrl=" + shortUrl + ", clickCount="
				+ clickCount + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrginalUrl() {
		return orginalUrl;
	}

	public void setOrginalUrl(String orginalUrl) {
		this.orginalUrl = orginalUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getClickCount() {
		return clickCount;
	}

	public void setClickCount(String clickCount) {
		this.clickCount = clickCount;
	}
	
	
	
	
	
	

}
