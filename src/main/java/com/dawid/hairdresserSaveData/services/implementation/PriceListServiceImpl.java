package com.dawid.hairdresserSaveData.services.implementation;

import com.dawid.hairdresserSaveData.entity.PriceList;
import com.dawid.hairdresserSaveData.repository.PriceListRepository;
import com.dawid.hairdresserSaveData.services.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PriceListServiceImpl implements PriceListService {

    PriceListRepository priceListRepository;

    @Autowired
    public PriceListServiceImpl(PriceListRepository priceListRepository){
        this.priceListRepository = priceListRepository;
    }

    @Override
    public PriceList findById(Long id) {

        Optional<PriceList> result = priceListRepository.findById(id);
        PriceList priceList = null;

        if (result.isPresent()) {
            priceList = result.get();
        }
        else {
            throw new RuntimeException("Did not find PriceList id - " + id);
        }
        return priceList;
    }

    @Override
    public PriceList save(PriceList priceList) {
        return priceListRepository.save(priceList);
    }

    @Override
    public void deleteById(Long id) {
        priceListRepository.deleteById(id);
    }

    @Override
    public List<PriceList> findByCategory(String category) {
        return priceListRepository.findByCategory(category);
    }
}
