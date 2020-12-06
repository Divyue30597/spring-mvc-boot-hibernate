package com.practice.springdemo;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;	

	public CricketCoach() {
		super();
		System.out.println("CricketCoach: inside no argument constructor");
	}
	//Setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for a day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
