package com.web.service;

import java.util.List;

import com.web.model.ShortUrl;

public interface ShortUrlService {

	public void createShortUrl(ShortUrl shortUrl);
	
	public void incrementUrl(String shortUrl);
	
	public List<ShortUrl> findAllShortUrl();
	
	public ShortUrl findByShortUrl(String shortUrlLink);
	
}
