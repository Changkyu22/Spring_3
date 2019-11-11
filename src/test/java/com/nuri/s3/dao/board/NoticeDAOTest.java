package com.nuri.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.nuri.s3.TestAbstractCase;
import com.nuri.s3.model.board.NoticeVO;

public class NoticeDAOTest extends TestAbstractCase {

	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void noticeCountTest() throws Exception{
		int count = noticeDAO.noticeCount();
		assertEquals(111, count);
	}
	
	//@Test
	public void checkDAO() throws Exception{
	 assertNotNull(noticeDAO);
	}
	
	//@Test
	public void noticeInsert() throws Exception{
		for(int i=0; i<120; i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("nt"+i);
			noticeVO.setWriter("ck"+i);
			noticeVO.setContents("contents"+i);
			int result = noticeDAO.noticeInsert(noticeVO);
		}
//		assertEquals(1, result);
	}
	//@Test
	public void noticeDelte() throws Exception{
		int result = noticeDAO.noticeDelete(2);
		assertEquals(1, result);
	}
	
	//@Test
	public void noticeSelect() throws Exception{
		NoticeVO noticeVO = noticeDAO.noticeSelect(1);
		assertNotNull(noticeVO);
	}
	
	//@Test
	public void noticeList() throws Exception{
		List<NoticeVO> list = noticeDAO.noticeList();
		assertNotNull(list.size()); 
	}
	
	//@Test
	public void noticeUpdate() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(4);
		noticeVO.setTitle("abcde");
		noticeVO.setContents("qqqqqqq");
		int result = noticeDAO.noticeUpdate(noticeVO);
		assertEquals(1, result);
	}
	

}
