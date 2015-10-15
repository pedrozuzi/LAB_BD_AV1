package entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotação das colunas da Tabela
 * @author Pedro Zuzi
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Coluna {

	/**
	 * Método para definir a posição da coluna na tabela
	 * @return Número da coluna
	 */
	int posicao();

	/**
	 * Método para definir o nome da coluna na tabela
	 * @return Nome da coluna
	 */
	String nome();

}
