package com.aristidas.avatars.repository;

import com.aristidas.avatars.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    List<Avatar> findByAgentType(String agentType);
}
