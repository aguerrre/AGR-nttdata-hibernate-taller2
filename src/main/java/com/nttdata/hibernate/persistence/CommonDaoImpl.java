package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * AGR - Hibernate - Taller 2
 * 
 * DAO Genérico Implementación
 * 
 * @author aguerrre
 *
 */
public class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión a BD */
	private Session session;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(T paramT) {

		// Confirmación de Transaccion activa.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción del dato.
		session.save(paramT);
		session.flush();

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public void update(T paramT) {

		// Confirmación de Transaccion activa.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Actualizar o insertar el dato.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public void delete(T paramT) {

		// Confirmación de Transaccion activa.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Borrado del dato.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public T searchById(Long id) {

		// Confirmación de Transaccion activa.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtención del Objeto genérico por PK.
		T result = session.get(this.entityClass, id);

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Confirmación de Transaccion activa.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtención de todos los registros de una tabla (viene dada por el nombre de la clase).
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
