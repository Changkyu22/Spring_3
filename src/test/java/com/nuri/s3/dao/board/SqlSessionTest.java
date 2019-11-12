package com.nuri.s3.dao.board;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SqlSessionTest extends TestAbstractCase {

	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void sqlTest() {
		assertNotNull(sqlSession);
	}

}
