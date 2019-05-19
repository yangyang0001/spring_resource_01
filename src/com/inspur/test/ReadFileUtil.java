package com.inspur.test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("unchecked")
public class ReadFileUtil {

	public static List<String> readFileToString() throws Exception {

		File file = new File("F:\\aaa.txt");

		InputStream inputStream = new FileInputStream(file);

		BufferedInputStream bis = new BufferedInputStream(inputStream);

		List<String> list = IOUtils.readLines(bis, "UTF-8");

		return list;
	}

	public static String readFileToStringByFileUtil() throws Exception {

		File file = new File("F:\\aaa.txt");

		String result = FileUtils.readFileToString(file, "UTF-8");

		return result;
	}


	private static String recombineSchdule(String channelDate, String channelSchedule) {
		try {
			SimpleDateFormat defaultSDF = new SimpleDateFormat("yyyy-MM-dd");
			StringBuffer schedule = new StringBuffer();
			
			String[] timeAndSchedule = channelSchedule.split("\\|");
			String[] times = timeAndSchedule[0].split("-");
			String startTime = times[0];
			String endTime = times[1];
			
			if(startTime.compareTo(endTime) <= 0){
				schedule.append(channelDate).append(startTime).append("-").append(channelDate).append(endTime).append("|").append(timeAndSchedule[1]); 
			}else{
				Date date = defaultSDF.parse(channelDate);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(Calendar.DATE, 1);
				Date nextDate = calendar.getTime();
				String channelNextDate = defaultSDF.format(nextDate);
				schedule.append(channelDate).append(startTime).append("-").append(channelNextDate).append(endTime).append("|").append(timeAndSchedule[1]); 
			}
			return schedule.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void compileTo() throws Exception{
		
		File file = new File("C:\\Users\\YangJianWei\\Desktop\\HW_Userinfo_2017121822.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fileInputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		int i = 0;
		int  whiteLineCount = 0;
		String line = "";
		
		while((line = bufferedReader.readLine()) != null){
			if(StringUtils.isBlank(line.trim())){
				whiteLineCount ++;
//				System.out.println("当前空行行号 ---------:" + index);
			}else{
				String[] lineArray = line.split("\\|");
				if(lineArray[6].trim().equals("1")){
					i++;
				}
			}
		}
		
		System.out.println("空行一共有" + whiteLineCount + "个");
		System.out.println("有效数据有" + i + "个");
	}
	
	
	public static void compileLine() throws Exception{
		
		File file0 = new File("D:\\dx0.txt");
		FileInputStream fileInputStream0 = new FileInputStream(file0);
		InputStreamReader reader0 = new InputStreamReader(fileInputStream0);
		BufferedReader bufferedReader0 = new BufferedReader(reader0);
		
		String fileLine0 = "";
		String fileLine1 = "";
		
		int index = 1;
		
		Map<String,String> map = new HashMap<String,String>();
		
		while((fileLine0 = bufferedReader0.readLine()) != null){
			String fileLine_0 = fileLine0.split("\\|")[2].trim();
			
			System.out.println(fileLine0);
			
			File file1 = new File("E:\\dx1.txt");
			FileInputStream fileInputStream1 = new FileInputStream(file1);
			InputStreamReader reader1 = new InputStreamReader(fileInputStream1);
			BufferedReader bufferedReader1 = new BufferedReader(reader1);
			
			while((fileLine1 = bufferedReader1.readLine()) != null){
				String fileLine_1 = fileLine1.split("\\|")[2].trim();
				if(fileLine_0.equals(fileLine_1)){
					map.put(fileLine_0, fileLine0);
				}
			}
			
			index++;
			if(index == 100){
				break;
			}
		}
		
		System.out.println("map.size --------------: " + map.size());
		
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println(entry.getKey() + " --------- " + entry.getValue());
		}
		
	}
	
	
	public static void createFolder(String fileName){
		fileName = "C:/Users/YangJianWei/Desktop/" + fileName.replace(".", "/");
		File file = new File(fileName);
		if(!file.exists()) file.mkdirs();
	}

	public static void createFolderAndFile() throws Exception {
		
		File folder = new File("C:/Users/YangJianWei/Desktop/KKKK");
		if(!folder.exists()) folder.mkdirs();
		
		File file = new File("C:/Users/YangJianWei/Desktop/KKKK/aaa.log");
		if(!file.exists()) file.createNewFile();
		
		FileOutputStream out = new FileOutputStream(file,true);
		PrintWriter writer = new PrintWriter(out);
		
		writer.write("\r\n");
		writer.write("KKKKKK");
		writer.write("\r\n");
		writer.write("LLLLLL");
		
		writer.flush();
		writer.close();
		out.close();
		
		System.out.println(file.getName());
	}
	
	
	public static void moveFileToOtherFile() throws Exception{
		
		String fileAllPath = "D:/下载的各种包/spring-framework-3.2.6.RELEASE/libs";
		String fileSourcePath = "D:/下载的各种包/spring-framework-3.2.6.RELEASE/libs/source_lib/";
		String fileDocsPath = "D:/下载的各种包/spring-framework-3.2.6.RELEASE/libs/source_doc/";
		
//		String fileAllPath = "D:/源码包/spring-framework-4.1.5.RELEASE/libs/";
//		String fileSourcePath = "D:/源码包/spring-framework-4.1.5.RELEASE/source/";
//		String fileDocsPath = "D:/源码包/spring-framework-4.1.5.RELEASE/source_docs/";
		
		File allFile = new File(fileAllPath);
		
		if(allFile.isDirectory()){
			File[] jarFiles = allFile.listFiles();
			for(File file : jarFiles){
				if(file.getName().endsWith("sources.jar")){
					file.renameTo(new File(fileSourcePath + file.getName()));
				}else if(file.getName().endsWith("javadoc.jar")){
					file.renameTo(new File(fileDocsPath + file.getName()));
				}
			}
		} else {
			System.out.println("is Not directdory");
		}
		
		System.out.println("Move Success End");
	}
	
	
	public static void buildDirectory(){
		boolean directoryFlag = false;
		String directoryPath = "D:/data/webapps/cbms/xml/";
		File directory = new File(directoryPath);
		
		if(!directory.exists()){
			directoryFlag = directory.mkdirs();
		}
		
		System.out.println("directoryFlag ---------------:" + directoryFlag);
	}
	
	//-20180530
	public static void readTextLogToFile() throws Exception{
		File file = new File("D:\\LOG\\catalina.out");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		File timeFile = null;
		FileOutputStream fos = null;
		PrintWriter out = null;
		String line = null;
		String fileName = "";
		
		while((line = bufferedReader.readLine()) != null){
			try {
				if(line.startsWith("2018")){
					fileName = line.substring(0, 13);
				} else if(line.startsWith("[2018")){
					fileName = line.substring(1, 14);
				}
				timeFile = new File("D:\\" + fileName + ".txt");
				fos = new FileOutputStream(timeFile, true);
				out = new PrintWriter(fos);
				out.println(line);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		out.close();
		fos.close();
	}
	
	/**
	 * 现在不知道问什么
	 * @throws Exception
	 */
	public static void copyFileToDirectory() throws Exception{
		FileReader fileReader = new FileReader("D:\\maven_jar.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String jarFilePath = "";
		while((jarFilePath = bufferedReader.readLine()) != null && StringUtils.isNotBlank(jarFilePath)){
			File jarFile = new File(jarFilePath);
			FileUtils.copyFileToDirectory(jarFile, new File("D:/maven_jar/"));
		}
	}
	
	
	public static void readFileText() throws Exception{
		FileReader fileReader = new FileReader("C:\\Users\\Administrator\\Desktop\\tab.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer("");
		String textLine = "";
		while((textLine = bufferedReader.readLine()) != null){
			stringBuffer.append(textLine.trim());
		}
		System.out.println(stringBuffer.toString());
	}
	
	
	public static void main(String[] args) throws Exception {
		
		buildDirectory();
		moveFileToOtherFile();
		
//		compileTo();
//		compileLine(); 
//		createFolder("com/besto/tms/mapper");
		
//		compileLine();
//		readTextLogToFile();
//		copyFileToDirectory();
		
//		String helloWorld = "   Hello World   ";
//		System.out.println(helloWorld.trim());
		
//		readFileText();
	}
}
