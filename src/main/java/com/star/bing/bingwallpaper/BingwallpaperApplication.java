package com.star.bing.bingwallpaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BingwallpaperApplication {

	public static void main(String[] args) {
		SpringApplication.run(BingwallpaperApplication.class, args);
	}

}
