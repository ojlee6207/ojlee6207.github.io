//package com.kh.opendata.service;
//
//import java.util.ArrayList;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.kh.opendata.model.dao.AirDao;
//import com.kh.opendata.model.vo.AirVO;
//
//@Service
//public class AirPollutionService {
//	
//	@Autowired
//	private SqlSessionTemplate sqlSession;
//	
//	@Autowired
//	private AirDao airDao;
//
//	public ArrayList<AirVO> selectAirPollution(String location) {
//		return airDao.selectAirPollution(sqlSession, location);
//	}
//
//}
