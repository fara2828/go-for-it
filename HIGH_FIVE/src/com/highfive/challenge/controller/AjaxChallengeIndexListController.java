package com.highfive.challenge.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highfive.challenge.model.service.ChallengeService;
import com.highfive.challenge.model.vo.Challenge;

/**
 * Servlet implementation class AjaxChallengeIndexListController
 */
@WebServlet("/index.ch")
public class AjaxChallengeIndexListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxChallengeIndexListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Challenge> routineList = new ChallengeService().selectRoutineList("루틴만들기");
		ArrayList<Challenge> studyList = new ChallengeService().selectRoutineList("스터디");
		ArrayList<Challenge> foreignList = new ChallengeService().selectRoutineList("외국어");
		ArrayList<Challenge> healthList = new ChallengeService().selectRoutineList("운동");
		ArrayList<Challenge> mentalList = new ChallengeService().selectRoutineList("멘탈케어");
		ArrayList<Challenge> healthCareList = new ChallengeService().selectRoutineList("헬스케어");
		ArrayList<Challenge> hobbyList = new ChallengeService().selectRoutineList("취미");
		ArrayList<Challenge> extraList = new ChallengeService().selectRoutineList("기타");

		ArrayList<ArrayList<Challenge>> list = new ArrayList(new ArrayList());
		
		list.add(routineList);
		list.add(studyList);
		list.add(foreignList);
		list.add(healthList);
		list.add(mentalList);
		list.add(healthCareList);
		list.add(hobbyList);
		list.add(extraList);

		
		response.setContentType("application/json; charset=UTF-8");
		
		//new Gson().toJson(routineList, response.getWriter());
		new Gson().toJson(list, response.getWriter());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
