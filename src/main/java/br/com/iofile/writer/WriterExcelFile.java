package br.com.iofile.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import br.com.iofile.interfaces.Writer;
import br.com.iofile.util.HeaderPrint;

/**
 * Classe responsavel por criar arquivos com extensão xlsx
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:15:22
 */
public class WriterExcelFile implements Writer {

	/**
	 * Representa o nome do arquivo
	 */
	private String fileName;
	/**
	 * FileOutputStream fos
	 */
	private FileOutputStream fos;
	/**
	 * HSSFWorkbook workbook
	 */
	private HSSFWorkbook workbook;
	/**
	 * HSSFSheet firstSheet
	 */
	private HSSFSheet sheet;
	/**
	 * HSSFRow row
	 */
	private HSSFRow row;

	/**
	 * Construror
	 *
	 * @param fileName nome do arquivo
	 * @return {@link Writer}
	 * @throws Exception
	 */
	@Override
	public Writer newInstance(String fileName) throws Exception {
		WriterExcelFile r = new WriterExcelFile(fileName);
		return r;
	}

	/**
	 * Construror
	 *
	 * @param fileName nome do arquivo
	 * @throws Exception
	 */
	public WriterExcelFile(String fileName) throws Exception {
		this.fileName = fileName;
		init();
	}

	/**
	 * Inicializa as variaveis
	 *
	 * @throws Exception
	 */
	private void init() throws Exception {
		this.fos = new FileOutputStream(new File(this.fileName));
		this.workbook = new HSSFWorkbook();
		this.sheet = this.workbook.createSheet("Aba1");
	}

	@Override
	public void createRow(Integer i) {
		this.row = this.sheet.createRow(i);
	}

	@Override
	public void print(Integer position, String value) {
		this.row.createCell(position).setCellValue(value);
	}

	@Override
	public void finish() throws IOException {
		this.workbook.write(this.fos);
	}

	@Override
	public void print(HeaderPrint header) {

		this.row = this.sheet.getRow(header.getRowHeader());

		if (this.row == null) {
			createRow(header.getRowHeader());
		}
		print(header.getPositionHeader(), header.getHeaderName());

		this.row = this.sheet.getRow(header.getRow());

		if (this.row == null) {
			createRow(header.getRow());
		}
		print(header.getPosition(), header.getValue());

	}

}