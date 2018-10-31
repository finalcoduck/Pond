package com.coduck.pond.schedule.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coduck.pond.schedule.service.ScheduleServiceImpl;
import com.coduck.pond.schedule.vo.ScheduleVo;

@Controller
public class ScheduleBasicController {
	@Autowired
	private ScheduleServiceImpl scheduleService;
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletResponse response) {
		return "r"
				+ "edirect:/schedule/info";
	}*/
	
	/*
	 * 	최초에 데이터 받아오기
	 */
	@RequestMapping(value = "/schedule/info", method = RequestMethod.GET)
	public String getDateInfo(Model model, @RequestParam(value="groupNum", defaultValue="30") int groupNum) {
		List<ScheduleVo> list = scheduleService.getDateInfo(groupNum);
		for (ScheduleVo vo : list) {
			Date date = vo.getScheduleEndDate();
			java.sql.Date dd = plus1day(date);
			vo.setScheduleEndDate(dd);
		}
		model.addAttribute("list", list);
		
		return "schedule";
	}
	
	@RequestMapping(value = "/schedule/addCal", method = RequestMethod.GET)
	public String goAddCal() {
		return "addCal";
	}
	
	/*
	 *  그룹 일정 등록
	 */
	@RequestMapping(value = "/schedule/addCal", method = RequestMethod.POST)
	public String addCal(ScheduleVo vo, RedirectAttributes ra) {
		try {
			Date dd = vo.getScheduleEndDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("date:"+dd);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dd);
			cal.add(Calendar.DATE, 1);
			dd = sdf.parse(sdf.format(cal.getTime()));
			java.sql.Date date = new java.sql.Date(dd.getTime());
			vo.setScheduleEndDate(date);
			ra.addAttribute("groupNum", vo.getGroupNum());
			scheduleService.addSchedule(vo);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirec:/";
		}
		return "redirect:/schedule/info";
	}
	
	/*
	 *  해당 년도 / 월별로 데이터 뽑아오기
	 */
	@RequestMapping(value = "/schedule/getInfo", method = RequestMethod.POST)
	@ResponseBody // @@@@@@@@@@@@@@@@@ 추후에 groupNum 처리해주어야함
	public Map<String, Object> getInfo(String year, String month, @RequestParam(value="groupNum", defaultValue="30") String groupNum) {
		List<ScheduleVo> list = scheduleService.getSchedule_month(year, month, groupNum);
		Map<String, Object> json = new HashMap<>();
		List<Map<String, Object>> jsonList = new ArrayList<>();
		
		for (ScheduleVo vo : list) {
			Date from = vo.getScheduleStartDate();
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			String start = transFormat.format(from);
			from = vo.getScheduleEndDate();
			String end = transFormat.format(from);
			Map<String, Object> jsonSub = new HashMap<>();
			
			jsonSub.put("groupNum", vo.getGroupNum());
			jsonSub.put("scheduleContent", vo.getScheduleContent());
			jsonSub.put("scheduleStartDate", start);
			jsonSub.put("scheduleEndDate", end);
			jsonSub.put("scheduleNum", vo.getScheduleNum());
			jsonSub.put("scheduleTitle", vo.getScheduleTitle());
			
			jsonList.add(jsonSub);
		}
		json.put("result_list", jsonList);
		return json;
	}
	
	/*
	 *  해당 날짜 date 형식으로 +1일
	 */
	public java.sql.Date plus1day(Date day) {
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		c.add(Calendar.DATE, 1);
		day = c.getTime();
		java.sql.Date date = new java.sql.Date(day.getTime());
		return date;
	}
}
