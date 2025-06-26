package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
  private static XSSFSheet ExcelWSheet;
  private static XSSFWorkbook ExcelWBook;
  private static XSSFCell Cell;
  private static XSSFRow Row;

  public static void setExcelFile(String Path, String SheetName) throws Exception {
    try {
      FileInputStream ExcelFile = new FileInputStream(Path);
      ExcelWBook = new XSSFWorkbook(ExcelFile);
      ExcelWSheet = ExcelWBook.getSheet(SheetName);
    } catch (Exception e) {
      throw (e);
    }
  }

  @SuppressWarnings("deprecation")
  public static String getCellData(int rowNum, int colNum) {
    String CellData = "";
    try {
      Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
      if (Cell.getCellType() == CellType.STRING) {
        CellData = Cell.getStringCellValue();
      }
      if (Cell.getCellType() == CellType.NUMERIC) {
        CellData = Cell.getRawValue();
      }
      return CellData;
    } catch (Exception e) {
      return "";
    }
  }

  public static int countRows() {
    return ExcelWSheet.getLastRowNum();
  }

  public static void setCellData(int rowNum, int colNum, String obtainedText) {
    try {
      ExcelWSheet.getRow(rowNum).createCell(colNum).setCellValue(obtainedText);
      ExcelWSheet.getRow(rowNum).getCell(colNum).setCellValue(obtainedText);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }

  public static void saveData(String Path) {
    try {
      FileOutputStream ExcelFileOut = new FileOutputStream(Path);
      ExcelWBook.write(ExcelFileOut);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void closeBook() throws IOException {
    ExcelWBook.close();
  }
}
