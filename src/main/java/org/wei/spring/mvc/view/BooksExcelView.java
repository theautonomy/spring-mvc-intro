package org.wei.spring.mvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.wei.spring.mvc.domain.Book;
import org.wei.spring.mvc.domain.BookList;

public class BooksExcelView extends AbstractExcelView {

	public final HSSFCellStyle NO_STYLE = null;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<Book> books = ((BookList) model.get("books")).getBookslst();

		HSSFSheet sheet = workbook.createSheet();

		int unit =  1300; // = 1cm
		sheet.setColumnWidth( 0, (unit * 10));
		sheet.setColumnWidth( 1, (unit * 10));
		sheet.setColumnWidth( 2, (unit * 10));

		HSSFCellStyle heading = workbook.createCellStyle();
		heading.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		heading.setBottomBorderColor(HSSFColor.BLACK.index);
		heading.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		heading.setFillBackgroundColor(HSSFColor.LIGHT_GREEN.index);
		heading.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		heading.setFont(font);

		HSSFRow row = sheet.createRow(0);
		addToCell(row, 0, "Id", heading);
		addToCell(row, 1, "Title", heading);
		addToCell(row, 2, "Author", heading);

		int i = 0;
		for (Book book : books) {
			row = sheet.createRow(++i);
			addToCell(row, 0, book.getId(), NO_STYLE);
			addToCell(row, 1, book.getTitle(), NO_STYLE);
			addToCell(row, 2, book.getAuthor(), NO_STYLE);
		}

	}

	private HSSFCell addToCell(HSSFRow row, int index, Object value, HSSFCellStyle style) {
		HSSFCell cell = row.createCell(index);

		if (style == null) {
			style = cell.getCellStyle();
		}

		if (value == null) {
			value = ""; 
		}
		
		cell.setCellValue(new HSSFRichTextString(value.toString()));
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);		
		cell.setCellStyle(style);
		
		return cell;
	}

}
