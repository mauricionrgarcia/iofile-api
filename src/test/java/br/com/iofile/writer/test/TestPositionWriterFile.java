package br.com.iofile.writer.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.iofile.example.beans.HeaderBean;
import br.com.iofile.example.beans.Tab;
import br.com.iofile.example.beans.Tab2;
import br.com.iofile.example.beans.position.BodyBean;
import br.com.iofile.interfaces.IBean;
import br.com.iofile.interfaces.ITab;
import br.com.iofile.util.Period;
import br.com.iofile.writer.WriterIOFile;

/**
 * Metodo para efetuar o teste da escrita de excel
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 13:51:16
 */
public class TestPositionWriterFile {

	/**
	 * Teste padrao
	 *
	 * @throws Exception exception
	 */
	@Test
	public void test() throws Exception {

		ITab tab = mock();
		ITab tab2 = mock2();

		long initTime = Calendar.getInstance().getTimeInMillis();
		new WriterIOFile("test.xlsx", tab, tab2);
		long finalTime = Calendar.getInstance().getTimeInMillis();

		long time = finalTime - initTime;

		System.out.println("Tempo total: " + time / 1000 + " s |  " + time + " ms ");

	}

	private ITab mock() {
		long initTime = Calendar.getInstance().getTimeInMillis();
		List<IBean> objects = new ArrayList<>();
		for (int i = 0; i < 2000; i++) {
			BodyBean bean = new BodyBean();
			bean.setIdentification("123");
			bean.setName("Cada da Massa");
			bean.setAddress("Rua 1");
			bean.setSpecialty("Massas");
			bean.setDocument("123456789");
			bean.setDate(new Date());
			bean.setValor(2.0);
			objects.add(bean);
		}

		HeaderBean header = new HeaderBean();
		header.setName("Mauricio");
		header.setDtPeriod(new Period(new Date(), new Date()));
		header.setTypeSearch("CPF");
		header.setSearchValue("111.111.111-11");

		long finalTime = Calendar.getInstance().getTimeInMillis();

		long time = finalTime - initTime;

		System.out.println("Tempo total na geração mock: " + time / 1000 + " s |  " + time + " ms ");
		return new Tab(header, objects);

	}

	private ITab mock2() {
		long initTime = Calendar.getInstance().getTimeInMillis();
		List<IBean> objects = new ArrayList<>();
		for (int i = 0; i < 2000; i++) {
			BodyBean bean = new BodyBean();
			bean.setIdentification("123");
			bean.setName("Cada da Massa");
			bean.setAddress("Rua 1");
			bean.setSpecialty("Massas");
			bean.setDocument("123456789");
			bean.setDate(new Date());
			bean.setValor(2.0);
			objects.add(bean);
		}

		HeaderBean header = new HeaderBean();
		header.setName("Mauricio");
		header.setDtPeriod(new Period(new Date(), new Date()));
		header.setTypeSearch("CPF");
		header.setSearchValue("111.111.111-11");

		long finalTime = Calendar.getInstance().getTimeInMillis();

		long time = finalTime - initTime;

		System.out.println("Tempo total na geração mock: " + time / 1000 + " s |  " + time + " ms ");
		return new Tab2(header, objects);

	}
}