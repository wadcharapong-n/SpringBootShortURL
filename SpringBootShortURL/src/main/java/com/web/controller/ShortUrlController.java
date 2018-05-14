package com.web.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.common.hash.Hashing;
import com.web.model.ShortUrl;
import com.web.service.ShortUrlService;

@Controller
@SessionAttributes("name")
public class ShortUrlController {

	@Autowired
	ShortUrlService shortUrlService;

	@RequestMapping(value = "/web/shortLink", method = RequestMethod.POST)
	public String shortenUrl(ModelMap model, @RequestParam String url) {
		System.out.println("*********shortLink*********");
		System.out.println(url);	
		boolean foundHttp = url.contains("http://");
		boolean foundHttps = url.contains("https://");
		if(!(foundHttp || foundHttps)) {
			url = "http://"+url;
		}
		
		if (!isUrlValid(url)) {
			model.put("errorMessage", "invalid URL");			
			return "welcome";
		}

		final String link = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
		String shortLink = "http://localhost:8080/" + link;
		//find duplicate
		ShortUrl duplcateLink =  shortUrlService.findByShortUrl(link);
		if(duplcateLink == null) {
			// save DB
			ShortUrl shortUrl = new ShortUrl();
			shortUrl.setClickCount("0");
			shortUrl.setOrginalUrl(url);
			shortUrl.setShortUrl(link);
			shortUrlService.createShortUrl(shortUrl);
			
		}
		System.out.println("*********shortLink after service*********");
		model.put("url", url);
		model.put("shortLink", shortLink);
		return "welcome";
	}

	private boolean isUrlValid(String url) {
		boolean valid = true;
		try {
				new URL(url);
		} catch (MalformedURLException e) {
			valid = false;
		}
		System.out.println(valid);
		return valid;
	}

	@RequestMapping(value = "/{url}", method = RequestMethod.GET)
	public void redirectToUrl(@PathVariable String url, HttpServletResponse resp) {
		System.out.println("***********************" + url + "**************");
		ShortUrl shortUrlDB = shortUrlService.findByShortUrl(url);
		try {
			if (shortUrlDB != null) {
				shortUrlService.incrementUrl(url);
				resp.addHeader("Location", shortUrlDB.getOrginalUrl());
				resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			} else {		
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
