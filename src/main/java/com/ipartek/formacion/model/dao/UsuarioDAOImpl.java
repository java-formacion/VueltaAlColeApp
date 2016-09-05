package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.model.DataBaseHelperImpl;
import com.ipartek.formacion.pojo.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static UsuarioDAOImpl INSTANCE = null;
	private static DataBaseHelperImpl db;
	private Connection conect;

	private UsuarioDAOImpl() {
		// TODO Auto-generated constructor stub
		db = DataBaseHelperImpl.getInstance();
	}

	public static UsuarioDAOImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOImpl();
		}
		return INSTANCE;
	}

	@Override()
	public boolean guardar(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override()
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override()
	public Usuario buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override()
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override()
	public Usuario checkLogin(String nombre, String pass) {
		// TODO Auto-generated method stub
		Usuario user = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		final String sql = "select id, nombre, email, password from usuario where nombre = ? AND password = ?;";

		try {
			this.conect = db.getConexion();
			ps = this.conect.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new Usuario();
				user.setId(rs.getInt("id"));
				user.setNombre(rs.getString("nombre"));
				user.setPassword(rs.getString("pass"));
				user.setEmail(rs.getString("email"));
			}
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				this.db.desconectar();
			} catch (final Exception e2) {
				// TODO: handle exception
			}

		}

		return user;
	}

}