package com.cxsw.web.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

public class fileuploadUtil {
	public static Map<String, String> upload(HttpServletRequest request){
		//鍒涘缓涓�涓鐩樼┖闂�
		DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
		//鍒涘缓ServletFileUpload瀵硅薄
		ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
		
		Map<String, String> map=new HashMap<>();
		try {
           //鑾峰彇鍓嶅彴鐨勫��
			List<FileItem> parseRequest=servletFileUpload.parseRequest(request);
			//閬嶅巻鍓嶅彴鐨勫�硷細1.鏅�氬瓧娈�  2. 鏂囦欢
			for(FileItem fileItem:parseRequest) {
				//濡傛灉鏄櫘閫氬瓧娈�
				if((fileItem.isFormField())) {
					String fileName=fileItem.getFieldName();
					String value=fileItem.getString();
					String values=new String(value.getBytes("iso-8859-1"),"utf-8");
					map.put(fileName, values);
					
				}else {//濡傛灉鏄枃浠�
					//鑾峰彇瀵硅薄杈撳叆娴�
					InputStream inputStream=fileItem.getInputStream();
					//鑾峰彇鏂囦欢鍚嶇О
					String name=fileItem.getName();
					//瀹氫箟鏂扮殑鏂囦欢鍚�
					long currentTimeMillis=System.currentTimeMillis();//鑾峰彇褰撳墠鏃堕棿姣鍊�
					String []split=name.split("[.]");
				
					String strName="G:\\servlet\\CarByFy\\WebContent\\beanclass\\upload\\"+currentTimeMillis+"."+split[1];
					//String strName="D:\\Tomcat\\apache-tomcat-8.5.50\\webapps\\upload\\"+currentTimeMillis+"."+split[1];
					if(name.endsWith("in.jpg")) {
						map.put("inimg", "/upload/"+currentTimeMillis+"."+split[1]);//c_img鍚庡彴瀛楁鍚�
					}else if(name.endsWith("out.jpg")) {
						map.put("outimg", "/upload/"+currentTimeMillis+"."+split[1]);//c_img鍚庡彴瀛楁鍚�
					}else if(name.endsWith("emp.jpg")){
						map.put("emp_img", "/upload/"+currentTimeMillis+"."+split[1]);//c_img鍚庡彴瀛楁鍚�
					}else if(name.endsWith("user.jpg")){
						map.put("user_img", "/upload/"+currentTimeMillis+"."+split[1]);//c_img鍚庡彴瀛楁鍚�
					}else {
						map.put("img", "/upload/"+currentTimeMillis+"."+split[1]);//c_img鍚庡彴瀛楁鍚�
					}
					File file=new File(strName);
					FileOutputStream fileOutputStream=new FileOutputStream(file);
					IOUtils.copy(inputStream, fileOutputStream);
					inputStream.close();
					fileOutputStream.close();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}

}
