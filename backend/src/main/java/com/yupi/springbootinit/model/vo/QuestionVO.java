package com.yupi.springbootinit.model.vo;

import cn.hutool.json.JSONUtil;
import com.yupi.springbootinit.model.dto.question.JudgeConfig;
import com.yupi.springbootinit.model.entity.Question;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目封装类
 * @TableName question
 */

@Data
public class QuestionVO implements Serializable {

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目提交数
     */
    private Integer submitNum;

    /**
     * 题目通过数
     */
    private Integer acceptNum;


    /**
     * 判题配置(json 对象)
     */
    private JudgeConfig judgeConfig;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建题目人信息
     */
    private UserVO userVO;
    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
    /**
     * 包装类转对象
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tagList = questionVO.getTags();
        if(tagList != null) question.setTags(JSONUtil.toJsonStr(tagList));

        String judgeConfig1 = question.getJudgeConfig();
        if(judgeConfig1 != null) question.setJudgeConfig(JSONUtil.toJsonStr(judgeConfig1));

        return question;
    }

    /**
     * 对象转包装类
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        List<String> tagList = JSONUtil.toList(question.getTags(), String.class);
        questionVO.setTags(tagList);
        String judgeConfigStr = question.getJudgeConfig();
        questionVO.setJudgeConfig(JSONUtil.toBean(judgeConfigStr, JudgeConfig.class));
        return questionVO;
    }
}