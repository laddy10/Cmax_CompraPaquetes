package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

public class LectorExcel {

  /**
   * Obtiene los datos de un archivo de excel, teniendo en cuenta el nombre de la hoja
   *
   * @param excelFilePath Ruta del libro de excel
   * @param sheetName Nombre de la hoja que contiene los datos
   * @return
   * @throws InvalidFormatException Manejo de error por formato invalido
   * @throws IOException Manejo de error para el proceso de entrada y salida de datos
   */
  public List<Map<String, String>> getData(String excelFilePath, String sheetName)
      throws InvalidFormatException, IOException {
    Sheet sheet = getSheetByName(excelFilePath, sheetName);
    return readSheet(sheet);
  }

  /**
   * Obtiene los datos de un archivo excel, teniendo en cuenta el numero de la hoja
   *
   * @param excelFilePath Ruta del libro de excel
   * @param sheetNumber Nombre de la hoja que contiene los datos
   * @return
   * @throws InvalidFormatException Manejo de error por formato invalido
   * @throws IOException Manejo de error para el proceso de entrada y salida de datos
   */
  public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
      throws InvalidFormatException, IOException {
    Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
    return readSheet(sheet);
  }

  /**
   * Obtiene la hoja de trabajo donde se encuentran los datos de acuerdo a la ruta del archivo.
   *
   * @param excelFilePath Ruta del libro de excel
   * @param sheetName Nombre de la hoja que contiene los datos
   * @return
   * @throws IOException Manejo de error para el proceso de entrada y salida de datos
   * @throws InvalidFormatException Manejo de error por formato invalido
   */
  private Sheet getSheetByName(String excelFilePath, String sheetName)
      throws IOException, InvalidFormatException {
    Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
    return sheet;
  }

  /**
   * Obtiene la hoja de trabajo donde se encuentran los datos de acuerdo al index de la hoja.
   *
   * @param excelFilePath Ruta del libro de excel
   * @param sheetNumber Nombre de la hoja que contiene los datos
   * @return
   * @throws IOException Manejo de error para el proceso de entrada y salida de datos
   * @throws InvalidFormatException Manejo de error por formato invalido
   */
  private Sheet getSheetByIndex(String excelFilePath, int sheetNumber)
      throws IOException, InvalidFormatException {
    Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
    return sheet;
  }

  /**
   * Devuelve el libro correspondiente a la hoja determinada con antelación
   *
   * @param excelFilePath Ruta del libro de excel
   * @return
   * @throws IOException Manejo de error para el proceso de entrada y salida de datos
   */
  private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
    return WorkbookFactory.create(new File(excelFilePath));
  }

  /**
   * Retorna la lista en forma de Map de todas las filas que contiene la hoja de excel, teniendo en
   * cuenta la primera fila como los nombres de las columnas.
   *
   * @param sheet Hoja de excel
   * @return
   */
  private List<Map<String, String>> readSheet(Sheet sheet) {
    Row row;
    int totalRow = sheet.getPhysicalNumberOfRows();
    List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
    int headerRowNumber = getHeaderRowNumber(sheet);
    if (headerRowNumber != -1) {
      int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
      int setCurrentRow = 1;
      for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
        row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
        LinkedHashMap<String, String> columnMapData = new LinkedHashMap<String, String>();
        for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
          columnMapData.putAll(getCellValue(sheet, row, currentColumn));
        }
        excelRows.add(columnMapData);
      }
    }
    return excelRows;
  }

  /**
   * Obtiene el número de filas concerniente a encabezado de la hoja
   *
   * @param sheet Hoja de excel
   * @return
   */
  private int getHeaderRowNumber(Sheet sheet) {
    Row row;
    int totalRow = sheet.getLastRowNum();
    for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
      row = getRow(sheet, currentRow);
      if (row != null) {
        int totalComun = row.getLastCellNum();
        for (int currentColumn = 0; currentColumn < totalComun; currentColumn++) {
          Cell cell;
          cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
          if (cell.getCellType() == CellType.STRING) {
            return row.getRowNum();
          } else if (cell.getCellType() == CellType.NUMERIC) {
            return row.getRowNum();
          } else if (cell.getCellType() == CellType.BOOLEAN) {
            return row.getRowNum();
          } else if (cell.getCellType() == CellType.ERROR) {
            return row.getRowNum();
          }
        }
      }
    }
    return (-1);
  }

  /**
   * Obtiene la fila de acuerdo a la hoja y el número de esta.
   *
   * @param sheet Hoja de excel
   * @param rowNumber Numero de filas
   * @return
   */
  private Row getRow(Sheet sheet, int rowNumber) {
    return sheet.getRow(rowNumber);
  }

  /**
   * Obtiene el valor de cada una de las celdas
   *
   * @param sheet Hoja de excel
   * @param row Fila de la cual se obtendran los datos
   * @param currentColumn Columna actual
   * @return
   */
  private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
    LinkedHashMap<String, String> columnMapData = new LinkedHashMap<String, String>();
    Cell cell;
    if (row == null) {
      if (sheet
              .getRow(sheet.getFirstRowNum())
              .getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
              .getCellType()
          != CellType.BLANK) {
        String columnHeaderName =
            sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
        columnMapData.put(columnHeaderName, "");
      }
    } else {
      cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
      if (cell.getCellType() == CellType.STRING) {
        if (sheet
                .getRow(sheet.getFirstRowNum())
                .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                .getCellType()
            != CellType.BLANK) {
          String columnHeaderName =
              sheet
                  .getRow(sheet.getFirstRowNum())
                  .getCell(cell.getColumnIndex())
                  .getStringCellValue();
          columnMapData.put(columnHeaderName, cell.getStringCellValue());
        }
      } else if (cell.getCellType() == CellType.NUMERIC) {
        if (sheet
                .getRow(sheet.getFirstRowNum())
                .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                .getCellType()
            != CellType.BLANK) {
          String columnHeaderName =
              sheet
                  .getRow(sheet.getFirstRowNum())
                  .getCell(cell.getColumnIndex())
                  .getStringCellValue();
          columnMapData.put(
              columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
        }
      } else if (cell.getCellType() == CellType.BLANK) {
        if (sheet
                .getRow(sheet.getFirstRowNum())
                .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                .getCellType()
            != CellType.BLANK) {
          String columnHeaderName =
              sheet
                  .getRow(sheet.getFirstRowNum())
                  .getCell(cell.getColumnIndex())
                  .getStringCellValue();
          columnMapData.put(columnHeaderName, "");
        }
      } else if (cell.getCellType() == CellType.BOOLEAN) {
        if (sheet
                .getRow(sheet.getFirstRowNum())
                .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                .getCellType()
            != CellType.BLANK) {
          String columnHeaderName =
              sheet
                  .getRow(sheet.getFirstRowNum())
                  .getCell(cell.getColumnIndex())
                  .getStringCellValue();
          columnMapData.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
        }
      } else if (cell.getCellType() == CellType.ERROR) {
        if (sheet
                .getRow(sheet.getFirstRowNum())
                .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                .getCellType()
            != CellType.BLANK) {
          String columnHeaderName =
              sheet
                  .getRow(sheet.getFirstRowNum())
                  .getCell(cell.getColumnIndex())
                  .getStringCellValue();
          columnMapData.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
        }
      }
    }
    return columnMapData;
  }
}
