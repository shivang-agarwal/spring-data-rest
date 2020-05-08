package org.decimalbits.springdatarest.repository;

import org.decimalbits.springdatarest.model.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "activities", collectionResourceRel = "activities")
public interface ActivityRepository extends PagingAndSortingRepository<Activity, String> {
    public Activity findByTargetDate(@Param("date") String targetDate);
}
