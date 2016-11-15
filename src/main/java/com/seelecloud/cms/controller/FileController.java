/**
 							The Apache License 2.0
						 Copyright (c) 2016 Ramostear 
							2016年8月18日 下午2:42:07
		Unless required by applicable law or agreed to in writing, software distributed under
      the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
      KIND, either express or implied.	See the License for the specific language governing 
      permissions and limitations under the License. 
 */
package com.seelecloud.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seelecloud.cms.entity.FileEntity;
import com.seelecloud.cms.service.FileService;

/**
 * @description: 资源文件上传与下载, 更新,删除管理
 * @author: vabo
 * @version:
 * @Datetime:2016年11月8日
 * @Email:
 */
@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;

	/**
	 * 插图上传
	 * 
	 * 附件文件上传
	 * 
	 * 封面图片上传
	 * 
	 * 普通文件上传
	 * 
	 * 文件下载
	 * 
	 * 文件管理:　更改　删除
	 */

	/**
	 * 文件资源列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/fileList", method = RequestMethod.GET)
	public String listFiles() {
		return "file/fileList";
	}

	/**
	 * 新上传一个文件
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/fileSave", method = RequestMethod.GET)
	public String toSaveFile(Model model) {
		FileEntity file = new FileEntity();
		model.addAttribute("file", file);
		return "file/fileSave";
	}

	@RequestMapping(value = "/fileSave", method = RequestMethod.POST)
	public String saveFile() {

		return "file/fileList";
	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public void uploadFile() {

	}

}
