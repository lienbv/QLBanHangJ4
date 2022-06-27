package Dao;

import entity.Cart;

public class Cart_Dao extends BaseDao<Cart>{

	@Override
	public Class<Cart> getmodeclass() {

		return Cart.class;
	}

	@Override
	public String getdatabase() {
		// TODO Auto-generated method stub
		return Cart.class.getSimpleName();
	}

}
