package com.nuri.s3.dao.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.nuri.s3.model.board.QnaVO;
import com.nuri.s3.sevice.board.QnaService;
import com.nuri.s3.util.RowMaker.Pager;

public class QnaServiceTest extends TestAbstractCase{
	
	@Inject
	private QnaService qnaService;
	
	@Test
	public void qnaListTest() throws Exception{
		Pager pager = new Pager();
		pager.makePage(77);
		List<QnaVO> ar = qnaService.qnaList(pager);
		//assertNotEquals(0, ar.size());
		assertEquals(1, (int)pager.getStartRow());
		assertEquals(10, (int)pager.getLastRow());
		assertEquals(1, (int)pager.getStartNum());
		assertEquals(5, (int)pager.getLastNum());
		
	}
	
}
