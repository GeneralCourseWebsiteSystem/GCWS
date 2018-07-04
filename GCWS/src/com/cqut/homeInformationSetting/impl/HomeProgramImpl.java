package com.cqut.homeInformationSetting.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.common.util.DBUtil;
import com.cqut.common.util.StringUtil;
import com.cqut.homeInformationSetting.dao.HomeInformationDao;
import com.cqut.homeInformationSetting.entity.HomeProgram;

public class HomeProgramImpl implements HomeInformationDao {

	@Override
	public ArrayList<HomeProgram> getAllHomeProgram(Integer index, Integer limit, String str) {
		String sql = "SELECT hp.id, p.id, p.program_name, p.program_path, p.program_code, hp.is_show,"
				+ " hp.show_no, hp.width, hp.height,hp.css_name,hp.create_time,hp.is_delete,hp.remark"
				+ " FROM home_program hp, program p WHERE hp.program_id = p.id AND p.is_delete = 0 AND "
				+ "hp.is_delete = 0 AND p.program_name LIKE '%" + StringUtil.emptyOrNull(str) + "%' GROUP BY hp.show_no"
				+ " LIMIT " + index + "," + limit + ";";
		ArrayList<HomeProgram> homePrograms = new ArrayList<HomeProgram>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer programId = rs.getInt(2);
				String programName = rs.getString(3);
				String programPath = rs.getString(4);
				String programCode = rs.getString(5);
				Byte isShow = rs.getByte(6);
				Integer showNo = rs.getInt(7);
				String width = rs.getString(8);
				String height = rs.getString(9);
				String cssName = rs.getString(10);
				Date createTime = rs.getTimestamp(11);
				Byte isDelete = rs.getByte(12);
				String remark = rs.getString(13);
				HomeProgram ac = new HomeProgram(id, programId,programName, programPath, programCode,isShow,
						showNo, width, height, cssName, createTime, isDelete, remark);
				homePrograms.add(ac);
			}
			return homePrograms;
		} catch(Exception e) {
			e.printStackTrace();
			return homePrograms;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Integer getAllHomeProgramSize(String str) {
		String sql = "SELECT hp.id, p.id, p.program_name, p.program_path, p.program_code, hp.is_show,"
				+ " hp.show_no, hp.width, hp.height,hp.css_name,hp.create_time,hp.is_delete,hp.remark"
				+ " FROM home_program hp, program p WHERE hp.program_id = p.id AND p.is_delete = 0 AND "
				+ "hp.is_delete = 0 AND p.program_name LIKE '%" + StringUtil.emptyOrNull(str) + "%';";
		ArrayList<HomeProgram> homePrograms = new ArrayList<HomeProgram>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer programId = rs.getInt(2);
				String programName = rs.getString(3);
				String programPath = rs.getString(4);
				String programCode = rs.getString(5);
				Byte isShow = rs.getByte(6);
				Integer showNo = rs.getInt(7);
				String width = rs.getString(8);
				String height = rs.getString(9);
				String cssName = rs.getString(10);
				Date createTime = rs.getTimestamp(11);
				Byte isDelete = rs.getByte(12);
				String remark = rs.getString(13);
				HomeProgram ac = new HomeProgram(id, programId,programName, programPath, programCode,isShow,
						showNo, width, height, cssName, createTime, isDelete, remark);
				homePrograms.add(ac);
			}
			return homePrograms.size();
		} catch(Exception e) {
			e.printStackTrace();
			return homePrograms.size();
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<HomeProgram> getShowHomeProgram() {
		String sql = "SELECT hp.id, p.id, p.program_name, p.program_path, p.program_code, hp.is_show,"
				+ " hp.show_no, hp.width, hp.height,hp.css_name,hp.create_time,hp.is_delete,hp.remark"
				+ " FROM home_program hp, program p WHERE hp.program_id = p.id AND p.is_delete = 0 AND "
				+ "hp.is_delete = 0 AND hp.is_show = 1 GROUP BY hp.show_no;";
		ArrayList<HomeProgram> homePrograms = new ArrayList<HomeProgram>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer programId = rs.getInt(2);
				String programName = rs.getString(3);
				String programPath = rs.getString(4);
				String programCode = rs.getString(5);
				Byte isShow = rs.getByte(6);
				Integer showNo = rs.getInt(7);
				String width = rs.getString(8);
				String height = rs.getString(9);
				String cssName = rs.getString(10);
				Date createTime = rs.getTimestamp(11);
				Byte isDelete = rs.getByte(12);
				String remark = rs.getString(13);
				HomeProgram ac = new HomeProgram(id, programId,programName, programPath, programCode,isShow,
						showNo, width, height, cssName, createTime, isDelete, remark);
				homePrograms.add(ac);
			}
			return homePrograms;
		} catch(Exception e) {
			e.printStackTrace();
			return homePrograms;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean updateHomeProgram(HomeProgram homeProgram) {
		String sql = "UPDATE home_program SET program_id = ?, is_show = ?, show_no = ?, width = ?, height = ?, "
				+ "css_name = ?, create_time = NOW(), is_delete = ?, remark = ? WHERE id = ?;";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, homeProgram.getProgramId());
			pstm.setByte(2, homeProgram.getIsShow());
			pstm.setInt(3, homeProgram.getShowNo());
			pstm.setString(4, homeProgram.getWidth());
			pstm.setString(5, homeProgram.getHeight());
			pstm.setString(6, homeProgram.getCssName());
			pstm.setByte(7, homeProgram.getIsDelete());
			pstm.setString(8, homeProgram.getRemark());
			pstm.setInt(9, homeProgram.getId());
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
	public HomeProgram getById(String hpId) {
		String sql = "SELECT hp.id, p.id, p.program_name, p.program_path, p.program_code, hp.is_show,"
				+ " hp.show_no, hp.width, hp.height,hp.css_name,hp.create_time,hp.is_delete,hp.remark"
				+ " FROM home_program hp, program p WHERE hp.program_id = p.id AND p.is_delete = 0 AND "
				+ "hp.is_delete = 0 AND hp.id=" + hpId + ";";
		ArrayList<HomeProgram> homePrograms = new ArrayList<HomeProgram>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				Integer programId = rs.getInt(2);
				String programName = rs.getString(3);
				String programPath = rs.getString(4);
				String programCode = rs.getString(5);
				Byte isShow = rs.getByte(6);
				Integer showNo = rs.getInt(7);
				String width = rs.getString(8);
				String height = rs.getString(9);
				String cssName = rs.getString(10);
				Date createTime = rs.getTimestamp(11);
				Byte isDelete = rs.getByte(12);
				String remark = rs.getString(13);
				HomeProgram ac = new HomeProgram(id, programId,programName, programPath, programCode,isShow,
						showNo, width, height, cssName, createTime, isDelete, remark);
				homePrograms.add(ac);
			}
			return homePrograms.get(0);
		} catch(Exception e) {
			e.printStackTrace();
			return homePrograms.get(0);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean deleteById(String id) {
		String sql = "UPDATE home_program SET is_delete = 1 WHERE id = ?;";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, id);
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
	public Boolean addAHomeProgram(HomeProgram homeProgram) {
		String sql = "INSERT INTO home_program (program_id, is_show, show_no, width, height, css_name, create_time, is_delete, remark) VALUES (?,?,?,?,?,?,NOW(),?,?);";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, homeProgram.getProgramId());
			pstm.setByte(2, homeProgram.getIsShow());
			pstm.setInt(3, homeProgram.getShowNo());
			pstm.setString(4, homeProgram.getWidth());
			pstm.setString(5, homeProgram.getHeight());
			pstm.setString(6, homeProgram.getCssName());
			pstm.setByte(7, homeProgram.getIsDelete());
			pstm.setString(8, homeProgram.getRemark());
			pstm.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}
}
