package com.seelecloud.cms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seelecloud.cms.entity.Channel;
import com.seelecloud.cms.service.ChannelService;
import com.seelecloud.cms.service.ChannelTypeService;
import com.seelecloud.cms.vo.ChannelVo;

/** 
 * @Desc: (内容管理控制器: 栏目管理)
 * @author: 张瑞
 * @date: 2016年11月1日 下午4:42:06  
 * @email:2411685663@qq.com 
 */
@Controller
@RequestMapping("/admin/content")
public class ChannelController {
	@Autowired
	private ChannelTypeService channelTypeService;	
	@Autowired
	private ChannelService channelService;
	
	/**
	 * 栏目列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/channel", method = RequestMethod.GET)
	public String channel() {
		return "channel/channel";
	}

	/**
	 * 栏目树：获取id,parentId,Name 异步ajax
	 * 
	 * @return
	 */
	@RequestMapping("/ajaxchannel")
	@ResponseBody
	public List<Channel> ajaxchannel() {
		List<Channel> mvList = channelService.listChannelByTree();
		return mvList;
	}

	/**
	 * 获取当前操作栏目名称
	 * 
	 * @param pid
	 * @param model
	 */
	public void initRoot(Integer pid, Model model) {
		Channel currentChannelName = channelService.findChannelById(pid);
		model.addAttribute("currentChannelName", currentChannelName);
	}

	/**
	 * 通过channel表type属性获取contentType表name属性
	 * 
	 * @param pid
	 * @param model
	 */
	public void initChannel(Integer pid, Model model) {
		ChannelVo cs = null;
		List<ChannelVo> cLists = new ArrayList<ChannelVo>();
		List<Channel> channelLists = channelService.listChannelByParent(pid);
		String channelTypeName = null;

		for (Channel channel : channelLists) {
			channelTypeName = this.channelTypeService.
					findNameById(channel.getType());

			cs = new ChannelVo(channel.getId(), channelTypeName,
							channel.getTitle(), channel.getHint(),
							channel.getChannelOrder(), channel.getStatus(),
							channel.isRecommend());
			cLists.add(cs);
		}
		model.addAttribute("channels", cLists);
	}

	/**
	 * 点击任意栏目,列出该栏目下的子栏目
	 * 
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping("/channel/{pid}")
	public String listChannelByParent(@PathVariable Integer pid, Model model) {
		initRoot(pid, model);
		initChannel(pid, model);
		return "channel/channelChild";
	}

	/**
	 * 添加栏目
	 * 
	 * @return
	 */
	@RequestMapping(value = "/channelSave/{pid}", method = RequestMethod.GET)
	public String channelSave(@PathVariable Integer pid, Model model) {
		initRoot(pid, model);
		model.addAttribute("channel", new Channel());
		return "channel/channelSave";
	}

	/**
	 * 添加栏目后跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/channelSave/{pid}", method = RequestMethod.POST)
	public String channelSave(@PathVariable Integer pid, Model model,
			Channel channel) {
		initRoot(pid, model);
		Integer channelOrder = this.channelService.getMaxOrderByParent(pid);
		if (channelOrder == null) {
			channelOrder = 0;
		}
		if (pid == 0) {
			channel.setParentId(0);
			channel.setChannelOrder(0);
		}else {
			channel.setParentId(pid);
			channel.setChannelOrder(channelOrder + 1);
		}
		channelService.save(channel);
		return "redirect:/admin/content/channel/" + pid;
	}

	/**
	 * 更新栏目
	 * 
	 * @return
	 */
	@RequestMapping(value = "/channelUpdate/{id}", method = RequestMethod.GET)
	public String channelUpdate(@PathVariable Integer id, Model model) {
		Channel channel = channelService.findChannelById(id);
		model.addAttribute("channel", channel);
		return "channel/channelUpdate";
	}

	/**
	 * 更新栏目后跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/channelUpdate/{id}", method = RequestMethod.POST)
	public String channelUpdate(@PathVariable Integer id, Channel channel) {
		Channel channel2 = channelService.findChannelById(id);
		channel2.setTitle(channel.getTitle());
		channel2.setType(channel.getType());
		channel2.setStatus(channel.getStatus());
		channel2.setRecommend(channel.isRecommend());
		channelService.update(channel2);
		return "redirect:/admin/content/channel/" + id;
	}
}
