package com.application.ParkHanCoffee.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.ParkHanCoffee.coupon.dto.CouponDTO;
import com.application.ParkHanCoffee.product.dto.ProductDTO;

@Repository
public class ShopDAOImpl implements ShopDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> getProductList() throws Exception {
		return sqlSession.selectList("shop.getProductList");
	}

	@Override
	public ProductDTO getProductInfo(long coffeeId) throws Exception {
		return sqlSession.selectOne("shop.getProductInfo", coffeeId);
	}

	@Override
	public String checkCouponNumber(String couponNumber) throws Exception {
		return sqlSession.selectOne("shop.checkCouponNumber", couponNumber);
	}

	@Override
	public void insertSalesPrice(int price) throws Exception {
		sqlSession.insert("shop.insertSalesPrice", price);
		
	}

}
