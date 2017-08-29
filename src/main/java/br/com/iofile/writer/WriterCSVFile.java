package br.com.iofile.writer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.iofile.interfaces.Writer;
import br.com.iofile.util.HeaderPrint;

/**
 * Classe responsavel por criar arquivos com extensão csv
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 17/06/2017 00:35:33
 */
public class WriterCSVFile implements Writer {

	/**
	 * Representa o nome do arquivo
	 */
	private String fileName;
	/**
	 * fileWriter
	 */
	private BufferedWriter writer;

	/**
	 * Atributo que representa o estrutura para permitir criar o arquivo
	 */
	private Map<Integer, List<HeaderPrint>> print;

	/**
	 * representa a linha atual
	 */
	private Integer curentRow;

	/**
	 * Construror
	 *
	 * @param fileName nome do arquivo
	 * @return {@link Writer}
	 * @throws Exception
	 */
	@Override
	public Writer newInstance(String fileName) throws Exception {
		WriterCSVFile r = new WriterCSVFile(fileName);
		return r;
	}

	/**
	 * Construror
	 *
	 * @param fileName nome do arquivo
	 * @throws Exception
	 */
	public WriterCSVFile(String fileName) throws Exception {
		this.fileName = fileName;
		init();
	}

	/**
	 * Inicializa as variaveis
	 *
	 * @throws Exception
	 */
	private void init() throws Exception {
		this.print = new LinkedHashMap<>();
		this.writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(this.fileName), StandardCharsets.UTF_8));
	}

	@Override
	public void createRow(Integer i) {
		this.curentRow = i;
	}

	@Override
	public void print(Integer position, String value) {
		List<HeaderPrint> prints = this.print.get(this.curentRow);
		if (prints == null) {
			prints = new ArrayList<>();
		}
		prints.add(new HeaderPrint(position, this.curentRow, value));

		this.print.put(this.curentRow, prints);
	}

	@Override
	public void finish() throws IOException {
		for (Entry<Integer, List<HeaderPrint>> entry : this.print.entrySet()) {
			List<HeaderPrint> listPrint = entry.getValue();
			Collections.sort(listPrint, (p1, p2) -> Integer.compare(p1.getPosition(), p2.getPosition()));
			int pos = 0;
			StringBuilder buf = new StringBuilder();
			for (; pos < listPrint.size() - 1; pos++) {
				buf.append(listPrint.get(pos).getValue());
				buf.append(',');
			}
			buf.append(listPrint.get(pos).getValue());
			this.writer.write(buf.toString());
			this.writer.newLine();
		}
		this.writer.close();
	}

	@Override
	public void print(HeaderPrint header) {
	}

	@Override
	public void createSection(String name) {

	}

}