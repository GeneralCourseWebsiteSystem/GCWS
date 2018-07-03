package com.cqut.codeTableManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.codeTableManagement.dao.CodeTableDao;
import com.cqut.codeTableManagement.entity.CodeTable;
import com.cqut.common.util.DBUtil;
import com.cqut.common.util.StringUtil;

public class CodeTableImpl implements CodeTableDao {

	@Override
	public ArrayList<CodeTable> getAllCodeTable() {
		String sql = "SELECT * FROM code_table WHERE is_delete = 0 GROUP BY param_code;";
		ArrayList<CodeTable> codeTables = new ArrayList<CodeTable>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String paramCode = rs.getString(2);
				String paramName = rs.getString(3);
				String paramText = rs.getString(4);
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Integer level = rs.getInt(6);
				String codeType = rs.getString(7);
				Byte hasChild = rs.getByte(8);
				Date createTime = rs.getTimestamp(9);
				Byte isDelete = rs.getByte(10);
				String remark = rs.getString(11);
				CodeTable ac = new CodeTable(id, paramCode, paramName, paramText, parentCode, level,codeType, hasChild, createTime, isDelete, remark);
				codeTables.add(ac);
			}
			return codeTables;
		} catch(Exception e) {
			e.printStackTrace();
			return codeTables;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public CodeTable getById(String ctid) {
		String sql = "SELECT * FROM code_table WHERE is_delete = 0 AND id = " + ctid + ";";
		ArrayList<CodeTable> codeTables = new ArrayList<CodeTable>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String paramCode = rs.getString(2);
				String paramName = rs.getString(3);
				String paramText = rs.getString(4);
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Integer level = rs.getInt(6);
				String codeType = rs.getString(7);
				Byte hasChild = rs.getByte(8);
				Date createTime = rs.getTimestamp(9);
				Byte isDelete = rs.getByte(10);
				String remark = rs.getString(11);
				CodeTable ac = new CodeTable(id, paramCode, paramName, paramText, parentCode, level,codeType, hasChild, createTime, isDelete, remark);
				codeTables.add(ac);
			}
			return codeTables.get(0);
		} catch(Exception e) {
			e.printStackTrace();
			return codeTables.get(0);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<CodeTable> getNullParentCode() {
		String sql = "SELECT * FROM code_table WHERE is_delete = 0 AND ISNULL(parent_code) GROUP BY param_code;";
		ArrayList<CodeTable> codeTables = new ArrayList<CodeTable>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String paramCode = rs.getString(2);
				String paramName = rs.getString(3);
				String paramText = rs.getString(4);
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Integer level = rs.getInt(6);
				String codeType = rs.getString(7);
				Byte hasChild = rs.getByte(8);
				Date createTime = rs.getTimestamp(9);
				Byte isDelete = rs.getByte(10);
				String remark = rs.getString(11);
				CodeTable ac = new CodeTable(id, paramCode, paramName, paramText, parentCode, level,codeType, hasChild, createTime, isDelete, remark);
				codeTables.add(ac);
			}
			return codeTables;
		} catch(Exception e) {
			e.printStackTrace();
			return codeTables;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<CodeTable> getByParentCode(String pc) {
		String sql = "SELECT * FROM code_table WHERE is_delete = 0 AND parent_code = " + pc + ";";
		ArrayList<CodeTable> codeTables = new ArrayList<CodeTable>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String paramCode = rs.getString(2);
				String paramName = rs.getString(3);
				String paramText = rs.getString(4);
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Integer level = rs.getInt(6);
				String codeType = rs.getString(7);
				Byte hasChild = rs.getByte(8);
				Date createTime = rs.getTimestamp(9);
				Byte isDelete = rs.getByte(10);
				String remark = rs.getString(11);
				CodeTable ac = new CodeTable(id, paramCode, paramName, paramText, parentCode, level,codeType, hasChild, createTime, isDelete, remark);
				codeTables.add(ac);
			}
			return codeTables;
		} catch(Exception e) {
			e.printStackTrace();
			return codeTables;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean addACodeTable(CodeTable codeTable) {
		String sql = "INSERT INTO code_table (param_code, param_name, param_text, parent_code, level, has_child,"
				+ " create_time, is_delete, remark) VALUES (?,?,?,?,?,?,?,?,?);";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, codeTable.getParamCode());
			pstm.setString(2, codeTable.getParamName());
			pstm.setString(3, codeTable.getParamText());
			pstm.setString(4, codeTable.getParentCode());
			pstm.setInt(5, codeTable.getLevel());
			pstm.setByte(6, codeTable.getHasChild());
			pstm.setDate(7, StringUtil.changeToSqlDate(new Date()));
			pstm.setByte(8, codeTable.getIsDelete());
			pstm.setString(9, codeTable.getRemark());
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
	public Boolean updateACodeTable(CodeTable codeTable) {
		String sql = "UPDATE code_table SET param_code = ?,param_name = ?, param_text=?, parent_code=?,"
				+ " level=?, has_child=?,create_time=?, is_delete = ?,remark=? WHERE id = ?;";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, codeTable.getParamCode());
			pstm.setString(2, codeTable.getParamName());
			pstm.setString(3, codeTable.getParamText());
			pstm.setString(4, codeTable.getParentCode());
			pstm.setInt(5, codeTable.getLevel());
			pstm.setByte(6, codeTable.getHasChild());
			pstm.setDate(7, StringUtil.changeToSqlDate(new Date()));
			pstm.setByte(8, codeTable.getIsDelete());
			pstm.setString(9, codeTable.getRemark());
			pstm.setInt(10, codeTable.getId());
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
		String sql = "UPDATE code_table SET is_delete = 1 WHERE id = ?;";
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

	@Override
	public CodeTable getByPrarmCode(String pc) {
		String sql = "SELECT * FROM code_table WHERE is_delete = 0 AND param_code = " + pc + ";";
		ArrayList<CodeTable> codeTables = new ArrayList<CodeTable>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String paramCode = rs.getString(2);
				String paramName = rs.getString(3);
				String paramText = rs.getString(4);
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Integer level = rs.getInt(6);
				String codeType = rs.getString(7);
				Byte hasChild = rs.getByte(8);
				Date createTime = rs.getTimestamp(9);
				Byte isDelete = rs.getByte(10);
				String remark = rs.getString(11);
				CodeTable ac = new CodeTable(id, paramCode, paramName, paramText, parentCode, level,codeType, hasChild, createTime, isDelete, remark);
				codeTables.add(ac);
			}
			return codeTables.get(0);
		} catch(Exception e) {
			e.printStackTrace();
			return codeTables.get(0);
		} finally {
			DBUtil.close(connection);
		}
	}

}
