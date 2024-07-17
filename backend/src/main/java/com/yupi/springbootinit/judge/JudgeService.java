package com.yupi.springbootinit.judge;


import com.yupi.springbootinit.model.entity.QuestionSubmit;

public interface JudgeService {
    QuestionSubmit doJudge(long questionSubmitId);
}
