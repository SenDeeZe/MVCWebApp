package org.example.repositories;

import org.example.entities.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    Goods getById(Integer id);
}
