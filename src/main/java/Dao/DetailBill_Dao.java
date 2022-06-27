package Dao;

import entity.DetailBill;

public class DetailBill_Dao extends BaseDao<DetailBill>{

	@Override
	public Class<DetailBill> getmodeclass() {
		return DetailBill.class;
	}

	@Override
	public String getdatabase() {
		return DetailBill.class.getSimpleName();
	}

}
