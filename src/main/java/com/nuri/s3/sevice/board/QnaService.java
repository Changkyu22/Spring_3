package com.nuri.s3.sevice.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nuri.s3.dao.board.QnaDAO;
import com.nuri.s3.model.board.QnaVO;
import com.nuri.s3.util.RowMaker.Pager;

@Service
public class QnaService {
	
	@Inject
	private QnaDAO qnaDAO;
	
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		// DB를 보내기 위해 rownum을 계산
		pager.makeRow();
//		int count = qnaDAO.qnaCount(); --> count라는 변수로 여러번 쓸 때 
		pager.makePage(qnaDAO.qnaCount(pager));
		
		return qnaDAO.qnaList(pager);
	}
	
//	public QnaVO qnaSelect(int num) throws Exception{
//		return qnaDAO.qnaSelect(num);
//	}
	
	public int qnaInsert(QnaVO qnaVO) throws Exception{
		return qnaDAO.qnaInsert(qnaVO);
	}
}
