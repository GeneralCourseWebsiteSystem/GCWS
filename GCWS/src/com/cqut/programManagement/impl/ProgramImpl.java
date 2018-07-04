package com.cqut.programManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.common.util.DBUtil;
import com.cqut.common.util.StringUtil;
import com.cqut.programManagement.dao.ProgramDao;
import com.cqut.programManagement.entity.Program;

public class ProgramImpl implements ProgramDao {

	@Override
	public ArrayList<Program> getAllProgram(Integer index, Integer limit, String str) {
		String sql = "SELECT * FROM program WHERE is_delete = 0 AND program_name "
				+ "LIKE '%" + StringUtil.emptyOrNull(str) +"%' LIMIT " + index + ", " + limit + ";";
		ArrayList<Program> programList = new ArrayList<Program>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String programName = rs.getString(2);
				String programPath = rs.getString(3);
				String programCode = rs.getString(4);
				Date createTime = rs.getTimestamp(5);
				Byte isDelete = rs.getByte(6);
				String remark = rs.getString(7);
				Program ac = new Program(id, programName,programPath,programCode, createTime, isDelete, remark);
				programList.add(ac);
			}
			return programList;
		} catch(Exception e) {
			e.printStackTrace();
			return programList;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Integer getProgramSize(String str) {
		String sql = "SELECT * FROM program WHERE is_delete = 0 AND program_name "
				+ "LIKE '%" + StringUtil.emptyOrNull(str) +"%';";
		ArrayList<Program> programList = new ArrayList<Program>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String programName = rs.getString(2);
				String programPath = rs.getString(3);
				String programCode = rs.getString(4);
				Date createTime = rs.getTimestamp(5);
				Byte isDelete = rs.getByte(6);
				String remark = rs.getString(7);
				Program ac = new Program(id, programName,programPath,programCode, createTime, isDelete, remark);
				programList.add(ac);
			}
			return programList.size();
		} catch(Exception e) {
			e.printStackTrace();
			return programList.size();
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Program getById(String pid) {
		String sql = "SELECT * FROM program WHERE is_delete = 0 AND id = " + pid + ";";
		ArrayList<Program> programList = new ArrayList<Program>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String programName = rs.getString(2);
				String programPath = rs.getString(3);
				String programCode = rs.getString(4);
				Date createTime = rs.getTimestamp(5);
				Byte isDelete = rs.getByte(6);
				String remark = rs.getString(7);
				Program ac = new Program(id, programName,programPath,programCode, createTime, isDelete, remark);
				programList.add(ac);
			}
			return programList.get(0);
		} catch(Exception e) {
			e.printStackTrace();
			return programList.get(0);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean addAProgram(Program program) {
		String sql = "INSERT INTO program (program_name, program_path, program_code, create_time, is_delete, remark) VALUES (?,?,?,NOW(),?,?);";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, program.getProgramName());
			pstm.setString(2, program.getProgramPath());
			pstm.setString(3, program.getProgramCode());
			pstm.setByte(4, program.getIsDelete());
			pstm.setString(5, program.getRemark());
			pstm.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean updateAProgram(Program program) {
		String sql = "UPDATE program SET program_name = ?,program_path = ?, program_code =?,create_time=NOW(), is_delete = ?,remark=? WHERE id = ?;";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, program.getProgramName());
			pstm.setString(2, program.getProgramPath());
			pstm.setString(3, program.getProgramCode());
			pstm.setByte(4, program.getIsDelete());
			pstm.setString(5, program.getRemark());
			pstm.setInt(6, program.getId());
			pstm.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean deleteById(String id) {
		String sql = "UPDATE program SET is_delete = 1 WHERE id = ?;";
		Connection connection = DBUtil.open();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}

}
