package com.seelecloud.cms.vo;

/**
 * @Desc: (方便两张表进行操作,抽取处两张表所需要的属性。)
 * @author: 张瑞
 * @date: 2016年10月29日 下午5:05:39
 * @email:2411685663@qq.com
 */
public class ChannelVo {

	/**
	 * 栏目编号
	 */
	private int id;

	/**
	 * 栏目的名称
	 */
	private String title;

	/**
	 * 栏目类型
	 */
	private String name;

	/**
	 * 栏目的点击量
	 */
	private int hint;

	/**
	 * 栏目的排列
	 */
	private int channelOrder;

	/**
	 * 栏目的状态，1 可用, 0不可用
	 */

	private byte status;

	/**
	 * 是否是推荐栏目， true 推荐, false不推荐
	 */
	private boolean recommend;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHint() {
		return hint;
	}

	public void setHint(int hint) {
		this.hint = hint;
	}

	public int getChannelOrder() {
		return channelOrder;
	}

	public void setChannelOrder(int channelOrder) {
		this.channelOrder = channelOrder;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public ChannelVo(int id, String title, String name, int hint,int channelOrder, byte status,
			boolean recommend) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.hint = hint;
		this.channelOrder = channelOrder;
		this.status = status;
		this.recommend = recommend;
	}

	public ChannelVo() {
		super();
	}

}
