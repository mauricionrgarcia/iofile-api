package br.com.iofile.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.iofile.formatters.DefaultFormatter;
import br.com.iofile.interfaces.IFormatterValues;

/**
 *
 * Anotation responsavel por fazer o mapeamento do DTO para o arquivo
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version 1
 * @sinse 15/06/2017 12:26:57
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Values {

	/**
	 * Atributo que representa a posicao do objeto
	 *
	 * @return posicao
	 */
	int position();

	/**
	 * Atribtuo que representa o patter de conversao do objeto
	 *
	 * @return pattern
	 */
	String pattern() default "";

	/**
	 * Atributo que representa o converter <br>
	 * default {@link DefaultFormatter}
	 *
	 * @return {@link IFormatterValues} converter
	 */
	Class<? extends IFormatterValues<? extends Object>> formatted() default DefaultFormatter.class;

}