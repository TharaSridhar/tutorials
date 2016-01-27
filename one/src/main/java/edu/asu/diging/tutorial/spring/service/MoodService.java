package edu.asu.diging.tutorial.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import edu.asu.diging.tutorial.spring.domain.Mood;

@Service
public class MoodService implements IMoodService {
	
	private List<String> moods;
	private Random random;
	private List<String> explanations;
	
	@PostConstruct
	public void init() {
		moods = new ArrayList<String>();
		moods.add("happy");
		moods.add("sad");
		moods.add("frustrated");
		moods.add("scared");
		moods.add("excited");
		
		explanations = new ArrayList<String>();
		explanations.add("I am hungry.");
		explanations.add("I won.");
		explanations.add("I think I saw something.");
		explanations.add("I am going out.");
		explanations.add("I lost my bike.");
		
		random = new Random(); 
	}

	/* (non-Javadoc)
	 * @see edu.asu.diging.tutorial.spring.one.service.IMoodService#getCurrentMood()
	 */
	public Mood getCurrentMood() {
		int randomInt = random.nextInt(moods.size());
		return new Mood(moods.get(randomInt));
    }
	

	public String getExplanation() {
		int randomInt = random.nextInt(explanations.size());
		return explanations.get(randomInt);
	}
}