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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

	/**
	 * 上传图片到Server, 并裁剪图片
	 * @param imageFile
	 * @param cropperParams
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ajaxCropperImageUpload", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
//	@ResponseBody
	public String ajaxUploadCropperImage(
			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
			@RequestParam(value = "cropperParams") String cropperParams,
			HttpServletRequest request) {
		String realPath = request.getSession().getServletContext()
				.getRealPath("/");
		// TODO
		String dateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String resourcePath = "/upload/image/" + dateStr;

		// 判断文件的MIMEtype
		String type = imageFile.getContentType();
		if (type == null || !FileUploadUtil.allowUpload(type))
			return JSON.toJSONString(new Result(null, "不支持的文件类型!"));
		String fileName = FileUploadUtil
				.rename(imageFile.getOriginalFilename());
		int end = fileName.lastIndexOf(".");
		String saveName = fileName.substring(0, end);
		try {
			File dir = new File(realPath + resourcePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(dir, saveName + "_src.jpg");
			imageFile.transferTo(file);// save into disk, maybe not need
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString(new Result(null, "上传失败，出现异常："
					+ e.getMessage()));
		}
		String srcImagePath = realPath + resourcePath + saveName;
		
		// parse cropper parameter, if NOT NULL will cut image
		if (cropperParams != null) {
			JSONObject joData = (JSONObject) JSONObject.parse(cropperParams);
			// 用户经过剪辑后的图片的大小
			float x = joData.getFloatValue("x");
			float y = joData.getFloatValue("y");
			float w = joData.getFloatValue("width");
			float h = joData.getFloatValue("height");
			float r = joData.getFloatValue("rotate");
			// 这里开始截取操作
			ImgCut.cutAndRotateImage(srcImagePath, (int) x, (int) y, (int) w,
					(int) h, (int) r);
		}
		
		// TODO save into Database
		
		return JSON.toJSONString(new Result(request.getSession()
				.getServletContext().getContextPath()
				+ resourcePath + saveName + "_cut.jpg", "上传成功!"));
	}
	
	protected class Result {
		private String url;
		private String msg;

		public String getUrl() {
			return url;
		}

		public String getMsg() {
			return msg;
		}

		public Result(String url, String msg) {
			super();
			this.url = url;
			this.msg = msg;
		}
	}
}
