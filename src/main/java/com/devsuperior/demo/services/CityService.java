package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
   public List<CityDTO> findAll(){
       List<City> list= cityRepository.findAll(Sort.by("name"));
       return list.stream().map(x->new CityDTO(x)).collect(Collectors.toList());
   }

    @Transactional
    public CityDTO insert(CityDTO dto) {
        City entity = new City();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity= cityRepository.save(entity);
        return new CityDTO(entity);
    }

}
