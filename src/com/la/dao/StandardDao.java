package com.la.dao;

import java.sql.SQLException;
import java.util.List;

import com.la.model.Standard;



public interface StandardDao {
	
	void insertStandard(Standard standard) throws SQLException;

	Standard selectStandard(int stdId);
	
	List<Standard> selectAllStandards();

	void deleteStandard(int stdId) throws SQLException;

	void updateStandard(Standard standard) throws SQLException;

}
