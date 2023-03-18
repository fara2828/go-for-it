package com.highfive.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{


	public File rename(File originFile) {
		
		// 원본파일명 뽑기
		String originName = originFile.getName();
		
		/*
		 * 수정된 파일명 
		 * 
		 * highfive_yyyyMMddHHmmss_랜덤숫자5
		 * 
		 */
		
		
		// 파일이 업로드 된 시간
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		// 랜덤값 뽑기
		int ranNum = (int)(Math.random() * 99999) + 10000;
		
		// 확장자 뽑기
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = "highfive_" + currentTime + "_" + ranNum + ext;
		
		return new File(originFile.getParent(), changeName);
	}

}
