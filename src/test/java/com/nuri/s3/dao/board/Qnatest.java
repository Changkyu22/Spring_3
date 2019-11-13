package com.nuri.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.nuri.s3.dao.board.QnaDAO;
import com.nuri.s3.model.board.QnaVO;
import com.nuri.s3.util.RowMaker.Pager;

public class Qnatest extends TestAbstractCase {
	
	@Inject
	private QnaDAO qnaDAO;
	
	//@Test
//	public void qnaListTest() throws Exception{
//		List<QnaVO> ar = qnaDAO.qnaList();
//		assertNotEquals(10, ar.size());
//	}
	
	//@Test
	public void QnaDAO() throws Exception{
		assertNotNull(qnaDAO);
	}
	
//	@Test
//	public void qnaInsertTest()throws Exception {
//		for(int i=0; i<110; i++) {
//			QnaVO qnaVO = new QnaVO();
//			qnaVO.setTitle("nuri"+i);
//			qnaVO.setWriter("CK"+i);
//			qnaVO.setContents("nurinuri"+i);
//			qnaDAO.qnaInsert(qnaVO);
//			Thread.sleep(300);
//		}

	}

