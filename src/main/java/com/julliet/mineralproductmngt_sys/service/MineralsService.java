package com.julliet.mineralproductmngt_sys.service;

import com.julliet.mineralproductmngt_sys.model.Minerals;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MineralsService {
    public Minerals saveMinerals(Minerals soldier);
    public Minerals updateMinerals(Minerals minerals);
    public Minerals findMinerals(Long id);
    public List<Minerals> getAllMinerals();
    public void deleteMinerals(Long id);
    Page<Minerals> pagenateStudent(int pageNo, int pageSize);

}
