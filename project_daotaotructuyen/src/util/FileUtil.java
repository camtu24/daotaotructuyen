package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import constant.Defines;
import model.bean.ListQuestion;

public final class FileUtil {
	private static String fileName = "";

	public static String getFileReName(String fileName) {
		return fileName = !"".equals(fileName) ? FilenameUtils.getBaseName(fileName) + "-" + System.nanoTime() + "."
				+ FilenameUtils.getExtension(fileName) : "";
	}

	public static String getFileName() {
		return fileName;
	}

	public static boolean isFileFitness(String[] arFileExtension, String fileNameExtension) {
		boolean isFileFitness = false;
		Map<String, String> mapTypeFile = new HashMap<>();
		for (String key : arFileExtension) {
			mapTypeFile.put(key, key);
		}

		if (!"".equals(fileNameExtension)) {
			isFileFitness = true;
		}

		if ((mapTypeFile != null && mapTypeFile.size() > 0)) {
			isFileFitness = mapTypeFile.containsKey(FilenameUtils.getExtension(fileNameExtension));
		}

		return isFileFitness;
	}

	public static void upload(CommonsMultipartFile cmf, HttpServletRequest request) throws IOException {
		fileName = cmf.getOriginalFilename();
		String appPath = request.getServletContext().getRealPath("");
		String dirPath = appPath + Defines.DIR_UPLOAD;

		if (!"".equals(fileName)) {
			// check type file
			File createDir = new File(dirPath);
			if (!createDir.exists()) {
				createDir.mkdirs();
			}
			fileName = FileUtil.getFileReName(fileName);
			String filePath = dirPath + File.separator + fileName;

			try {
				cmf.transferTo(new File(filePath));
			} catch (IOException e) {
				throw new IOException();
			}
		}
	}

	public static String getContextPath(HttpServletRequest request) {
		return request.getServletContext().getRealPath("");
	}

	public String getExtension() {
		return !"".equals(fileName) ? FilenameUtils.getExtension(fileName) : "";
	}

	public String getBaseName() {
		return !"".equals(fileName) ? FilenameUtils.getBaseName(fileName) : "";
	}

	public static void delete(String fileName, HttpServletRequest request) throws IOException {
		if (!"".equals(fileName)) {
			File file = new File(request.getServletContext().getRealPath("") + Defines.DIR_UPLOAD + File.separator + fileName);
			file.delete();
		} else {
			throw new IOException();
		}
	}

	//doc file
	private static Object getCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	    case STRING:
	        return cell.getStringCellValue();
	 
	    case BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case NUMERIC:
	        return cell.getNumericCellValue();
	    }
	 
	    return null;
	}
	
	public static List<ListQuestion> readBooksFromExcelFile(String excelFilePath) throws IOException {
	    List<ListQuestion> listBooks = new ArrayList<ListQuestion>();
	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	 
	    Workbook workbook = getWorkbook(inputStream, excelFilePath);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	 
	    while (iterator.hasNext()) {
	        Row nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        ListQuestion listQuestion = new ListQuestion();
	 
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	 
	            switch (columnIndex) {
	            case 1:
	            	listQuestion.setCauHoi((String) getCellValue(nextCell));
	                break;
	            case 2:
	            	listQuestion.setOption1((String) getCellValue(nextCell));
	                break;
	            case 3:
	            	listQuestion.setOption2((String) getCellValue(nextCell));
	                break;
	            case 4:
	            	listQuestion.setOption3((String) getCellValue(nextCell));
	                break;    
	            case 5:
	            	listQuestion.setOption4((String) getCellValue(nextCell));
	                break;    
	            case 6:
	            	listQuestion.setDapAnDung((String) getCellValue(nextCell));
	                break; 
	            case 7:
	            	listQuestion.setDiem((double) getCellValue(nextCell));
	                break;    
	            }
	        }
	        listBooks.add(listQuestion);
	    }
	 
	    workbook.close();
	    inputStream.close();
	 
	    return listBooks;
	}
	
	//Được sử dụng để có thể đọc được cả định dạng .xls và xlsx
	private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
	    Workbook workbook = null;
	 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook(inputStream);
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook(inputStream);
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	 
	    return workbook;
	}
}
