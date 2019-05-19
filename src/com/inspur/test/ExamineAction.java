package com.inspur.test;/*package com.besto.tms.action;

import com.besto.tms.manage.CategoryService;
import com.besto.tms.manage.ChannelServices;
import com.besto.tms.manage.CpInfoServices;
import com.besto.tms.manage.ExamineProcessService;
import com.besto.tms.manage.ExamineService;
import com.besto.tms.manage.LogInfoServices;
import com.besto.tms.manage.ProgramServices;
import com.besto.tms.manage.RoleService;
import com.besto.tms.manage.ScheduleService;
import com.besto.tms.manage.ScheduleinfoService;
import com.besto.tms.manage.SeriesService;
import com.besto.tms.manage.UserService;
import com.besto.tms.po.Category;
import com.besto.tms.po.CpInfo;
import com.besto.tms.po.PictureProgramMapping;
import com.besto.tms.vo.CategoryVO;
import com.besto.tms.vo.ChannelPic;
import com.besto.tms.vo.ChannelVO;
import com.besto.tms.vo.ExamineProcessVO;
import com.besto.tms.vo.ExamineVO;
import com.besto.tms.vo.MovieVO;
import com.besto.tms.vo.ProgramVO;
import com.besto.tms.vo.ScheduleVO;
import com.besto.tms.vo.ScheduleinfoVO;
import com.besto.tms.vo.UserVO;
import com.besto.util.CommExpand;
import com.besto.util.EscapeWildcard;
import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("examineAction")
@Scope("prototype")
@Lazy
public class ExamineAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ExamineAction.class);

	private ExamineVO examineVO;

	private ChannelVO channelVO;

	public ProgramVO programVO;

	private CategoryVO categoryVO;

	private ScheduleinfoVO scheduleinfo;

	private ScheduleVO schedule;

	@Autowired
	private ExamineService examineServ;

	@Autowired
	private ChannelServices channelServices;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProgramServices programServices;

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private SeriesService seriesService;

	@Autowired
	LogInfoServices logInfoServices;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	private ExamineProcessService examineProcessServ;

	private List<ChannelPic> channelPicList;

	private List<PictureProgramMapping> programPicList;

	private String doFlag;

	private List<MovieVO> movieList;

	private String category_id;

	private String actointype;

	private UserVO user;

	private List<CpInfo> cspids;

	private String totaltime;

	private String assignflag = "";

	private String backflag = "";
	private String taskdistributions;
	private String validationIds;
	private String strIds_taskdistribution;
	@Autowired
	CpInfoServices cpInfoServices;
	@Autowired
	ScheduleinfoService scheduleinfoService;

	public String getStrIds_taskdistribution() {
		return strIds_taskdistribution;
	}

	public void setStrIds_taskdistribution(String strIds_taskdistribution) {
		strIds_taskdistribution = strIds_taskdistribution;
	}

	public String getValidationIds() {
		return validationIds;
	}

	public void setValidationIds(String validationIds) {
		validationIds = validationIds;
	}

	public String getTaskdistributions() {
		return taskdistributions;
	}

	public void setTaskdistributions(String taskdistributions) {
		taskdistributions = taskdistributions;
	}

	public String getAssignflag() {
		return assignflag;
	}

	public void setAssignflag(String assignflag) {
		assignflag = assignflag;
	}

	public String getBackflag() {
		return backflag;
	}

	public void setBackflag(String backflag) {
		backflag = backflag;
	}

	public String getTotaltime() {
		return totaltime;
	}

	public void setTotaltime(String totaltime) {
		totaltime = totaltime;
	}

	public List<CpInfo> getCspids() {
		return cspids;
	}

	public void setCspids(List<CpInfo> cspids) {
		cspids = cspids;
	}

	public String searchExamine() {
		ExamineProcessVO examineProcessVO = examineProcessServ
				.findExamineProcess();

		if (examineVO == null) {
			examineVO = new ExamineVO();
		}

		Map<String, Object> session = ActionContext.getContext().getSession();
		String providerid = "";
		String userid = "";
		String username = "";
		String rolebtns = "";
		if (session != null) {
			providerid = (String) session.get("provider");
			userid = (String) session.get("admin");
			username = (String) session.get("adminname");
			rolebtns = (String) session.get("rolebtns");
		}

		examineVO = ((ExamineVO) getValueForKV(examineVO));

		if (examineProcessVO != null) {
			examineVO.setLevel(examineProcessVO.getExamineprocess());
			examineVO.setHandling_userid(userid);
			examineVO.setHandling_username(username);

			if (examineProcessVO.isAssigned1()) {
				examineVO.setAssigned1("1");
			} else {
				examineVO.setAssigned1("0");
			}

			if (examineProcessVO.isAssigned2()) {
				examineVO.setAssigned2("1");
			} else {
				examineVO.setAssigned2("0");
			}

			if (examineProcessVO.isAssigned3()) {
				examineVO.setAssigned3("1");
			} else {
				examineVO.setAssigned3("0");
			}

			if (examineProcessVO.isAssigned4()) {
				examineVO.setAssigned4("1");
			} else {
				examineVO.setAssigned4("0");
			}

			if (examineProcessVO.isBack1()) {
				examineVO.setBack1("1");
			} else {
				examineVO.setBack1("0");
			}

			if (examineProcessVO.isBack2()) {
				examineVO.setBack2("1");
			} else {
				examineVO.setBack2("0");
			}

			if (examineProcessVO.isBack3()) {
				examineVO.setBack3("1");
			} else {
				examineVO.setBack3("0");
			}

			if (examineProcessVO.isBack4()) {
				examineVO.setBack4("1");
			} else {
				examineVO.setBack4("0");
			}

			if ((rolebtns.indexOf("examinemanage_frist") != -1)
					&& (examineProcessVO.isAssigned1())) {
				assignflag = "1";
			}

			if (rolebtns.indexOf("examinemanage_second") != -1) {
				if (examineProcessVO.isAssigned2()) {
					assignflag = "1";
				}
				if (examineProcessVO.isBack1()) {
					backflag = "1";
				}
			}

			if (rolebtns.indexOf("examinemanage_three") != -1) {
				if (examineProcessVO.isAssigned3()) {
					assignflag = "1";
				}
				if (examineProcessVO.isBack2()) {
					backflag = "1";
				}
			}
			if (rolebtns.indexOf("examinemanage_four") != -1) {
				if (examineProcessVO.isAssigned4()) {
					assignflag = "1";
				}
				if (examineProcessVO.isBack3()) {
					backflag = "1";
				}
			}
			if ((rolebtns.indexOf("examinemanage_five") != -1)
					&& (examineProcessVO.isBack4())) {
				backflag = "1";
			}
		}

		user = userService.selectByPrimaryKey(userid);
		String treerole = roleService.searchByRoleCategoryCode(user
				.getRoleid());
		String[] treerole_arr = treerole.split(" ");
		HashSet<String> treeset = new HashSet();
		for (int ri = 0; ri < treerole_arr.length; ri++) {
			treeset.add(treerole_arr[ri]);
		}

		List<Category> catelist = categoryService
				.searchAllChild(category_id);
		String categorycode_tmp = "";
		if (!catelist.isEmpty()) {
			for (int i = 0; i < catelist.size(); i++) {
				if ("4".equals(actointype)) {
					categorycode_tmp = categorycode_tmp + "'"
							+ ((Category) catelist.get(i)).getId() + "'" + " ";
				} else if (treeset.contains(((Category) catelist.get(i))
						.getId())) {
					categorycode_tmp = categorycode_tmp + "'"
							+ ((Category) catelist.get(i)).getId() + "'" + " ";
				}
			}

			categorycode_tmp = categorycode_tmp.trim();
			categorycode_tmp = categorycode_tmp.replace(" ", ",");
		}
		examineVO.setCategory_code(categorycode_tmp);

		String ename = examineVO.getUsername();
		String etitle = examineVO.getTitle();
		examineVO.setUsername(EscapeWildcard.escapeWildcard(ename, '|'));
		examineVO.setTitle(EscapeWildcard.escapeWildcard(etitle, '|'));

		examineVO = ((ExamineVO) initPageValue(examineVO,
				ExamineVO.class));

		examineVO.setProviderid(providerid);
		if (!providerid.equals("MAS")) {
			examineVO.setCspids(providerid);
		}

		examineVO.setTaskList(getExamineRole());

		examineVO.setCategory_id(category_id);
		examineVO.setActiontype(actointype);
		int i;
		if ((examineVO.getCategory_id() != null)
				&& (examineVO.getActiontype() != null)) {
			String[] rolebtns_arr = rolebtns.split(",");
			String examinetype_str = "";

			HashSet<String> set = new HashSet();
			if (rolebtns_arr != null) {
				for (i = 0; i < rolebtns_arr.length; i++) {
					String buttoncode = rolebtns_arr[i];
					if ("1".equals(actointype)) {
						if ("programsingle_examine_ma".equals(buttoncode)) {
							set.add("content");
						}
						if ("programsingle_examine_repair".equals(buttoncode)) {
							set.add("work");
						}
					} else if ("2".equals(actointype)) {
						if ("channel_examine_ma".equals(buttoncode)) {
							set.add("content");
						}
						if ("channel_examine_repair".equals(buttoncode)) {
							set.add("work");
						}
					} else if ("3".equals(actointype)) {
						if ("schedule_examine_ma".equals(buttoncode)) {
							set.add("content");
						}
						if ("schedule_examine_repair".equals(buttoncode)) {
							set.add("work");
						}
					} else if ("7".equals(actointype)) {
						if ("radioschedule_examine_ma".equals(buttoncode)) {
							set.add("content");
						}
						if ("radioschedule_examine_repair".equals(buttoncode)) {
							set.add("work");
						}
					} else if ("4".equals(actointype)) {
						set.add("work");
						set.add("content");
					} else if ("6".equals(actointype)) {
						if ("radiochannel_examine_ma".equals(buttoncode)) {
							set.add("content");
						}
						if ("radiochannel_examine_repair".equals(buttoncode)) {
							set.add("work");
						}
					}
				}
			}
			if (set != null) {
				if (set.size() == 1) {
					if (set.contains("content")) {
						examinetype_str = "content";
					} else if (set.contains("work")) {
						examinetype_str = "work";
					}
				} else if (set.size() > 1) {
					examinetype_str = "all";
				} else {
					examinetype_str = "not";
				}
			}

			examineVO.setDataexaminetype(examinetype_str);
		}
		examineVO.setUserid(userid);

		count = examineServ.getTotalRows(examineVO);
		logger.debug("记录条数 count=" + count);

		examineVO = ((ExamineVO) pageCalculate(examineVO));

		List<ExamineVO> list = examineServ.search(examineVO);

		totaltime = examineServ.getTotalTime(examineVO);

		for (int i = 0; i < list.size(); i++) {
			((ExamineVO) list.get(i)).setSequenceNumber(i + 1
					+ examineVO.getPageid()
					* examineVO.getPagecount()
					- examineVO.getPagecount());
		}

		logger.debug("分页结果:" + list.size());

		examineVO.setPages(pages);
		examineVO.setCount(count);

		if (providerid.equals("MAS")) {
			cspids = cpInfoServices.getByCspid();
			CpInfo cp = new CpInfo();
			cp.setCpname("全部");
			cp.setProvider(providerid);
			cspids.add(0, cp);
		} else {
			cspids = new ArrayList();
			List<CpInfo> listCP = cpInfoServices.getByCspid();
			if ((listCP != null) && (listCP.size() > 0)) {
				for (CpInfo cp : listCP) {
					if (cp.getProvider().equals(providerid)) {
						cspids.add(cp);
					}
				}
			}
		}
		pageBindValue("list", list);
		examineVO.setUsername(ename);
		examineVO.setTitle(etitle);

		examineVO = ((ExamineVO) getValueForKV(examineVO));

		setValueForKV("examine_serch", examineVO);

		return "examineList";
	}

	public String doThrough() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = "";
		String userid = "";
		if (session != null) {
			username = (String) session.get("adminname");
			userid = (String) session.get("admin");

			examineVO.setHandling_userid(userid);
			examineVO.setHandling_username(username);
		}
		String result = examineServ.doExamineThrough(examineVO);
		String updateData = examineVO.getUpdateData();
		String[] dataRow = updateData.split("#");
		if (dataRow != null) {
			for (int i = 0; i < dataRow.length; i++) {
				String[] data = dataRow[i].split("\\|");
				if ((data != null) && (data.length > 4)) {
					String loginfoclass = "";

					if (("1".equals(data[1])) || ("2".equals(data[1]))
							|| ("9".equals(data[1]))) {
						loginfoclass = "点播";
					} else if ("0".equals(data[1])) {
						loginfoclass = "直播";
					} else if ("3".equals(data[1])) {
						loginfoclass = "广播";
					} else if (("4".equals(data[1])) || ("5".equals(data[1]))
							|| ("6".equals(data[1])) || ("7".equals(data[1]))) {
						loginfoclass = "分类";
					} else if ("8".equals(data[1])) {
						loginfoclass = "节目单";
					}

					if (data[4].equals("0")) {
						logInfoServices.logRecordAdd(username, "通过提交上线",
								"(" + data[3] + ")" + "信息通过提交上线申请", CommExpand
										.getIpAddr(ServletActionContext
												.getRequest()), "审核管理",
								loginfoclass, "");
					} else if (data[4].equals("1")) {
						logInfoServices.logRecordAdd(username, "通过审核下线",
								"(" + data[3] + ")" + "信息通过提交下线申请", CommExpand
										.getIpAddr(ServletActionContext
												.getRequest()), "审核管理",
								loginfoclass, "");
					} else if (data[4].equals("2")) {
						logInfoServices.logRecordAdd(username, "通过审核下发删除",
								"(" + data[3] + ")" + "信息通过提交下发删除申请",
								CommExpand.getIpAddr(ServletActionContext
										.getRequest()), "审核管理", loginfoclass,
								"");
					} else if (data[4].equals("3")) {
						logInfoServices.logRecordAdd(username, "通过审核本地删除",
								"(" + data[3] + ")" + "信息通过提交本地删除申请",
								CommExpand.getIpAddr(ServletActionContext
										.getRequest()), "审核管理", loginfoclass,
								"");
					} else if (data[4].equals("4")) {
						logInfoServices.logRecordAdd(username, "通过内容审核",
								"(" + data[3] + ")" + "信息通过提交内容申请", CommExpand
										.getIpAddr(ServletActionContext
												.getRequest()), "审核管理",
								loginfoclass, "");
					}
				}
			}
		}

		examineVO.setHandling_userid(null);
		examineVO.setHandling_username(null);
		if (result.equals("ok")) {
			doFlag = "1";
		} else {
			doFlag = "2";
			addActionError("save 错误详情查询日志");
		}
		return searchExamine();
	}

	public String doTurndown() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = "";
		String userid = "";
		if (session != null) {
			username = (String) session.get("adminname");
			userid = (String) session.get("admin");
			examineVO.setHandling_userid(userid);
			examineVO.setHandling_username(username);
		}
		String result = examineServ.doExamineTurndown(examineVO);
		String updateData = examineVO.getUpdateData();
		String[] dataRow = updateData.split("#");
		if (dataRow != null) {
			for (int i = 0; i < dataRow.length; i++) {
				String[] data = dataRow[i].split("\\|");
				if ((data != null) && (data.length > 4)) {
					String loginfoclass = "";

					if (("1".equals(data[1])) || ("2".equals(data[1]))
							|| ("9".equals(data[1]))) {
						loginfoclass = "点播";
					} else if ("0".equals(data[1])) {
						loginfoclass = "直播";
					} else if ("3".equals(data[1])) {
						loginfoclass = "广播";
					} else if (("4".equals(data[1])) || ("5".equals(data[1]))
							|| ("6".equals(data[1])) || ("7".equals(data[1]))) {
						loginfoclass = "分类";
					} else if ("8".equals(data[1])) {
						loginfoclass = "节目单";
					}

					if (data[4].equals("0")) {
						logInfoServices.logRecordAdd(username, "不通过提交上线",
								"(" + data[3] + ")" + "信息不通过提交上线申请", CommExpand
										.getIpAddr(ServletActionContext
												.getRequest()), "审核管理",
								loginfoclass, "");
					} else if (data[4].equals("1")) {
						logInfoServices.logRecordAdd(username, "不通过审核下线",
								"(" + data[3] + ")" + "信息不通过提交下线申请", CommExpand
										.getIpAddr(ServletActionContext
												.getRequest()), "审核管理",
								loginfoclass, "");
					} else if (data[4].equals("2")) {
						logInfoServices.logRecordAdd(username,
								"不通过审核下发删除", "(" + data[3] + ")"
										+ "信息不通过提交下发删除申请", CommExpand
										.getIpAddr(ServletActionContext
												.getRequest()), "审核管理",
								loginfoclass, "");
					} else if (data[4].equals("3")) {
						logInfoServices.logRecordAdd(username,
								"不通过审核本地删除", "(" + data[3] + ")"
										+ "信息不通过提交本地删除申请", CommExpand
										.getIpAddr(ServletActionContext
												.getRequest()), "审核管理", "点播",
								"");
					} else if (data[4].equals("4")) {
						logInfoServices.logRecordAdd(username, "不通过内容审核",
								"(" + data[3] + ")" + "信息不通过提交内容申请", CommExpand
										.getIpAddr(ServletActionContext
												.getRequest()), "审核管理",
								loginfoclass, "");
					}
				}
			}
		}
		examineVO.setHandling_userid(null);
		examineVO.setHandling_username(null);
		if (result.equals("ok")) {
			doFlag = "1";
		} else {
			doFlag = "2";
			addActionError("save 错误详情查询日志");
		}

		return searchExamine();
	}

	public String preview() throws Exception {
		String returnValue = "";

		if (("0".equals(examineVO.getExaminecorrelatetype()))
				|| ("3".equals(examineVO.getExaminecorrelatetype()))) {
			channelVO = channelServices
					.searchChannelInfoById(examineVO
							.getExaminecorrelateid());
			channelPicList = channelServices
					.searchPicList(channelVO.getId());
			if ("0".equals(examineVO.getExaminecorrelatetype())) {
				returnValue = "channel";
			} else {
				returnValue = "channelVideo";
			}
		} else if (("1".equals(examineVO.getExaminecorrelatetype()))
				|| ("2".equals(examineVO.getExaminecorrelatetype()))) {
			programVO = programServices
					.searchByProgramId(examineVO.getExaminecorrelateid());
			programPicList = programServices
					.searchPicList(programVO.getId());
			movieList = programServices
					.searchMovieList(programVO.getId());
			if ((movieList != null) && (movieList.size() > 0)) {
				programVO.setVideoFilePath(((MovieVO) movieList
						.get(0)).getFileURL());
			}
			if ("2".equals(examineVO.getExaminecorrelatetype())) {
				returnValue = "program";
			} else {
				returnValue = "program";
			}
		} else if (("4".equals(examineVO.getExaminecorrelatetype()))
				|| ("5".equals(examineVO.getExaminecorrelatetype()))
				|| ("6".equals(examineVO.getExaminecorrelatetype()))
				|| ("7".equals(examineVO.getExaminecorrelatetype()))) {
			categoryVO = categoryService.searchVoById(examineVO
					.getExaminecorrelateid());
			returnValue = "category";
		} else if ("8".equals(examineVO.getExaminecorrelatetype())) {
			scheduleinfo = ((ScheduleinfoVO) initPageValue(
					scheduleinfo, ScheduleinfoVO.class));
			if ((examineVO.getExaminecorrelateid() != null)
					&& (!examineVO.getExaminecorrelateid().equals(""))) {
				scheduleinfo.setScheduleid(examineVO
						.getExaminecorrelateid());
			}

			count = scheduleinfoService
					.getTotalRows(scheduleinfo);
			logger.debug("记录条数 count=" + count);

			scheduleinfo = ((ScheduleinfoVO) pageCalculate(scheduleinfo));

			List<ScheduleinfoVO> list = scheduleinfoService
					.searchPage(scheduleinfo);
			if ((list == null) || (list.size() == 0)) {
				addActionError("没有查询到您想要的数据");
			}
			logger.debug("分页结果:" + list.size());

			scheduleinfo.setPages(pages);
			scheduleinfo.setCount(count);

			pageBindValue("list", list);

			returnValue = "examineSchedule";
		} else if ("9".equals(examineVO.getExaminecorrelatetype())) {
			programVO = seriesService.searchById(
					examineVO.getExaminecorrelateid(), true);
			movieList = seriesService.searchMovieList(examineVO
					.getExaminecorrelateid());
			returnValue = "series";
		}
		return returnValue;
	}

	public String doAssign() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = "";
		String userid = "";
		String loginfoclass = "";
		String updateData = examineVO.getUpdateData();
		String ids = "";
		if (session != null) {
			username = (String) session.get("adminname");
			userid = (String) session.get("admin");

			examineVO.setHandling_userid(userid);
			examineVO.setHandling_username(username);
			String[] dataRow = updateData.split("#");
			if (dataRow != null) {
				for (int i = 0; i < dataRow.length; i++) {
					String[] data = dataRow[i].split("\\|");

					if (("1".equals(data[1])) || ("2".equals(data[1]))
							|| ("9".equals(data[1]))) {
						loginfoclass = "点播";
					} else if ("0".equals(data[1])) {
						loginfoclass = "直播";
					} else if ("3".equals(data[1])) {
						loginfoclass = "广播";
					} else if (("4".equals(data[1])) || ("5".equals(data[1]))
							|| ("6".equals(data[1])) || ("7".equals(data[1]))) {
						loginfoclass = "分类";
					} else if ("8".equals(data[1])) {
						loginfoclass = "节目单";
					}

					ids = ids + data[0] + ",";
					examineVO.setExamineuserid(data[5]);
					examineVO.setExamineusername(data[6]);
				}
			}
		}

		String result = examineServ.doAssign(examineVO);

		logInfoServices.logRecordAdd(username, "审核指派", "(" + username
				+ ")" + "审核指派给" + "(" + examineVO.getExamineusername()
				+ ")ma_examine 表主键：" + ids,
				CommExpand.getIpAddr(ServletActionContext.getRequest()),
				"审核管理", loginfoclass, "");

		examineVO.setUsername(null);
		if (result.equals("ok")) {
			doFlag = "1";
		} else {
			doFlag = "2";
			addActionError("save 错误详情查询日志");
		}

		return searchExamine();
	}

	public String backAssign() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = "";
		String userid = "";
		String loginfoclass = "";
		if (session != null) {
			username = (String) session.get("adminname");
			userid = (String) session.get("admin");

			examineVO.setHandling_userid(userid);
			examineVO.setHandling_username(username);
		}
		String result = examineServ.backAssign(examineVO);

		String updateData = examineVO.getUpdateData();

		examineVO.setUsername(null);

		String[] dataRow = updateData.split("#");
		if (dataRow != null) {
			for (int i = 0; i < dataRow.length; i++) {
				String[] data = dataRow[i].split("\\|");

				if (("1".equals(data[1])) || ("2".equals(data[1]))
						|| ("9".equals(data[1]))) {
					loginfoclass = "点播";
				} else if ("0".equals(data[1])) {
					loginfoclass = "直播";
				} else if ("3".equals(data[1])) {
					loginfoclass = "广播";
				} else if (("4".equals(data[1])) || ("5".equals(data[1]))
						|| ("6".equals(data[1])) || ("7".equals(data[1]))) {
					loginfoclass = "分类";
				} else if ("8".equals(data[1])) {
					loginfoclass = "节目单";
				}

				logInfoServices
						.logRecordAdd(username, "审核指派退回", "(" + data[0] + ")"
								+ "审核指派退回", CommExpand
								.getIpAddr(ServletActionContext.getRequest()),
								"审核管理", loginfoclass, "");
			}
		}

		if (result.equals("ok")) {
			doFlag = "1";
		} else {
			doFlag = "2";
			addActionError("save 错误详情查询日志");
		}

		return searchExamine();
	}

	public ExamineVO getExamineVO() {
		return examineVO;
	}

	public void setExamineVO(ExamineVO examineVO) {
		examineVO = examineVO;
	}

	private List<String> getExamineRole() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		List<String> list = new ArrayList();

		if (session != null) {
			String codes = (String) session.get("rolebtns");
			if ((codes.indexOf("examinemanage_frist") != -1)
					&& (Integer.valueOf(examineVO.getLevel()).intValue() >= 1)) {
				list.add("1");
			}
			if ((codes.indexOf("examinemanage_second") != -1)
					&& (Integer.valueOf(examineVO.getLevel()).intValue() >= 2)) {
				list.add("2");
			}
			if ((codes.indexOf("examinemanage_three") != -1)
					&& (Integer.valueOf(examineVO.getLevel()).intValue() >= 3)) {
				list.add("3");
			}
			if ((codes.indexOf("examinemanage_four") != -1)
					&& (Integer.valueOf(examineVO.getLevel()).intValue() >= 4)) {
				list.add("4");
			}
			if ((codes.indexOf("examinemanage_five") != -1)
					&& (Integer.valueOf(examineVO.getLevel()).intValue() >= 5)) {
				list.add("5");
			}
		}
		if (list.size() == 0) {
			list.add("0");
		}
		return list;
	}

	public String gettaskdistributionToRole() {
		String returncode = "0";
		if ((taskdistributions != null)
				&& (!"".equals(taskdistributions))) {
			String[] array_str = taskdistributions.split(",");

			Map<String, Object> session = ActionContext.getContext()
					.getSession();

			if (session != null) {
				String codes = (String) session.get("rolebtns");

				for (int i = 0; i < array_str.length; i++) {
					if ((array_str[i].equals("1"))
							&& (codes.indexOf("examinemanage_frist") == -1)) {
						returncode = "n1";
						break;
					}

					if ((array_str[i].equals("2"))
							&& (codes.indexOf("examinemanage_second") == -1)) {
						returncode = "n2";
					}

					if ((array_str[i].equals("3"))
							&& (codes.indexOf("examinemanage_three") == -1)) {
						returncode = "n3";
						break;
					}

					if ((array_str[i].equals("4"))
							&& (codes.indexOf("examinemanage_four") == -1)) {
						returncode = "n4";
						break;
					}

					if ((array_str[i].equals("5"))
							&& (codes.indexOf("examinemanage_five") == -1)) {
						returncode = "n5";
						break;
					}
				}
			}
		} else {
			returncode = "nx";
		}
		setResult(returncode);
		return "success";
	}

	public String getValidationAssign() {
		String returncode = "";
		if ((validationIds != null) && (!"".equals(validationIds))
				&& (strIds_taskdistribution != null)
				&& (!"".equals(strIds_taskdistribution))) {
			String[] array_str = validationIds.split(",");
			String[] taskdistribution_str = strIds_taskdistribution
					.split(",");
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			if (session != null) {
				ExamineProcessVO examineProcessVO = examineProcessServ
						.findExamineProcess();

				for (int i = 0; i < array_str.length; i++) {
					if (!"1".equals(taskdistribution_str[i])) {
						if ((("2".equals(taskdistribution_str[i])) && (examineProcessVO
								.isAssigned1()))
								|| (("3".equals(taskdistribution_str[i])) && (examineProcessVO
										.isAssigned2()))
								|| (("4".equals(taskdistribution_str[i])) && (examineProcessVO
										.isAssigned3()))
								|| (("5".equals(taskdistribution_str[i]))
										&& (examineProcessVO.isAssigned4()) && (examineServ
										.getValidationAssignCount(array_str[i]) <= 0))) {
							returncode = "on assign";
							break;
						}

					}
				}
			}
		} else {
			returncode = "";
		}
		setResult(returncode);
		return "success";
	}

	public String getDoFlag() {
		return this.doFlag;
	}

	public void setDoFlag(String doFlag) {
		this.doFlag = doFlag;
	}

	public ChannelVO getChannelVO() {
		return this.channelVO;
	}

	public void setChannelVO(ChannelVO channelVO) {
		this.channelVO = channelVO;
	}

	public List<ChannelPic> getChannelPicList() {
		return this.channelPicList;
	}

	public void setChannelPicList(List<ChannelPic> channelPicList) {
		this.channelPicList = channelPicList;
	}

	public List<PictureProgramMapping> getProgramPicList() {
		return this.programPicList;
	}

	public void setProgramPicList(List<PictureProgramMapping> programPicList) {
		this.programPicList = programPicList;
	}

	public ScheduleVO getSchedule() {
		return this.schedule;
	}

	public void setSchedule(ScheduleVO schedule) {
		this.schedule = schedule;
	}

	public List<MovieVO> getMovieList() {
		return this.movieList;
	}

	public void setMovieList(List<MovieVO> movieList) {
		this.movieList = movieList;
	}

	public CategoryVO getCategoryVO() {
		return this.categoryVO;
	}

	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}

	public ScheduleinfoVO getScheduleinfo() {
		return this.scheduleinfo;
	}

	public void setScheduleinfo(ScheduleinfoVO scheduleinfo) {
		this.scheduleinfo = scheduleinfo;
	}

	public ScheduleinfoService getScheduleinfoService() {
		return this.scheduleinfoService;
	}

	public void setScheduleinfoService(ScheduleinfoService scheduleinfoService) {
		this.scheduleinfoService = scheduleinfoService;
	}

	public String getCategory_id() {
		return this.category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getActointype() {
		return this.actointype;
	}

	public void setActointype(String actointype) {
		this.actointype = actointype;
	}
}
*/