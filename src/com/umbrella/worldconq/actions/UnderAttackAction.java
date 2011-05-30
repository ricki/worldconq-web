package com.umbrella.worldconq.actions;

import com.umbrella.worldconq.domain.Attack;

public class UnderAttackAction extends WorldConqAction {

	private static final long serialVersionUID = -7228418678746042546L;
	private Attack currentAttack;

	public String show() {
		if (!checkLogged() || !checkPlaying())
			return ERROR;
		setCurrentAttack(getApp().getGameManager().getGameEngine().getCurrentAttack());
		return SUCCESS;
	}

	public void setCurrentAttack(Attack currentAttack) {
		this.currentAttack = currentAttack;
	}

	public Attack getCurrentAttack() {
		return currentAttack;
	}

}
