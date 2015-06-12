package com.memories.persistence;

import com.memories.domain.FriendRelation;
import org.springframework.data.repository.CrudRepository;

public interface FriendRelationsRepository extends CrudRepository<FriendRelation, Long> {
}
