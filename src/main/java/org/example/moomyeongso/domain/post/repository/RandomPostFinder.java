package org.example.moomyeongso.domain.post.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import org.example.moomyeongso.domain.post.entity.Post;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class RandomPostFinder {

    private final MongoTemplate mongoTemplate;

    public Optional<Post> find() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.sample(1)
        );

        AggregationResults<Post> result = mongoTemplate.aggregate(
                aggregation,
                Post.class,
                Post.class
        );

        return result.getMappedResults().stream().findFirst();
    }
}
