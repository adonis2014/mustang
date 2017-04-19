package com.dimogo.open.myjobs.manager.admin.controller;

import com.dimogo.open.myjobs.manager.admin.service.MyJobsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ethan Xiao on 2017/4/19.
 */
@Controller
public class Master {

	private MyJobsService service;

	@RequestMapping(value = "/master", method = RequestMethod.GET)
	public String executors() {
		return "master";
	}

	public void setService(MyJobsService service) {
		this.service = service;
	}
}
