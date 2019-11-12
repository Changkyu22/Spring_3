package com.nuri.s3;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.javassist.bytecode.Mnemonic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nuri.s3.model.board.NoticeVO;
import com.nuri.s3.service.board.NoticeService;
import com.nuri.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	// list : /notice/noticeList GET
	@RequestMapping(value = "noticeList", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeList(Pager pager)throws Exception {
		List<NoticeVO> ar = noticeService.noticeList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("notice/noticeList");
		return mv;
		
	}
	
	@RequestMapping(value = "noticeSelect")
	public void noticeSelect(int num, Model model)throws Exception {
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("dto", noticeVO);
	}
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public void noticeWrite()throws Exception {
		
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeVO noticeVO) throws Exception{
		int result = noticeService.noticeInsert(noticeVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", noticeVO);
		String msg = "Fail";
		if(result>0) {
			msg = "Success";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public void noticeUpdate(int num, Model model) throws Exception{
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("dto", noticeVO);
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO noticeVO) throws Exception{
		int result = noticeService.noticeUpdate(noticeVO);
		ModelAndView mv = new ModelAndView();
		String msg = "Fail";
		if(result>0) {
			msg = "Success";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public ModelAndView noticeDelete(int num) throws Exception{
		int result = noticeService.noticeDelete(num);
		ModelAndView mv = new ModelAndView();
		String msg = "Fail";
		if(result>0) {
			msg = "Success";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		return mv;
	}
	

	
	// view : /WEB-INF/views/notice/noticeList.jsp
	// Select
}
