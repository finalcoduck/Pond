package com.coduck.pond.group.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coduck.pond.group.vo.GroupMemNumDto;
import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupMem_smDto;
import com.coduck.pond.group.vo.GroupVo;


@Repository
public class GroupDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.groupMapper.";
	
	public void insertGroup(GroupVo groupVo) {
		session.insert(NAMESPACE+"insertGroup", groupVo);
	}
	
	public List<GroupVo> selectGroupList(String memEmail) {
		return session.selectList(NAMESPACE+"selectGroupList", memEmail);
	}
	
	public GroupVo selectGroup(int groupNum) {
		return session.selectOne(NAMESPACE+"selectGroup", groupNum);
	}
	
	public int deleteGroup(int groupNum) {
		return session.delete(NAMESPACE+"deleteGroup",groupNum);
	}
	
	public void insertGroupMem(GroupMemVo groupMemVo) {
		session.insert(NAMESPACE+"insertGroupMem", groupMemVo);
	}
	
	public int getGroupNum(String inviteCodeS, String inviteCodeM) {
		Map<String, String> map = new HashMap<>();
		map.put("inviteCodeS", inviteCodeS);
		map.put("inviteCodeM", inviteCodeM);
		return session.selectOne(NAMESPACE+"getGroupNum", map);
	}
	
	public List<GroupMemNumDto> getGroupMemNum(String memEmail){
		return session.selectList(NAMESPACE+"getGroupMemNum", memEmail);
	}
	
	public GroupMemNumDto getGroupMemCount(int groupNum){
		return session.selectOne(NAMESPACE+"getGroupMemCount", groupNum);
	}
	
	
	public GroupMemVo dupliInviteCode(Map<String, String> map) {
		return session.selectOne(NAMESPACE+"dupliInviteCode", map);
	}
	
	public Map<String, List<GroupMem_smDto>> getGroupMemList(String groupNum){
		List<GroupMem_smDto> mList = session.selectList(NAMESPACE+"getGroupMemListM", groupNum);
		List<GroupMem_smDto> sList = session.selectList(NAMESPACE+"getGroupMemListS", groupNum);
		Map<String, List<GroupMem_smDto>> map = new HashMap<>();
		map.put("mList", mList);
		map.put("sList", sList);
		return map;
	}
	
	public void updateGroupAddr(Map<String, Object> map) {
		session.update(NAMESPACE+"updateGroupAddress", map);
	}
	
	public void updateGroupPhone(Map<String, Object> map) {
		session.update(NAMESPACE+"updateGroupPhone", map);
	}
	public void updateAttendedQRCode(GroupVo groupVo) {
		session.update(NAMESPACE+"updateAttendedQRCode", groupVo);
	}
}
