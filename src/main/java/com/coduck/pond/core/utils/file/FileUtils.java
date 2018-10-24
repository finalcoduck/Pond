package com.coduck.pond.core.utils.file;

import java.io.File;

public class FileUtils {
	
	/*
	 * 실제 파일 경로 삭제
	 */
	public static boolean deleteFile(String filePath) {
		File ff = new File(filePath);
		if(!ff.exists()) {
			return false;
		}
		return ff.delete();
	}
	
	/*
	 * 파일 사이즈
	 */
	public static long changeFileSize(long fileSize) {
		double newSize = fileSize/1024.0;
		fileSize = (long)Math.ceil(newSize);
		return fileSize;
	}
	
	/*
	 * 파일 확장자
	 */
	public static String getFileType(String fileName) {
		fileName = fileName.trim().substring(fileName.length()-3).toLowerCase();
		return fileName;
	}
	
}
