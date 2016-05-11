package com.team.flipagain.domain;

import java.util.ArrayList;



/**
 * Created by Raffaele on 23.03.2016.
 */
public class Bundle {

    private int bundleId;
    private String name;
    private int userId;
    private ArrayList<Card> cardList;
    private int moduleId;

    public Bundle(int bundleId, String name , int userId, int moduleId){
        this.bundleId = bundleId;
        this.name = name;
        this.userId = userId;
        this.cardList = new ArrayList<>();
        this.moduleId = moduleId;
    }

    



    public int getModuleId() {
		return moduleId;
	}





	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}





	public int getBundleId() {
        return bundleId;
    }



    public String getName() {
        return name;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public void setBundleId(int bundleId) {
        this.bundleId = bundleId;
    }





    public void setName(String name) {
        this.name = name;
    }





	public ArrayList<Card> getCardList() {
		return cardList;
	}





	public void setCardList(ArrayList<Card> cardList) {
		this.cardList = cardList;
	}
}
