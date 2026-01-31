package org.example.moomyeongso.domain.feedback.repository;

import org.example.moomyeongso.domain.feedback.entity.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
}
