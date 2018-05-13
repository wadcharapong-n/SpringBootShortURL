package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.web.ConnectionDB;
import com.web.model.ShortUrl;

@Service("shortUrlService")
public class ShortUrlServiceImpl implements ShortUrlService {

	// create ShortLink
	public void createShortUrl(ShortUrl shortUrl) {
		System.out.println("************ save url *****************");
		ConnectionDB.getConnection().save(shortUrl);
		System.out.println("save url complete");
	}

	// increment link
	public void incrementUrl(String shortUrlLink) {

		// query to search
		Query searchShortUrlQuery = new Query(Criteria.where("shortUrl").is(shortUrlLink));

		// find
		ShortUrl shortUrl = ConnectionDB.getConnection().findOne(searchShortUrlQuery, ShortUrl.class);
		Integer count = Integer.valueOf(shortUrl.getClickCount()) + 1;

		// update
		ConnectionDB.getConnection().updateFirst(searchShortUrlQuery, Update.update("clickCount", count.toString()),
				ShortUrl.class);

	}

	// get all link
	public List<ShortUrl> findAllShortUrl() {
		List<ShortUrl>  shortUrls = new ArrayList<ShortUrl>();
			
		shortUrls = ConnectionDB.getConnection().findAll(ShortUrl.class);
		
		return shortUrls;
	}
	
	// get all link
	public ShortUrl findByShortUrl(String shortUrlLink) {
		
		// query to search
		Query searchShortUrlQuery = new Query(Criteria.where("shortUrl").is(shortUrlLink));
		
		// find
		ShortUrl shortUrl = ConnectionDB.getConnection().findOne(searchShortUrlQuery, ShortUrl.class);
		
		return shortUrl;
	}
	
}
