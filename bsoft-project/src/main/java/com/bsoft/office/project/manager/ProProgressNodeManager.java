package com.bsoft.office.project.manager;

import com.bsoft.office.project.vo.ProProgressNodeVO;

import java.util.List;

/**
 * @Author kh Lin
 * @Date 2021/4/19 16:47
 * @Description
 */
public interface ProProgressNodeManager {

    List<ProProgressNodeVO> getProProgressNodes (Integer id);

    void saveProProgressNodes(List<ProProgressNodeVO> list);

    void logoutProProgressNode(Integer id);
}
