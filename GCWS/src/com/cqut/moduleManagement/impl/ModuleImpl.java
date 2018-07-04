package com.cqut.moduleManagement.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.common.util.DBUtil;
import com.cqut.common.util.StringUtil;
import com.cqut.moduleManagement.dao.ModuleDao;
import com.cqut.moduleManagement.entity.Module;

public class ModuleImpl implements ModuleDao {

	@Override
	public ArrayList<Module> getAllList() {
		String sql = "SELECT * FROM module WHERE is_delete = 0 GROUP BY module_code;";
		ArrayList<Module> moduleList = new ArrayList<Module>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String moduleCode = rs.getString(2);
				String moduleName = rs.getString(3);
				String modulePath = StringUtil.emptyGetItalic(rs.getString(4));
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Byte isMenu = rs.getByte(6);
				String level = rs.getString(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				Module ac = new Module(id, moduleCode,moduleName, modulePath, parentCode, isMenu, level, createTime, isDelete, remark);
				moduleList.add(ac);
			}
			return moduleList;
		} catch(Exception e) {
			e.printStackTrace();
			return moduleList;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Module getById(String mid) {
		String sql = "SELECT * FROM module WHERE is_delete = 0 AND id = " + mid +";";
		ArrayList<Module> moduleList = new ArrayList<Module>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String moduleCode = rs.getString(2);
				String moduleName = rs.getString(3);
				String modulePath = StringUtil.emptyGetItalic(rs.getString(4));
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Byte isMenu = rs.getByte(6);
				String level = rs.getString(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				Module ac = new Module(id, moduleCode,moduleName, modulePath, parentCode, isMenu, level, createTime, isDelete, remark);
				moduleList.add(ac);
			}
			return moduleList.get(0);
		} catch(Exception e) {
			e.printStackTrace();
			return moduleList.get(0);
		} finally {
			DBUtil.close(connection);
		}
	}
	
	@Override
	public Module getByIdWithNotItalic(String mid) {
		String sql = "SELECT * FROM module WHERE is_delete = 0 AND id = " + mid +";";
		ArrayList<Module> moduleList = new ArrayList<Module>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String moduleCode = rs.getString(2);
				String moduleName = rs.getString(3);
				String modulePath = StringUtil.emptyOrNull(rs.getString(4));
				String parentCode = StringUtil.emptyOrNull(rs.getString(5));
				Byte isMenu = rs.getByte(6);
				String level = rs.getString(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				Module ac = new Module(id, moduleCode,moduleName, modulePath, parentCode, isMenu, level, createTime, isDelete, remark);
				moduleList.add(ac);
			}
			return moduleList.get(0);
		} catch(Exception e) {
			e.printStackTrace();
			return moduleList.get(0);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public Boolean addAModule(Module module) {
		String sql = "INSERT INTO module (module_code, module_name, module_path, parent_code, is_menu, level, create_time, is_delete, remark) VALUES (?,?,?,?,?,?,?,?,?);";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, module.getModuleCode());
			pstm.setString(2, module.getModuleName());
			pstm.setString(3, module.getModulePath());
			pstm.setString(4, module.getParentCode());
			pstm.setByte(5, module.getIsMenu());
			pstm.setString(6, module.getLevel());
			pstm.setDate(7, StringUtil.changeToSqlDate(new Date()));
			pstm.setByte(8, module.getIsDelete());
			pstm.setString(9, module.getRemark());
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
	public Boolean updateAModule(Module module) {
		String sql = "UPDATE module SET module_code = ?,module_name = ?, module_path=?,parent_code=?,is_menu=?,level=?,create_time=?, is_delete = ?,remark=? WHERE id = ?";
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, module.getModuleCode());
			pstm.setString(2, module.getModuleName());
			pstm.setString(3, module.getModulePath());
			pstm.setString(4, module.getParentCode());
			pstm.setByte(5, module.getIsMenu());
			pstm.setString(6, module.getLevel());
			pstm.setDate(7, StringUtil.changeToSqlDate(new Date()));
			pstm.setByte(8, module.getIsDelete());
			pstm.setString(9, module.getRemark());
			pstm.setInt(10, module.getId());
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
		String sql = "UPDATE module SET is_delete = 1 WHERE id = ?;";
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
	public Module getByModuleCode(String mc) {
		String sql = "SELECT * FROM module WHERE is_delete = 0 AND module_code = '"+ mc +"' GROUP BY module_code;";
		ArrayList<Module> moduleList = new ArrayList<Module>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String moduleCode = rs.getString(2);
				String moduleName = rs.getString(3);
				String modulePath = StringUtil.emptyGetItalic(rs.getString(4));
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Byte isMenu = rs.getByte(6);
				String level = rs.getString(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				Module ac = new Module(id, moduleCode,moduleName, modulePath, parentCode, isMenu, level, createTime, isDelete, remark);
				moduleList.add(ac);
			}
			return moduleList.get(0);
		} catch(Exception e) {
			e.printStackTrace();
			return moduleList.get(0);
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<Module> getByParentCode(String pc) {
		String sql = "SELECT * FROM module WHERE is_delete = 0 AND parent_code = '"+ pc+"' GROUP BY module_code;";
		ArrayList<Module> moduleList = new ArrayList<Module>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String moduleCode = rs.getString(2);
				String moduleName = rs.getString(3);
				String modulePath = StringUtil.emptyGetItalic(rs.getString(4));
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Byte isMenu = rs.getByte(6);
				String level = rs.getString(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				Module ac = new Module(id, moduleCode,moduleName, modulePath, parentCode, isMenu, level, createTime, isDelete, remark);
				moduleList.add(ac);
			}
			return moduleList;
		} catch(Exception e) {
			e.printStackTrace();
			return moduleList;
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public ArrayList<Module> getNullParentCode() {
		String sql = "SELECT * FROM module WHERE is_delete = 0 AND ISNULL(parent_code) GROUP BY module_code;";
		ArrayList<Module> moduleList = new ArrayList<Module>();
		Connection connection = DBUtil.open();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Integer id = rs.getInt(1);
				String moduleCode = rs.getString(2);
				String moduleName = rs.getString(3);
				String modulePath = StringUtil.emptyGetItalic(rs.getString(4));
				String parentCode = StringUtil.emptyGetItalic(rs.getString(5));
				Byte isMenu = rs.getByte(6);
				String level = rs.getString(7);
				Date createTime = rs.getTimestamp(8);
				Byte isDelete = rs.getByte(9);
				String remark = rs.getString(10);
				Module ac = new Module(id, moduleCode,moduleName, modulePath, parentCode, isMenu, level, createTime, isDelete, remark);
				moduleList.add(ac);
			}
			return moduleList;
		} catch(Exception e) {
			e.printStackTrace();
			return moduleList;
		} finally {
			DBUtil.close(connection);
		}
	}
}
