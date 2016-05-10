package com.team.flipagain.domain;



/**
 * Created by Raffaele on 23.03.2016.
 */
public class Card {
    // ATTRIBUT
    private int cardId;
    private int userId;
    private String question;
    private String answer;
    private int rating;
    private int bundleId;

    /**
     *
     * @param cardId
     * @param question
     * @param answer
     * @param rating
     */
    public Card(int cardId, int userId, String question, String answer, int bundleId){
        this.cardId = cardId;
        this.userId = userId;
        this.question = question;
        this.answer = answer;
        this.bundleId = bundleId;
    }

    public int getBundleId() {
		return bundleId;
	}

	public void setBundleId(int bundleId) {
		this.bundleId = bundleId;
	}

	//GETTER SETTER
    public String getAnswer() {
        return answer;
    }
    public String getQuestion() {
        return question;
    }
    public int getCardId() {
        return cardId;
    }
    public int getRating() {
        return rating;
    }
}
