package org.example.moomyeongso.admin.topic.service;

import lombok.RequiredArgsConstructor;
import org.example.moomyeongso.domain.topic.dto.request.TopicRequestDto;
import org.example.moomyeongso.domain.topic.entity.Topic;
import org.example.moomyeongso.domain.topic.entity.TopicStatus;
import org.example.moomyeongso.domain.topic.repository.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminTopicService {

    private final TopicRepository topicRepository;

    @Transactional("mongoTransactionManager")
    public void createTopic(TopicRequestDto dto) {
        Topic topic = Topic.builder()
                .title(dto.title())
                .subtitle(dto.subtitle())
                .status(TopicStatus.READY)
                .build();

        topicRepository.save(topic);
    }
}