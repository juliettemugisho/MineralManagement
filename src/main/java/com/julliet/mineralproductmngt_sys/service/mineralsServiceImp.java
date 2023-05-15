package com.julliet.mineralproductmngt_sys.service;

import com.julliet.mineralproductmngt_sys.model.Minerals;
import com.julliet.mineralproductmngt_sys.repository.MineralsReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class mineralsServiceImp implements MineralsService {
    @Autowired
    private MineralsReposirory soldierReposirory;

    @Override
    public Minerals saveMinerals(Minerals minerals) {
        return soldierReposirory.save(minerals);
    }

    @Override
    public Minerals updateMinerals(Minerals minerals) {
        return soldierReposirory.save(minerals);
    }

    @Override
    public Minerals findMinerals(Long id) {
        return soldierReposirory.findById(id).get();
    }

    @Override
    public List<Minerals> getAllMinerals() {
        return soldierReposirory.findAll() ;
    }

    @Override
    public void deleteMinerals(Long id) {
     soldierReposirory.deleteById(id);
    }

    @Override
    public Page<Minerals> pagenateStudent(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo -1,pageSize);
        return this.soldierReposirory.findAll(pageable);
    }
}
