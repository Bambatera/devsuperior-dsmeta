package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leandro Menezes
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
