package com.jp.wonfes.work.dao.mapper;


import java.util.List;

import com.jp.wonfes.work.dao.mapper.qo.SelectWorkInfoQoReq;
import com.jp.wonfes.work.dao.mapper.qo.SelectWorkInfoQoResp;

public interface WorkSearchMapper {
	List<SelectWorkInfoQoResp> selectWorkInfo(SelectWorkInfoQoReq qo);
}
