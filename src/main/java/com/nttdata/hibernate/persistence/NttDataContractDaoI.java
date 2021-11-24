package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * AGR - Hibernate - Taller 2
 * 
 * DAO de Tabla NTTDATA_TH1_CONTRACT
 * 
 * @author aguerrre
 *
 */
public interface NttDataContractDaoI extends CommonDaoI<NttDataContract> {

	/**
	 * Busca los contratos de un determinado Cliente por ID.
	 * 
	 * @param customerId
	 *            - ID del cliente.
	 * @return List<NttDataContract> - Lista de Contratos.
	 */
	public List<NttDataContract> searchByCustomerId(final Long customerId);

}
