package Dao;

import entity.Promotion;

public class Promotion_Dao extends BaseDao<Promotion>{

	@Override
	public Class<Promotion> getmodeclass() {
		// TODO Auto-generated method stub
		return Promotion.class;
	}

	@Override
	public String getdatabase() {
		// TODO Auto-generated method stub
		return Promotion.class.getSimpleName();
	}

}
