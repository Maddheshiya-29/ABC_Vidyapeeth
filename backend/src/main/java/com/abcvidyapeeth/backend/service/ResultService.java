package com.abcvidyapeeth.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcvidyapeeth.backend.entity.Result;
import com.abcvidyapeeth.backend.repository.ResultRepository;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    public Result updateResult(Long id, Result result) {
        Result existingResult = resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));

        existingResult.setStudentName(result.getStudentName());
        existingResult.setExamName(result.getExamName());
        existingResult.setResult(result.getResult());

        return resultRepository.save(existingResult);
    }

    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}
