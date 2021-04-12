package org.example.services;

import org.example.entities.Goods;
import org.example.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;


    public void create(Goods goods) {
        goodsRepository.save(goods);
    }


    public Goods findById(Integer id) {
        return goodsRepository.getById(id);
    }


    public void update(Goods goods) {
        goodsRepository.save(goods);
    }


    public void delete(Integer id) {
        goodsRepository.deleteById(id);
    }


    public List<Goods> getAll() {
        return goodsRepository.findAll();
    }

    public void save(Goods goods){
        goodsRepository.save(goods);
    }
}
