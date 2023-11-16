package com.mavaratech.myrealstate.repository;

import com.mavaratech.myrealstate.model.share.ShareEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareEstateRepository extends CrudRepository<ShareEntity,Long> {
    List<ShareEntity> findAllByShareFrom(String username);
    List<ShareEntity> findAllByShareTo(String username);

}
