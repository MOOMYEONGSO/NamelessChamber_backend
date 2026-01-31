package org.example.moomyeongso.domain.auth.repository;

import org.example.moomyeongso.domain.auth.entity.RefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends MongoRepository<RefreshToken, String> {

    Optional<RefreshToken> findByUserId(String userId);

    void deleteByUserId(String userId);
}
