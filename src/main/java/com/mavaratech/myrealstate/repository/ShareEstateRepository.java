package com.mavaratech.myrealstate.repository;

import com.mavaratech.myrealstate.model.share.ShareEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShareEstateRepository extends CrudRepository<ShareEntity, Long> {
    List<ShareEntity> findAllByShareFromAndToDateAfterOrderByToDateDesc(String username, LocalDateTime now);

    List<ShareEntity> findAllByShareToAndToDateAfterOrderByToDateDesc(String username, LocalDateTime now);

    Optional<ShareEntity> findByShareFromAndShareToAndBasicAndToDateAfter(String userfrom,String userTo,String basic,LocalDateTime now);
}
