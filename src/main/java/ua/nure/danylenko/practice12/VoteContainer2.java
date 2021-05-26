package ua.nure.danylenko.practice12;

import java.util.Arrays;
import java.util.TreeSet;

public class VoteContainer2 {
	private String sport;
	
	private Integer count;
	private TreeSet<String>players;
	
	public VoteContainer2(String sportType, Integer num, TreeSet<String>set) {
		sport=sportType;
		count=num;
		players=set;
	}
	
	@Override
	public String toString() {

		return players.toString();
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public TreeSet<String> getPlayers() {
		return players;
	}
	public void setPlayers(TreeSet<String> players) {
		this.players = players;
	}

}
