package br.com.iofile.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.imageio.IIOException;

import br.com.iofile.interfaces.IBean;

public abstract class Util {

	/**
	 * Atributo METHOD_WITH_SET tipo {@link String} que atende ao metodo method
	 */
	private static final String METHOD_WITH_SET = "set";

	/**
	 * Atributo METHOD_WITH_GET tipo {@link String} que atende ao metodo method
	 */
	private static final String METHOD_WITH_GET = "get";

	/**
	 * Método responspavel por recuperar o method pelo filed Name {@link IBean}
	 *
	 * @param model
	 *            {@link IBean}
	 * @param fieldName
	 *            nome do atributo
	 * @return {@link Method}' fildName
	 * @throws IIOException
	 *             exception
	 */
	public static <M extends Object> Method method(M model, String fieldName) throws IIOException {
		Method[] methods = model.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().startsWith(METHOD_WITH_SET) && Modifier.isPublic(method.getModifiers())
					&& method.getName().toUpperCase().contains(fieldName.toUpperCase())) {
				return method;
			}
		}
		throw new IIOException("Setter method for the field " + fieldName + " does not exist");
	}

	/**
	 * Método responspavel por recuperar o method pelo filed Name {@link IBean}
	 *
	 * @param model
	 *            {@link IBean}
	 * @param fieldName
	 *            nome do atributo
	 * @return {@link Method}' fildName
	 * @throws IIOException
	 *             exception
	 */
	public static <M extends Object> Method methodGet(M model, String fieldName) throws IIOException {
		Method[] methods = model.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().startsWith(METHOD_WITH_GET) && Modifier.isPublic(method.getModifiers())
					&& method.getName().toUpperCase().contains(fieldName.toUpperCase())) {
				return method;
			}
		}
		throw new IIOException("Getter method for the field " + fieldName + " does not exist");
	}

}
