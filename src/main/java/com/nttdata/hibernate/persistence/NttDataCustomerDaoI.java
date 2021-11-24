package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * AGR - Hibernate - Taller 2
 * 
 * DAO de Tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author aguerrre
 *
 */
public interface NttDataCustomerDaoI extends CommonDaoI<NttDataCustomer> {
	
	/**
	 * 
	 * Busca un Cliente por nombre y dos apellidos
	 * 
	 * @param name
	 *            - nombre del Cliente
	 * @param firstSurname
	 *            - primer apellido del Cliente
	 * @param secondSurname
	 *            - segundo apelldio del Cliente
	 * 
	 * @return List<NttDataCustomer> - Lista de Clientes
	 */
	public List<NttDataCustomer> searchByNameAndSurname(final String name, final String firstSurname, final String secondSurname);

}
