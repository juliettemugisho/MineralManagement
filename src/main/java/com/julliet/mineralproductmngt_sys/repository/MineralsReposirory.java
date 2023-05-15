package com.julliet.mineralproductmngt_sys.repository;

import com.julliet.mineralproductmngt_sys.model.Minerals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MineralsReposirory extends JpaRepository<Minerals,Long> {
}
