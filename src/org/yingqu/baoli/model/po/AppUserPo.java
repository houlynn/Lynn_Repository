package org.yingqu.baoli.model.po;

import org.yingqu.framework.model.vo.PModel;

/**
 * 用户修改
 * 
 * @author HouLynn
 * @date 2014年9月2日
 * @version 1.0
 */
public class AppUserPo extends PModel {
	/**
	 * 主键
	 */
	private String userid;
	/**
	 * 昵称
	 */
	private String username;
	/**
	 * 用户等级 登陆一次加1分 10分一个等级
	 */
	private int levf;
	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 性别 0 1 1是男
	 */
	private String sex;

	/**
	 * 我的帖子
	 */
	private int noteCount;

	/**
	 * 我的订单
	 */
	private int orderCount;
	/**
	 * 我的预约
	 */
	private int makeCount;
	/**
	 * 我的收藏
	 */
	private int collecCount;

	/**
	 * 用户头像
	 */
	private String topUrl;
	/**
	 * 帐号（手机号）
	 */
	private String loginCode;
	/**
	 * 默认收货地址
	 */
	private String defaultAddressid;

	/**
	 * 职业
	 */
	private String occupation;
	/**
	 * 星座
	 */
	private String constellation;
	/**
	 * 家乡
	 */
	private String home;
	/**
	 * 个性签名
	 */
	private String sefTick;

	/**
	 * 感情状态
	 */
	private String feelings;

	/**
	 * 兴趣爱好
	 */
	private String hoby;

	/**
	 *  登录密码
	 */
	private String pwd;
	
	
	
/*	*//**
	 * 城市
	 *//*
	private String city;
	*//**
	 * 小区名称
	 *//*
	private String deptname;

*/

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getFeelings() {
		return feelings;
	}

	public void setFeelings(String feelings) {
		this.feelings = feelings;
	}

	public String getHoby() {
		return hoby;
	}

	public void setHoby(String hoby) {
		this.hoby = hoby;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public String getSefTick() {
		return sefTick;
	}

	public void setSefTick(String sefTick) {
		this.sefTick = sefTick;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTopUrl() {
		return topUrl;
	}

	public void setTopUrl(String topUrl) {
		this.topUrl = topUrl;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getNoteCount() {
		return noteCount;
	}

	public void setNoteCount(int noteCount) {
		this.noteCount = noteCount;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getMakeCount() {
		return makeCount;
	}

	public void setMakeCount(int makeCount) {
		this.makeCount = makeCount;
	}

	public int getCollecCount() {
		return collecCount;
	}

	public void setCollecCount(int collecCount) {
		this.collecCount = collecCount;
	}

	public int getLevf() {
		return levf;
	}

	public void setLevf(int levf) {
		this.levf = levf;
	}

	public String getDefaultAddressid() {
		return defaultAddressid;
	}

	public void setDefaultAddressid(String defaultAddressid) {
		this.defaultAddressid = defaultAddressid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


}
