package top.chengdongqing.common.kit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.jfinal.plugin.activerecord.Model;

/**
 * 生成excel工具类
 * 
 * @author Luyao
 *
 */
public class ExcelKit {

	/**
	 * 生成excel
	 * 
	 * @param titles
	 * @param list
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public static byte[] generateExcel(LinkedHashMap<String, String> titles, List<? extends Model> list)
			throws IOException {
		// 实例化xssf工作簿
		Workbook book = WorkbookFactory.create(true);
		// 创建excel表格
		Sheet sheet = book.createSheet();
		// 默认列宽
		sheet.setDefaultColumnWidth(20);

		// 定义单元格样式
		CellStyle cellStyle = book.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);

		// 创建标题行
		int rowIndex = 0;
		Row titleRow = sheet.createRow(rowIndex);
		int cellIndex = 0;
		for (String title : titles.values()) {
			Cell cell = titleRow.createCell(cellIndex);
			cell.setCellValue(title);
			cell.setCellStyle(cellStyle);
			cellIndex++;
		}

		// 创建数据行
		for (Model model : list) {
			rowIndex++;
			cellIndex = 0;
			Row row = sheet.createRow(rowIndex);
			for (String key : titles.keySet()) {
				Cell cell = row.createCell(cellIndex);
				String value = model.getStr(key);
				// 调整日期格式
				if (key.contains("Time") && value.contains(".0")) {
					value = value.replace(".0", "");
				}

				cell.setCellValue(value);
				cell.setCellStyle(cellStyle);
				cellIndex++;
			}
		}

		// 实例化字节数组输出流
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			// 将文件流写入到输出流
			book.write(os);
			return os.toByteArray();
		}
	}
}
