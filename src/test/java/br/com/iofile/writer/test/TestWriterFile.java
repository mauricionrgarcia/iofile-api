package br.com.iofile.writer.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.iofile.example.beans.BodyBean;
import br.com.iofile.example.beans.HeaderBean;
import br.com.iofile.writer.WriterIOFile;

/**
 * Metodo para efetuar o teste da escrita de excel
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:51:16
 */
public class TestWriterFile {

	/**
	 * Teste padrao
	 *
	 * @throws Exception exception
	 */
	@Test
	public void test() throws Exception {

		List<BodyBean> objects = new ArrayList<>();
		BodyBean bean = new BodyBean();
		bean.setIdentification("123");
		bean.setName("Cada da Massa");
		bean.setAddress("Rua 1");
		bean.setSpecialty("Massas");
		bean.setDocument("123456789");
		bean.setDate(new Date());
		bean.setValor(2.5);
		objects.add(bean);

		HeaderBean header = new HeaderBean();
		header.setName("Mauricio");

		long initTime = Calendar.getInstance().getTimeInMillis();
		new WriterIOFile("test.xlsx", header, objects);
		long finalTime = Calendar.getInstance().getTimeInMillis();

		long time = finalTime - initTime;

		System.out.println("Tempo total: " + time / 1000 + " s |  " + time + " ms ");

	}
}