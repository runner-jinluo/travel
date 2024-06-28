package com.example.demo.service;

import com.example.demo.model.Scenic_Spot;
import com.example.demo.repository.Scenic_SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Scenic_SpotServiceImpl implements Scenic_SpotService{
    @Autowired
    private  Scenic_SpotRepository scenic_spotRepository;

    @Override
    public List<Scenic_Spot> getAllScenic_Spot() {
        return scenic_spotRepository.findAll();
    }


}

