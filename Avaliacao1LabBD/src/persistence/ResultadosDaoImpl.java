package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import entity.QuartasdeFinal;
import entity.Resultados;

public class ResultadosDaoImpl implements ResultadosDao {

	private Connection c;
	
	public ResultadosDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	
	@Override
	public List<Resultados> resultadosGrupos(String grupo) {
		List<Resultados> lista = new ArrayList<>(); 
		String query = "select * from dbo.grupo(?) ";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement( query );
			ps.setString(1, grupo );
			ResultSet rs = ps.executeQuery();
			
			
			while( rs.next() ) {
			Resultados r = new Resultados();

			r.setNome_time(rs.getString("nome_time"));
			r.setNum_jogos_disputados(rs.getInt("num_jogos_disputados"));
			r.setVitorias(rs.getInt("vitorias"));
			r.setEmpates(rs.getInt("empates"));
			r.setDerrotas(rs.getInt("derrotas"));
			r.setGols_marcados(rs.getInt("gols_marcados"));
			r.setGols_sofridos(rs.getInt("gols_sofridos"));
			r.setSaldo_gols(rs.getInt("saldo_gols"));
			r.setPontos(rs.getInt("pontos"));
			lista.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Resultados> resultadosGeral() {
		List<Resultados> lista = new ArrayList<>(); 
		String query = "select * from dbo.fn_campeonato() order by pontos desc, vitorias desc, gols_marcados desc, saldo_gols desc";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement( query );
			ResultSet rs = ps.executeQuery();
			
			
			while( rs.next() ) {
			Resultados r = new Resultados();

			r.setNome_time(rs.getString("nome_time"));
			r.setNum_jogos_disputados(rs.getInt("num_jogos_disputados"));
			r.setVitorias(rs.getInt("vitorias"));
			r.setEmpates(rs.getInt("empates"));
			r.setDerrotas(rs.getInt("derrotas"));
			r.setGols_marcados(rs.getInt("gols_marcados"));
			r.setGols_sofridos(rs.getInt("gols_sofridos"));
			r.setSaldo_gols(rs.getInt("saldo_gols"));
			r.setPontos(rs.getInt("pontos"));
			lista.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<QuartasdeFinal> quartasDeFinal(String grupo) {
		List<QuartasdeFinal> lista = new ArrayList<>(); 
		String query = "select * from dbo.fn_quartas(?)";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement( query );
			ps.setString(1, grupo );
			ResultSet rs = ps.executeQuery();
			
			
			while( rs.next() ) {
				
				QuartasdeFinal qt = new QuartasdeFinal();

				qt.setTimeA(rs.getString("timeA"));
				qt.setTimeB(rs.getString("timeB"));

			lista.add(qt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<Resultados> rebaixados() {
		List<Resultados> lista = new ArrayList<>(); 
		String query = "select * from dbo.fn_rebaixados() ";
		PreparedStatement ps;
		try {
			ps = c.prepareStatement( query );
			ResultSet rs = ps.executeQuery();
			
			
			while( rs.next() ) {
			Resultados r = new Resultados();

			r.setNome_time(rs.getString("nome_time"));
			r.setNum_jogos_disputados(rs.getInt("num_jogos_disputados"));
			r.setVitorias(rs.getInt("vitorias"));
			r.setEmpates(rs.getInt("empates"));
			r.setDerrotas(rs.getInt("derrotas"));
			r.setGols_marcados(rs.getInt("gols_marcados"));
			r.setGols_sofridos(rs.getInt("gols_sofridos"));
			r.setSaldo_gols(rs.getInt("saldo_gols"));
			r.setPontos(rs.getInt("pontos"));
			lista.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return lista;
	}

}
