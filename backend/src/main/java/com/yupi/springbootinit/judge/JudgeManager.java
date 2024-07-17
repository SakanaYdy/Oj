package com.yupi.springbootinit.judge;

import com.yupi.springbootinit.judge.codesandbox.strategy.DefaultJudgeStrategy;
import com.yupi.springbootinit.judge.codesandbox.strategy.JavaLanguageJudgeStrategy;
import com.yupi.springbootinit.judge.codesandbox.strategy.JudgeContext;
import com.yupi.springbootinit.judge.codesandbox.strategy.JudgeStrategy;
import com.yupi.springbootinit.model.entity.QuestionSubmit;
import com.yupi.springbootinit.judge.codesandbox.model.JudgeInfo;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
