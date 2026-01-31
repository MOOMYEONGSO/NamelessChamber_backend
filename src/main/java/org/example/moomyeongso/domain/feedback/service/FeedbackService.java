package org.example.moomyeongso.domain.feedback.service;

import lombok.RequiredArgsConstructor;
import org.example.moomyeongso.domain.feedback.dto.request.FeedbackRequestDto;
import org.example.moomyeongso.domain.feedback.dto.response.FeedbackResponseDto;
import org.example.moomyeongso.domain.feedback.entity.Feedback;
import org.example.moomyeongso.domain.feedback.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Transactional("mongoTransactionManager")
    public void createFeedback(FeedbackRequestDto request) {
        Feedback feedback = Feedback.create(request.content());
        feedbackRepository.save(feedback);
    }

    @Transactional(readOnly = true)
    public List<FeedbackResponseDto> getAllFeedbacks() {
        return feedbackRepository.findAll().stream().map(FeedbackResponseDto::from).toList();
    }
}
