package br.com.iofile.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.iofile.enums.HeaderStrategyEnum;

/**
 * Anotation responsavel por manter a cnfiguracao do Header do arquivo
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 15/06/2017 18:47:39
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Header {

	/**
	 * Representa o espaco reservado pelo header
	 *
	 * @return proxima linha
	 */
	int size() default 0;

	/**
	 * representa a estrategia para o alinhamento do header
	 *
	 * @return {@link HeaderStrategyEnum}
	 */
	HeaderStrategyEnum headerStrategy();
}